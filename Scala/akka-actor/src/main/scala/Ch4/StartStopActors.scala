package Ch4

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Kill, PoisonPill, Props}

object StartStopActors extends App {

  object Parent{
    case class StartChild(name: String)
    case class StopChild(name: String)
    case object Stop
  }
  class Parent extends Actor with ActorLogging {
    import Parent._
    override def receive: Receive = withChild(Map())

    def withChild(children : Map[String, ActorRef]): Receive = {
      case StartChild(name) =>
        log.info(s"Starting the child with name: $name")
        context.become(withChild(children + (name -> context.actorOf(Props[Child]))))

      case StopChild(name) =>
        children.get(name) match {
          case Some(ref) =>
            log.info(s"Stopping the child with name: $name")
            context.stop(ref)
          case None => log.info(s"Child $name does not exist")
        }

      case Stop => context.stop(self)   // stop the parent and its children.
    }
  }
  class Child extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg: String => log.info(s"$self received msg: $msg")
    }
  }

  import Parent._

  val system = ActorSystem("startStopChild")
  val parentActor = system.actorOf(Props[Parent], "parent")

  parentActor ! StartChild("child1")
  parentActor ! StartChild("child1")

  val child = system.actorSelection("/user/parent/child1")
  child ! "Hello Kid..."

  parentActor ! StopChild("child1")
  parentActor ! StopChild("child2")

  parentActor ! Stop

  /**
   * Stopping the parent also stops the underlying children.
   * But this does not implies that the child are immediately stopped.
   * The stop signal is also sent to the child asynchronously.
   * Once the child is stopped, the msg sent to it will not be delivered. They will be directed towards `dead letters`
   */

  /**
   * Other ways to stop the actor is using special messages like:
   * 1. PoisonPill : Gracefully stops the actor i.e. no exception is thrown when it stops the actor.
   * 2. Kill        : Brutally stops the actor. i.e. actor kill exception is thrown when Kill is used to stop the actor.
   */

  system.actorOf(Props[Child]) ! PoisonPill
  system.actorOf(Props[Child]) ! Kill
}
// NEXT: Watching Actors
