package introduction

import akka.actor.{ActorLogging, ActorSystem, Props}
import akka.persistence.{PersistentActor, SnapshotOffer}
import introduction.Counter.{Cmd, Decrement, Increment}

object Counter{
  sealed trait Operation{
    val count: Int
  }
  case class Increment(override val count: Int) extends Operation
  case class Decrement(override val count: Int) extends Operation

  case class Cmd(operation: Operation)
  case class Evt(operation: Operation)

  case class State(count: Int)
}


class Counter extends PersistentActor with ActorLogging{
  import  Counter._
  var state = State(0)

  def updateState(evt: Evt) = evt match {
    case Evt(Increment(count)) =>
      state = State(state.count + count)
    case Evt(Decrement(count)) =>
      state = State(state.count - count)
  }
  override def receiveRecover: Receive = {
    case evt: Evt =>
      log.info(s"persistent counter actor received $evt in Recover mode...")
      updateState(evt)
    case SnapshotOffer(_, snapshot: State) =>
      state = snapshot
  }

  override def receiveCommand: Receive = {
    case cmd @ Cmd(op) =>
      log.info(s"Persistent Counter Actor received $cmd in normal mode...")
      persist(Evt(op)){ evt =>
        updateState(evt)
      }
    case "print" =>
      println(s"The current state of counter is: $state")
  }

  override def persistenceId: String = "counter"
}

object Main extends App{

  val system = ActorSystem("counter-demo")
  val counter = system.actorOf(Props[Counter], "counter-1")
  counter ! Cmd(Increment(3))
  counter ! Cmd(Decrement(3))
  counter ! Cmd(Increment(2))
  counter ! Cmd(Increment(1))

  counter ! "print"

  Thread.sleep(1000)
  system.terminate()
}
