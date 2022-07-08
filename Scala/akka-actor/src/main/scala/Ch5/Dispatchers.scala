package Ch5

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.util.Random

object Dispatchers extends App {

  /**
   * Dispatcher controls how messages are being sent and handled.
   */

  class Counter extends Actor with ActorLogging{
    var count = 0

    override def receive: Receive = {
      case message =>
        count = count + 1
        log.info(s"[$count] ${message.toString}")
    }
  }

  val system = ActorSystem(
    "dispatchers-demo",
    ConfigFactory.load().getConfig("dispatcherDemo")
  )

  val actors = (1 to 10).toList.map{ id =>
    system.actorOf(
      Props[Counter].withDispatcher("my-dispatcher"),
      s"counter-$id"
    )
  }

  val random = new Random()
  (1 to 1000).foreach(id =>
    actors(random.nextInt(10)) ! id
  )

  /**
   * It should be observed from the logs that,
   * only few of the actors (out of 10) are more frequent than others.
   * each actor handles 30 messages before moving to another thread.
   * At any one time, only 3 actors are scheduled.
   */

  /**
   * Method 2: From Config:
   */
  val someActor = system.actorOf(Props[Counter], "someActor")

}
// Mailboxes
