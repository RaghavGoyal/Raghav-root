package Ch3

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class TimedAssertionsSpec extends TestKit(ActorSystem("TimedAssertions")) with ImplicitSender with WordSpecLike with BeforeAndAfterAll {

  /**
   * Actors may be performing some tasks that could be time sensitive.
   * For example interaction with a data base; If the interaction takes more than a certain time limit, it should be timed out
   * or, an actor should respond with some message in a finite duration.
   * Such assertions can be performed using timed assertions.
   */
  import TimedAssertionsSpec._

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Time calculation" should {
    val actor = system.actorOf(Props[TimeCalculation])

    "send response within 510 ms" in {
      within(510 millis) {
        actor ! "wait1"
        expectMsg(Response(22))
      }
    }

    "send response in at least 500 ms" in {
      within(500 millis, 1 seconds) {
        actor ! "wait1"
        expectMsg(Response(22))
      }
    }

    "send multiple response timely" in {
      within(1 seconds){
        actor ! "wait2"
        val results = receiveWhile[Int](max = 2 seconds, idle = 500 millis, messages = 5){
          case Response(result) => result
        }
        assert(results.nonEmpty)
      }
    }

    "reply to a test probe in timely manner" in {
      within(1 seconds){
        val probe = TestProbe()
        probe.send(actor, "wait1")
        probe.expectMsg(Response(22))
      }
    }
  }
}

// NEXT: Intercepting Logs

object TimedAssertionsSpec {
  case class Response(value: Int)

  class TimeCalculation extends Actor {
    override def receive: Receive = {
      case "wait1" =>
        Thread.sleep(500)
        sender() ! Response(22)

      case "wait2" =>
        for(i <- 1 to 5){
          Thread.sleep(i * 100)
          sender() ! Response(i)
        }
    }
  }
}
