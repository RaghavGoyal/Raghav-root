package Ch2

import akka.actor.{Actor, ActorSystem, Props}

/**
 * In this exercise the objective is to create a counter actor as follow:
 * 1. When the actor gets increment message, the counter should be incremented.
 * 2. When the actor gets decrement message, the counter should be decremented.
 * 3. When the actor gets print message, the current counter should be printed.
 */
object Exercise1 extends App {

  class Counter extends Actor {
    private var count = 0
    override def receive: Receive = {
      case Increment(value) => count += value
      case Decrement(value) => count -= value
      case Print => println(s"Current counter is at: $count")
    }
  }

  val actorSystem = ActorSystem("CounterActorSystem")
  val counterActor = actorSystem.actorOf(Props[Counter], "CounterActor")

  case class Increment(value: Int)
  case class Decrement(value: Int)
  case class Print()

//  counterActor ! Increment(1)
//  counterActor ! Increment(2)
//  counterActor ! Print
//  counterActor ! Decrement(5)
//  counterActor ! Print

  val incThread = new Thread (() => (1 to 1000).foreach(_ => counterActor ! Increment(1)))
  val decThread = new Thread (() => (1 to 1000).foreach(_ => counterActor ! Decrement(1)))
  incThread.start()
  decThread.start()
//  incThread.join()
//  decThread.join()
  counterActor ! Print

}
