package Ch4

import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props, Terminated}

object WatchingActors extends App {
  object Watcher{
    case class StartChild(name: String)
  }
  class Watcher extends Actor with ActorLogging {
    import Watcher._

    override def receive: Receive = {
      case StartChild(name) =>
        log.info(s"Startinng Child $name")
        val childRef = context.actorOf(Props[Child], name)
        context.watch(childRef)   // registers the watching of the given actorRef. context.unwatch(ref) to unwatch.

      case Terminated(ref) =>
        log.info(s"Child with reference $ref is going to be terminated")
    }
  }

  class Child extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg: String => log.info(s"$self received msg: $msg")
    }
  }

  import Watcher._

  val system = ActorSystem("watchingActors")
  val watcher = system.actorOf(Props[Watcher], "watcher")

  watcher ! StartChild("child1")

  val watchedChild = system.actorSelection("user/watcher/child1")

  watchedChild ! PoisonPill
}
//NEXT: Actor Life cycle
