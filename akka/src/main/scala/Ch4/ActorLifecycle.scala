package Ch4

import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props}
import akka.event.LoggingAdapter

/**
 * Distinction between Actor instance, reference and path
 *
 * ACTOR INSTANCE:
 *    - is basically a class that has methods associated with it. (like receive)
 *    - may have an internal state
 *
 *  ACTOR REFERENCE:
 *    - Also called Incarnation.
 *    - created with the actorOf[] handle
 *    - has mail box associated with it; that can send and receive the messages.
 *    - holds an actor instance.
 *    - contains a UUID associated.
 *
 *  ACTOR PATH:
 *    - may or may not have an actor ref inside.
 */
object ActorLifecycle extends App {
  /**
   * Actor life cycle:
   *  1. start    : Creating new actor ref with UUID at a given path
   *  2. suspend  : Actor can enqueue but not process messages
   *  3. resume   : ActorRef can continue to process more messages
   *  4. restart  : involves multiple steps:
   *                  - suspend
   *                  - swap actor instance
   *                      - old instance calls preRestart
   *                      - replace actor instance with new one (any internal state is destroyed)
   *                      - new instance calls postRestart
   *                  - resume
   *  5. stop     : it free the actor ref with the path.
   *                  - calls postStop
   *                  - all watching actors get Terminate(ref) msg.
   *                After stopping, new actor ref may be created. this will have a different UUID.
   *
   */

  case object CreateChild
  object ThrowException

  class LifeCycleDemo extends Actor with ActorLogging {
    override def preStart(): Unit ={
      log.info("The LifeCycle Demo is about to begin.")
    }

    override def postStop(): Unit = {
      log.info("The lifecycle demo is completed...")
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      log.info(s"About to restart. Reason: ${reason.getMessage} ")
    }

    override def postRestart(reason: Throwable): Unit = {
      log.info("Restarted...")
    }

    override def receive: Receive = {
      case CreateChild =>
        context.actorOf(Props[LifeCycleDemo], "child")
      case ThrowException =>
        throw new RuntimeException("Test Exception")
    }
  }

  val system = ActorSystem("lifeCycle")
  val parent = system.actorOf(Props[LifeCycleDemo], "parent") // prestart will be called

  parent ! CreateChild

  parent ! ThrowException

}
// Next: Supervision
