package Ch2

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}

object ActorLogging extends App {

  /**
   * Logging in an actor system can be of two types:
   * 1. Explicit Logging : explicitly creating a logger instance to log msgs.
   * 2. Actor Logging    : logger is provided implicitly and not explicitly created.
   *
   * Logging Levels:
   *  1. Debug
   *  2. Info
   *  3. Warning
   *  4. Error
   */

  class ExplicitLogging extends Actor {
    val logger: LoggingAdapter = Logging(context.system, this)
    override def receive: Receive = {
      case msg => logger.info(msg.toString)
    }
  }

  class ImplicitLogging extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg => log.error(msg.toString)
    }
  }

  val system = ActorSystem("logging")
  val expActorLogging = system.actorOf(Props[ExplicitLogging], "ExplicitLogging")
  val impActorLogging = system.actorOf(Props[ImplicitLogging], "ImplicitLogging")
  expActorLogging ! "Log message 1"
  impActorLogging ! "Log msg 2"

  /**
   * Logging in akka is completely asynchronous for performance reasons.
   * Logging in akka is also governed by actors.
   */
}

// Next: Configuration
