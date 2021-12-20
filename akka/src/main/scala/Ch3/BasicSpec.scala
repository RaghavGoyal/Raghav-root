package Ch3

import Ch3.BasicSpec.{NoReply, SimpleActor, SomeFunctionality}
import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

import scala.concurrent.duration.DurationInt
import scala.util.Random

class BasicSpec extends TestKit(ActorSystem("BasicSpec")) with ImplicitSender with WordSpecLike with BeforeAndAfterAll {

  // setup:
  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Simple Actor" should {
    "return the input to sender" in {
      val msg = "This is test msg to simple actor"
      system.actorOf(Props[SimpleActor]) ! msg

      expectMsg(msg)
    }
  }

  "NoReply Actor" should {
    "return no response" in {
      val msg = "This is test msg to noReply actor"
      system.actorOf(Props[NoReply]) ! msg

//      expectMsg("Hello")  // fails
      expectNoMessage(1 seconds)
    }
  }

  "SomeFunctionality Actor" should {
    "return msg in upper case" in {
      val msg = "Hi actor!!"
      val expectedMsg = msg.toUpperCase()
      system.actorOf(Props[SomeFunctionality]) ! msg
      val reply = expectMsgType[String]

      assert(
        reply == expectedMsg
      )
    }

    "return Hi or Hello" in {
      system.actorOf(Props[SomeFunctionality]) ! "greet"
      expectMsgAnyOf("Hello", "Hi")
    }

    "return Hi and Hello" in {
      system.actorOf(Props[SomeFunctionality]) ! "send2"
      expectMsgAllOf("Hello", "hey")
    }

    "return Hi and Hello any" in {
      system.actorOf(Props[SomeFunctionality]) ! "send2"
      val expectedRespList = List("hey", "Hello")
      val reply = receiveN(1)
      assert(expectedRespList.contains(reply.head))
    }

    "return Hi and Hello both" in {
      system.actorOf(Props[SomeFunctionality]) ! "send2"
      val expectedRespList = List("hey", "Hello")
      val replies = receiveN(2)
      expectedRespList.foreach(exp => assert(replies.contains(exp)))
    }

    "have favTech scala case defined" in {
      system.actorOf(Props[SomeFunctionality]) ! "favTech"
      expectMsgPF(){
        case "scala" => // only cares if the pf is defined or not
        case "akka" =>
      }
    }
  }
}

// NEXT: Test Probes

object BasicSpec{
  class SimpleActor extends Actor {
    override def receive: Receive = {
      case msg: String => sender() ! msg
    }
  }

  class NoReply extends Actor {
    override def receive: Receive = {
      case msg: String => Actor.emptyBehavior
    }
  }

  class SomeFunctionality extends Actor {
    val random = new Random()
    override def receive: Receive = {
      case "greet" => if(random.nextBoolean()) sender ! "Hi" else sender ! "Hello"
      case "send2" =>
        sender() ! "hey"
        sender() ! "Hello"
      case "favTech" => sender() ! "scala"
      case msg: String => sender() ! msg.toUpperCase()
    }
  }
}
