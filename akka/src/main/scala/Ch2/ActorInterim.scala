package Ch2

import akka.actor.{Actor, ActorSystem, Props}

// Second
object ActorInterim extends App {

//  message sent to actors may be of any type, even custom objects:
  class TestActor extends Actor {
    override def receive: Receive = {
      case message: String => println(s"[TestActor] Got string message: $message")
      case message: Int => println(s"[TestActor] Got int message: $message")
      case message: Boolean => println(s"[TestActor] Got boolean message: $message")
      case message: CustomObject => println(s"[TestActor] Got custom object: $message")
      case _ =>
        println(context.self)
        println(context.system)
        println(context.props)
    }
  }
  case class CustomObject(param1: String, param2: Int)
  val actorSystem = ActorSystem("InterimActor")
  val actor1 = actorSystem.actorOf(Props[TestActor], "testActor1")
  actor1 ! "hello"
  actor1 ! 20
  actor1 ! true
  actor1 ! CustomObject("123", 123)

  /**
   * The message passed to the actor must comply with following constraints:
   * 1. Messages should be IMMUTABLE
   * 2. Messages should be SERIALIZABLE (transformable into the byte string and send to JVM)
   */

//  Actors have information about themself and their context.
//  The context of actor is available in `context.self`.
//  Context.self is equivalent to `this` in OOPs.

  actor1 ! 1.1
}
