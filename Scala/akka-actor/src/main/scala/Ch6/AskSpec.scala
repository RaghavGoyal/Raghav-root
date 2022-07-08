package Ch6

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.testkit.{ImplicitSender, TestKit}
import akka.util.Timeout
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

class AskSpec extends TestKit(ActorSystem("AskSpec"))
   with WordSpecLike with ImplicitSender with BeforeAndAfterAll {

  override def afterAll(): Unit = TestKit.shutdownActorSystem(system)

  import AskSpec._

  "An authenticator" should {
    "fail to authenticate a non-registered user" in {
      val authenticator = system.actorOf(Props[AuthActor])
      authenticator ! Authenticate("abc", "xyz")
      expectMsg[AuthFailure](AuthFailure("User does not exist"))

    }

    "successfully register a new user" in {
      val authenticator = system.actorOf(Props[AuthActor])
      authenticator ! RegisterUser("abc", "xyz")
      expectNoMessage()
      // if the user is added, subsequent attempt to authorise should be successful:

      authenticator ! Authenticate("abc", "xyz")
      expectMsg(AuthSuccess)
    }

    "fail to authenticate when incorrect password is provided" in {
      val authenticator = system.actorOf(Props[AuthActor])

      authenticator ! RegisterUser("abc", "xyz")
      expectNoMessage()
      authenticator ! Authenticate("abc", "xyzhv")
      expectMsg[AuthFailure](AuthFailure("Incorrect username/password"))
    }
  }

  "A piped authenticator" should{
    "fail to authenticate a non-registered user" in {
      val authenticator = system.actorOf(Props[PipedAuthActor])
      authenticator ! Authenticate("abc", "xyz")
      expectMsg[AuthFailure](AuthFailure("User does not exist"))
    }

    "successfully register a new user" in{
      val authenticator = system.actorOf(Props[PipedAuthActor])
      authenticator ! RegisterUser("abc", "xyz")
      expectNoMessage()
      // if the user is added, subsequent attempt to authorise should be successful:

      authenticator ! Authenticate("abc", "xyz")
      expectMsg(AuthSuccess)
    }

    "fail to authenticate when incorrect password is provided" in {
      val authenticator = system.actorOf(Props[PipedAuthActor])

      authenticator ! RegisterUser("abc", "xyz")
      expectNoMessage()
      authenticator ! Authenticate("abc", "xyzhv")
      expectMsg[AuthFailure](AuthFailure("Incorrect username/password"))
    }
  }

}
object AskSpec{

  case class Read(key:String)
  case class Write(key: String, value: String)

  class KVActor extends Actor with ActorLogging{
    override def receive: Receive = online(Map.empty)

    def online(map: Map[String, String]): Receive = {
      case Read(key) =>
        log.info(s"Attempt to read the value for key: $key")
        sender ! map.get(key)

      case Write(key, value) =>
        log.info(s"Adding new key: $key and value: $value")
        context.become(online(map ++ Map(key -> value)))
    }
  }

  case class RegisterUser(username: String, password: String)
  case class Authenticate(username: String, password: String)
  case class AuthFailure(message: String)
  case object AuthSuccess

  class AuthActor extends Actor with ActorLogging {

    protected val authDB = context.actorOf(Props[KVActor])

    implicit val timeout = Timeout(1 second)
    implicit val executionContext = context.dispatcher

    override def receive: Receive = {
      case RegisterUser(user, pass) =>
        log.info("Registering user....")
        authDB ! Write(user, pass)
      case Authenticate(username, password) =>
        handleAuthentication(username, password)
    }

    def handleAuthentication(username: String, password: String) = {
      val responseFromDB = authDB ? Read(username)
      // can not directly use sender inside oncomplete because the future would execute
      // on a separate thread and the sender in this thread may not be same. So, keep a
      // snapshot of original sender here...
      val originalSender = sender()

      responseFromDB.onComplete{
        case Success(None) => originalSender ! AuthFailure("User does not exist")
        case Success(Some(value)) =>
          if(value == password) originalSender ! AuthSuccess
          else originalSender ! AuthFailure("Incorrect username/password")
        case Failure(_) => originalSender ! AuthFailure("could not fetch data...")
      }
    }
  }

  class PipedAuthActor extends AuthActor {
    override def handleAuthentication(username: String, password: String): Unit ={
      val response = authDB ? Read(username)
      val passwordFuture = response.mapTo[Option[String]]
      val responseFuture = passwordFuture.map{
        case None => AuthFailure("User does not exist")
        case Some(dbPassword) =>
          if(password == dbPassword) AuthSuccess
          else AuthFailure("Incorrect username/password")
      } // This future will complete with the response we want to send.
      import akka.pattern.pipe
      responseFuture.pipeTo(sender())

      /**
       * The pipeto method is available only when `akka.pattern.pipe` is imported.
       * It means that when the future completes, send the response to the sender in the argument.
       */
    }
  }
}
// Finite state machine
