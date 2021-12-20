package Ch3

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

class TestProbeSpec extends TestKit(ActorSystem("TestProbeSpec")) with ImplicitSender with WordSpecLike with BeforeAndAfterAll {
//  Here we will be testing the master actor created below.
//  The master actor involves the use of slave actor.
//  the basic test assertions can not test this because there is no ability to test the interaction of master with slave
//  This becomes testable with the help of testProbes.

  /**
   * Test Probes are the fictitious actors that are useful for interaction with multiple actors.
   * They also provide assertion capabilities
   * Has same assertions like the testActor
   */

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  import TestProbeSpec._
  "Master actor" should {
    "register a slave" in {
      val master = system.actorOf(Props[Master])
      val slave = TestProbe("slave")


      master ! Register(slave.ref)
      expectMsg(RegisterSuccess)
    }

    "send workitem to the slave" in {
      val master = system.actorOf(Props[Master])
      val slave = TestProbe("slave")

      master ! Register(slave.ref)
      expectMsg(RegisterSuccess)

      val workString = "Hello there, from test probe"
      master ! Work(workString)
//      Setting expectation of input at slave
      slave.expectMsg(Task(workString, testActor))
//      mocking slave's response
      slave.reply(WorkCompleted(3, testActor))
//      expectation from master
      expectMsg(Report(3))
    }

    "correctly agreegate data" in {
      val master = system.actorOf(Props[Master])
      val slave = TestProbe("slave")

      master ! Register(slave.ref)
      expectMsg(RegisterSuccess)

      val workString = "Akka is Great"
      master ! Work(workString)
      master ! Work(workString)

      slave.receiveWhile(){
        case Task(`workString`, `testActor`) => slave.reply(WorkCompleted(3, testActor))
      }

      expectMsg(Report(3))
      expectMsg(Report(6))
    }
  }
}

// NEXT: Timed assertions

object TestProbeSpec {
  // scenario
  /**
    word counting actor hierarchy master-slave

    send some work to the master
      - master sends the slave the piece of work
      - slave processes the work and replies to master
      - master aggregates the result
    master sends the total count to the original requester
   */

  case class Register(slaveRef: ActorRef)
  case object RegisterSuccess
  case class Work(input: String)
  case class Task(input: String, sender: ActorRef)
  case class WorkCompleted(wordCount: Int, requester: ActorRef)
  case class Report(wordCount: Int)

  class Master extends Actor {
    override def receive: Receive = {
      case Register(slaveRef) =>
        sender ! RegisterSuccess
        context.become(online(slaveRef, 0))
    }

    def online(slaveRef: ActorRef, totalWordCount: Int): Receive = {
      case Work(text) =>
        slaveRef ! Task(text, sender())
      case WorkCompleted(count, originalRequester) =>
        val newTotalWordCount = totalWordCount + count
        originalRequester ! Report(newTotalWordCount)
        context.become(online(slaveRef, newTotalWordCount))
    }
  }
//  Slave actor class to be ignored
}
