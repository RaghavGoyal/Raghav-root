package Ch3

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.testkit.{EventFilter, ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

// Testing if logs are being generated as per expectations or not.
class InterceptingLogsSpec extends TestKit(ActorSystem("InterceptingLogs", ConfigFactory.load().getConfig("interceptingLogMessages")))
  with ImplicitSender
  with WordSpecLike
  with BeforeAndAfterAll {

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  import InterceptingLogsSpec._

  val item = "Watch"
  val validCard = "123-123-1234-1234"
  val invalidCard = "0123-00-098-1222"
  val actor = system.actorOf(Props[CheckoutManager])

  "The checkout flow" should {
    "correctly log the confirmation message" in {
      EventFilter.info(
        pattern = s"your order containing $item with order id: [0-9]+ is confirmed",
        occurrences = 1) intercept{
        actor ! Checkout(item, validCard)
      }
    }

    "throw a runtime exception if invalid card is provided" in {
      EventFilter[RuntimeException](occurrences = 1)intercept{
        actor ! Checkout(item, invalidCard)
      }
    }
  }
}

// NEXT: Synchronous testing

object InterceptingLogsSpec {

  case class Checkout(item: String, card: String)
  case class Authenticate(card: String)
  case object PaymentSuccessful
  case object PaymentDenied
  case class DispatchOrder(item: String)
  case object OrderConfirmed

  class CheckoutManager extends Actor with ActorLogging {
    private val paymentManagerActor = context.actorOf(Props[PaymentManager])
    private val fulfilmentManagerActor = context.actorOf(Props[FulfilmentManager])

    override def receive: Receive = {
      case Checkout(item, card) =>
        paymentManagerActor ! Authenticate(card)
        context.become(pendingPayment(item))
    }
    def pendingPayment(item: String): Receive = {
      case PaymentSuccessful =>
        log.info("Payment Successful msg received")
        fulfilmentManagerActor ! DispatchOrder(item)
        context.become(pendingFulfillment)
      case PaymentDenied =>
        throw new RuntimeException("This will throw an exception")
    }
    def pendingFulfillment : Receive = {
      case OrderConfirmed => context.become(receive)
    }
  }

  class PaymentManager extends Actor with ActorLogging {
    override def receive: Receive = {
      case Authenticate(card) =>
        if(card.startsWith("0"))
          sender() ! PaymentDenied
        else {
          Thread.sleep(1000)
          sender() ! PaymentSuccessful
        }
    }
  }

  class FulfilmentManager extends Actor with ActorLogging {
    var orderId = 33
    override def receive: Receive = {
      case DispatchOrder(item) =>
        orderId += 1
        log.info(s"your order containing $item with order id: $orderId is confirmed")
        sender() ! OrderConfirmed
    }
  }
}
