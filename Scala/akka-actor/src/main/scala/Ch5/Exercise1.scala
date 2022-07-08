package Ch5

import akka.actor.{Actor, ActorLogging, ActorSystem, Props, Timers, actorRef2Scala}

import scala.concurrent.duration._

/**
 * The objective of this exercise is to create a self-closing actor.
 * - if the actor receives any message, you have one second to send it another message.
 * - if the time window expires, actor will close itself,
 * - if another message is sent before time expiry, the timer is reset.
 */
object Exercise1 extends App {

  class SelfClosingActor extends Actor with ActorLogging{
    case object TimeOut
    var schedule = createTimeOutWindow

    def createTimeOutWindow = context.system.scheduler.scheduleOnce(1 second){
      self ! TimeOut
    }(context.system.dispatcher)

    override def receive: Receive = {
      case msg: String =>
        log.info(s"input: ${msg.toString}. Alive for 1 second...")
        schedule.cancel()
        schedule = createTimeOutWindow
      case TimeOut =>
        context.stop(self)
    }
  }

  val system = ActorSystem("Exercise1")
  val actor = system.actorOf(Props[SelfClosingActor], "Self-closing-actor")
  implicit val executionContext = system.dispatcher
  system.scheduler.scheduleOnce(250 millis){
    actor ! "hello"
  }

  system.scheduler.scheduleOnce(2 seconds){
    actor ! "Ping"
  }
}
// Timer
