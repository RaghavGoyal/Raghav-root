package persistentActors

import akka.actor.ActorLogging
import akka.persistence.{PersistentActor, SnapshotOffer}

object Counter {

  sealed trait Operation{
    val count : Int
  }
  case class Increment(override val count: Int) extends Operation
  case class Decrement(override val count: Int) extends Operation

  // command:
  case class Cmd(op: Operation)

  // event:
  case class Evt(op: Operation)

  //state:
  case class State(count: Int)

}

class Counter extends PersistentActor with ActorLogging{
  import Counter._

  // persistent Identifier
  override def persistenceId: String = "counter-expamle"

  var state: State = State(count = 0)
  def updateState(event: Evt): Unit = event match {
    case Evt(Increment(count)) => state = State(count = state.count + count)
    case Evt(Decrement(count)) => state = State(count = state.count - count)
  }

  //Persistent receive on recovery mode:
  override def receiveRecover: Receive = {
    case evt: Evt =>
      println(s"Counter receive $evt on recovering mode")
      updateState(evt)
    case SnapshotOffer(_, snapshot: State) =>
      println(s"Counter receive snapshot with data $snapshot on recovering mode")
      state = snapshot
  }

  // persistent receive on normal mode:
  override def receiveCommand: Receive = {
    case cmd @ Cmd(op) =>
      println(s"Counter receive $cmd")
      persist(Evt(op)){ evt =>
        updateState(evt)
      }
    // to print the state
    case "print" => println(s"Current State is $state")
    // to snapshot the state.
    case "snapshot" => saveSnapshot(state)
  }
}

/**
 * Persistent Actor Lifecycle:
 * 1. When a persistent actor is started or restarted, it enters the recovery mode.
 * 2. For recovery it may:
 *      -> either replay the events persisted to attain the state.
 *      -> or, assign the latest snapshot to the state.
 * 3. Once the actor is created with its state, it receives the command.
 * 4. Once the command is received, the first step is to check if the command can be applied to the current state.
 * 5. If it can be applied, it generates the events for that command
 * 6. The generated events are then persisted.
 * 7. And then the state is changed.
 *
 * New messages sent to a persistent actor during recovery do not interfere with replayed messages.
 * They are stashed and received by a persistent actor after recovery phase completes.
 *
 * Persist Method:
 * The persist method persists the events.
 * It takes two arguments:
 * 1. the event to persist
 * 2. The handler that is invoked once the persistence is successful.
 *
 * When persisting events with persist it is guaranteed that
 * the persistent actor will not receive further commands between
 * the persist call and the execution(s) of the associated event handler.
 * This also holds for multiple persist calls in context of a single command.
 * Incoming messages are stashed until the persist is completed.
 *
 */
