package Ch4

import Ch4.SupervisionSpec.{FussyWordCounter, Report, Supervisor}
import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props, Terminated}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

class SupervisionSpec extends TestKit(ActorSystem("Supervision"))
  with ImplicitSender with WordSpecLike with BeforeAndAfterAll {

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "The one for one supervisor" should {
    "resume its child if a runtimeException occurs" in {
      val supervisor = system.actorOf(Props[Supervisor])
      supervisor ! Props[FussyWordCounter]
      val child = expectMsgType[ActorRef]

      child ! "Akka is good"
      child ! Report
      expectMsg[Int](3)

      child ! "This message is deliberately so so so long as it would result in runtime exception."
      child ! Report
      expectMsg[Int](3)   // because resume retains the previous state.
    }

    "should restart its child when a null pointer exception occurs" in {
      val supervisor = system.actorOf(Props[Supervisor])
      supervisor ! Props[FussyWordCounter]
      val child = expectMsgType[ActorRef]

      child ! "Akka is good"
      child ! Report
      expectMsg(3)

      child ! ""
      child ! Report
      expectMsg(0)    // with restart the internal state is lost
    }

    "should terminate its child when illegal argument exception occurs" in {
      val supervisor = system.actorOf(Props[Supervisor])
      supervisor ! Props[FussyWordCounter]
      val child = expectMsgType[ActorRef]

      watch(child)    // register watch to the child actor
      child ! "hello to the akka"   // small case will cause ILLEGAL ARG EXC.
      val response = expectMsgType[Terminated]    // With termination, terminated message is expected as watch is registered
      assert(response.actor == child)     // assert whether the terminated msg is for same child
    }

    "should escalate the error when exception occurs" in {
      val supervisor = system.actorOf(Props[Supervisor], "supervisor")
      supervisor ! Props[FussyWordCounter]
      val child = expectMsgType[ActorRef]

      watch(child)

      child ! 100
      val response = expectMsgType[Terminated]    // when escalating exception, all children are terminated.
      assert(response.actor == child)
    }
  }
}

object SupervisionSpec {

  class Supervisor extends Actor {
    // A one for one supervisor applies the specified supervision strategy on the specific actor that
    // cause the exception.
    // Another supervision strategy is- AllForOne which applies the specified supervision to all the actors
    // irrespective of which actor caused that excption.
    override val supervisorStrategy = OneForOneStrategy(){
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: RuntimeException => Resume
      case _: Exception => Escalate
    }

    override def receive: Receive = {
      case props: Props =>
        val childRef = context.actorOf(props)
        sender() ! childRef
    }
  }

  case object Report

  class FussyWordCounter extends Actor {
    var words = 0

    override def receive: Receive = {
      case Report => sender() ! words
      case "" => throw new NullPointerException("sentence is empty")
      case sentence: String =>
        if (sentence.length > 20) throw new RuntimeException("sentence is too big")
        else if (!Character.isUpperCase(sentence(0))) throw new IllegalArgumentException("sentence must start with uppercase")
        else words += sentence.split(" ").length
      case _ => throw new Exception("can only receive strings")
    }
  }
}

// next: backoffSupervisionPattern
