package Ch2

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}

object ChildActors extends App {

  /**
   * An actor can create other actors.
   * The actors created by other actor are called the child actor.
   */

  object Parent {
    case class CreateChild(name: String)

    case class TellChild(msg: String)
  }

  class Parent extends Actor {

    import Parent._

    override def receive: Receive = {
      case CreateChild(name) =>
        println("[Parent] Creating child actor...")
        val childRef = context.actorOf(Props[Child], name)
        context.become(parentWithChild(childRef))
    }

    def parentWithChild(child: ActorRef): Receive = {
      case TellChild(msg) => child ! msg
    }
  }

  class Child extends Actor {
    override def receive: Receive = {
      case msg: String => println(s"[ChildActor] Got Msg: $msg from: $sender")
    }
  }

  import Parent._

  val system = ActorSystem("Parent_child")
  val parent = system.actorOf(Props[Parent], "Parent")

  parent ! TellChild("Hello") // does not match with the case and hence no action.
  parent ! CreateChild("Child1")
  parent ! TellChild("Hello")

  /**
   * Actors hierarchy.
   * Child actors are managed by the parent actors.
   * Child actors can also have further child actors.
   *
   * Parent -> Child -> Grand child
   *        -> Child2
   * Note: The lifecycle of a child actor is tied to the parent – a child can stop itself or be stopped at any time
   * but it can never outlive its parent.
   *
   * There are three kind of guardian actors. They are responsible for managing all the actors. They are:
   * 1. /system : this is a system level guardian. Every actor system has a system guardian that is responsible for
   *              managing all the operations of the actorSystem. Like logging.
   * 2. /user   : This is the user level guardian. Every actor that programmers create using system.actorOf are
   *              governed by the /user guardian, which is a top level guardian for all user actors.
   * 3. /       : Root guardian. This guardian is responsible for managing /system and /user guardians.
   *              Root guardian is the top-most level guardian for all the actors.
   */

  /**
   * Actor Selection:
   * The specific actor can be selected by its path.
   * The actor selection returns a ActorSelection reference that is a wrapper around ActorRef.
   */
  val childSelection: ActorSelection = system.actorSelection("/user/Parent/Child1")
  childSelection ! "Found you kid."

//  Similar actor selection can be done inside another actor. This is achieved by using context.actorSelection(path)
}
// NEXT: Exercise 5