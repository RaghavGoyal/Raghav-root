package Ch4

import akka.actor.SupervisorStrategy.Stop
import akka.actor.{Actor, ActorLogging, ActorSystem, OneForOneStrategy, Props}
import akka.pattern.{Backoff, BackoffSupervisor}
import scala.concurrent.duration._
import java.io.File
import scala.io.Source

object BackoffSupervisionPattern extends App{

  /**
   * The backoff supervision pattern attempts to solve the following problem:
   *
   * 'Repeated Restarts of Actor'
   * When an actor is interacting with an external service such a database, and if it goes down while many
   * actors are trying to read and write to it, many actors will start to throw the exceptions.
   * This will trigger the supervision strategy. Following the supervision, if all the actors start again
   * and again at the same time, the database might go down again due to excess load or actors may run into
   * a blocking state.
   *
   * The backoff supervision pattern solves this problem by introducing exponential delays and randomness
   * between the attempts to re-run the supervision strategy.
   */

  case object ReadFile

  class FileBasedPersistentActor extends Actor with ActorLogging{
    var datasoure: Source = null

    override def preStart(): Unit = log.info("Staring File based persistent actor...")

    override def postStop(): Unit = log.warning("file based persistent actor has stopped !")

    override def preRestart(reason: Throwable, message: Option[Any]): Unit =
      log.warning("File based persistent actor is restarting...")


    override def receive: Receive = {
      case ReadFile =>
        if(datasoure == null)
          datasoure = Source.fromFile(new File("src/main/resources/test/important_data.txt"))
        log.info(s"Read important data from file ${datasoure.getLines().toList}")
    }
  }

  val system = ActorSystem("BackoffSupervisionDemo")
//  val actor = system.actorOf(Props[FileBasedPersistentActor], "simpleActor")
//  actor ! ReadFile

  val backoffSupervisorProps = BackoffSupervisor.props(
    Backoff.onFailure(
      Props[FileBasedPersistentActor],
      "BackoffActor",
      3 seconds,
      30 seconds,
      0.2
    )
  )

//  val backoffSupervisor = system.actorOf(backoffSupervisorProps, "supervisor")
//  backoffSupervisor ! ReadFile

  /**
   * Here supervisor is an actor created under user guardian.
   * This actor is created using a special props that is created using backoff in supervision
   * under the `supervisor` is a child actor named `BakoffActor` that actually does all the work.
   * The supervision strategy used here is default that means `Restart` directive is applied on everything.
   * The exponential delay is set using last 3 parameters:
   * 1. the first attempt to restart the actor is made 3 seconds after the actor is stopped
   * 2. The subsequent attempts are made by delaying 2x the previous delay i.e. 6 sec, 12 sec, 24 sec.
   * 3. the upper bound of delay between subsequent supervisions is 30sec.
   * 4. the last parameter is used to specify some randomness so that all the actors do not restart together.
   */

  /**
   *   creating props for stop supervisor:
   */
  val stopSupervisorProps = BackoffSupervisor.props(
    Backoff.onStop(
      Props[FileBasedPersistentActor],
      "StopBackoffActor",
      3 seconds,
      30 seconds,
      0.3
    ).withSupervisorStrategy(
      // here default supervisor strategy can be overridden as:
      OneForOneStrategy(){
        case _ => Stop
      }
    )
  )
//  val stopSupervisor = system.actorOf(stopSupervisorProps, "stopSupervisor")
//  stopSupervisor ! ReadFile

  /**
   * this does not trigger the stop supervision because the `stopSupervisor` is restarted by default.
   * the effects of above can be observed when the actor actually stops. This happens when there is some
   * exception while creating/initializing the actor.
   * Hence we will not plug the incorrect reading attempt with the prestart lifecycle hook.
  */

  class EagerFBPA extends FileBasedPersistentActor{
    override def preStart(): Unit = {
      log.warning("Starting the eagerAtor...")
      datasoure = Source.fromFile(new File("src/main/resources/test/important_data.txt"))
    }
  }

  // create actor instance from above class:
  val eagerSupervisorProps = BackoffSupervisor.props(
    Backoff.onStop( // controls when backoff kicks in
      Props[EagerFBPA],
      "EagerFBPActor",
      1 seconds,
      10 seconds,
      0.1
    )
  )
  val eagerSupervisor = system.actorOf(eagerSupervisorProps, "eagerSupervisor")
  eagerSupervisor ! ReadFile
}
// next: Schedulers & Timers- Ch5
