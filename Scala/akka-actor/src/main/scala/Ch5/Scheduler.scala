package Ch5

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import scala.concurrent.duration._

object Scheduler extends App {

  class SimpleActor extends Actor with ActorLogging{
    override def receive: Receive = {
      case msg => log.info(msg.toString)
    }
  }

  val system = ActorSystem("Timer-Scheduler")
  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")

  simpleActor ! "Hello"

  system.log.info("Scheduling the bye msg now...")
  system.scheduler.scheduleOnce(1 second){
    simpleActor ! "Bye"
  }(system.dispatcher)

  system.log.info("scheduling the heartbeat message now...")
  val routine = system.scheduler.schedule(1 second, 2 seconds){
    simpleActor ! "heartbeat"
  }(system.dispatcher)

  // cancel a scheduler:
  system.scheduler.scheduleOnce(5 seconds){
    routine.cancel()
  }(system.dispatcher)

}
// exercise 1
