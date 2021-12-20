package Ch2

import akka.actor.{Actor, ActorSystem, Props}

/**
 * In this exercise the objective is to create a counter actor as follow:
 * 1. When the actor gets increment message, the counter should be incremented.
 * 2. When the actor gets decrement message, the counter should be decremented.
 * 3. When the actor gets print message, the current counter should be printed.
 *
 * This is similar to the exercise 1; but here the mutable variable is not to be used.
 */
object Exercise3 extends App {

  object Counter{
    case class Increment(value: Int)
    case class Decrement(value: Int)
    case object Print
  }
  class Counter extends Actor {
    import Counter._
    override def receive: Receive = counterReceive(0)

    def counterReceive(count: Int): Receive = {
      case Increment(value) => context.become(counterReceive(count + value))
      case Decrement(value) => context.become(counterReceive(count - value))
      case Print => println(s"current count is: $count")
    }
  }

  import Counter._

  val system = ActorSystem("ActorSystemForCounter")
  val actor = system.actorOf(Props[Counter], "Counter1")

  actor ! Increment(2)
  actor ! Increment(1)
  actor ! Print
  actor ! Decrement(2)
  actor ! Print
}
