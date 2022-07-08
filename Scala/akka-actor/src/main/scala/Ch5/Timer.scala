package Ch5

import akka.actor.{Actor, ActorLogging, ActorSystem, Props, Timers}
import scala.concurrent.duration.DurationInt

object Timer extends App {
  /**
   * Timers:
   * Timers are used to schedule messages to self, from within.
   */

  case object TimerKey
  case object Start
  case object Stop
  case object Reminder
  class TimerBasedHeartbeatActor extends Actor with ActorLogging with Timers{
    timers.startSingleTimer(TimerKey, Start, 500 millis)
    override def receive: Receive = {
      case Start =>
        log.info("Bootstrapping...")
        timers.startPeriodicTimer(TimerKey, Reminder, 1 second)
      case Reminder =>
        log.info("Timer is alive")
      case Stop =>
        log.warning("Stopping timer")
        timers.cancel(TimerKey)
        context.stop(self)
    }
  }

  val system = ActorSystem("timer")
  val timerHeartbeatActor = system.actorOf(Props[TimerBasedHeartbeatActor], "timer")
  system.scheduler.scheduleOnce(5 seconds){
    timerHeartbeatActor ! Stop
  }(system.dispatcher)

}
// Routers
