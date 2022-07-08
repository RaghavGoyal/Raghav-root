package Ch6

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Cancellable, FSM, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, OneInstancePerTest, WordSpecLike}

import scala.concurrent.duration.{DurationDouble, DurationInt}

/**
 * Finite state machines (FSM) are an alternative to context.become
 * because it is also a way to manage the state of an actor.
 *
 * A FSM has finite number of states and has the ability to make the transitions from one state to another
 * when a message/command/event occurs.
 */
class FiniteStateMachineSpec extends TestKit(ActorSystem("FSM-demo"))
    with ImplicitSender with WordSpecLike with BeforeAndAfterAll with OneInstancePerTest{

  override def afterAll(): Unit = TestKit.shutdownActorSystem(system)

  import FiniteStateMachineSpec._

  def executeScenarios(props: Props): Unit ={
    "respond with VendingError message when un-initialized" in {
      val vm = system.actorOf(props)
      vm ! RequestProduct("chocolate")
      expectMsg(VendingError("Machine is unavailable at the moment. Please try later..."))
    }

    "respond with VendingError when product is not available" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("coke")
      expectMsg(VendingError("Product is unavailable at the moment..."))
    }

    "respond with instruction when requested product is available" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
    }

    "Respond with timeout if money is not inserted timely" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))

      within(1.5 seconds){
        expectMsg(VendingError("Request Timed Out"))
      }
    }

    "handle the reception of partial money" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      vm ! ReceiveMoney(10)
      expectMsg(Instruction(s"Please insert balance of 10 INR."))

      within(1.5 seconds){
        expectMsg(VendingError("Request Timed Out"))
        expectMsg(GiveBackChange(10))
      }
    }

    "Deliver the product if money is partially provided and then balance is provided" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      vm ! ReceiveMoney(10)
      expectMsg(Instruction(s"Please insert balance of 10 INR."))
      vm ! ReceiveMoney(5)
      expectMsg(Instruction(s"Please insert balance of 5 INR."))
      vm ! ReceiveMoney(5)
      expectMsg(Deliver("chocolate"))
    }

    "Deliver the product if money is provided at once" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      vm ! ReceiveMoney(20)
      expectMsg(Deliver("chocolate"))
    }

    "Deliver the product and give back change if money provided is larger than price" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      vm ! ReceiveMoney(50)
      expectMsg(Deliver("chocolate"))
      expectMsg(GiveBackChange(30))
    }

    "should be able to process next order once previous order is completed" in {
      val vm = system.actorOf(props)
      vm ! Initialize(Map("chocolate" -> 2), Map("chocolate" -> 20))
      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      vm ! ReceiveMoney(50)
      expectMsg(Deliver("chocolate"))
      expectMsg(GiveBackChange(30))

      vm ! RequestProduct("chocolate")
      expectMsg(Instruction(s"Please insert 20 INR."))
      within(1.5 seconds){
        expectMsg(VendingError("Request Timed Out"))
      }
    }
  }

  "A vending machine" should{
    executeScenarios(Props[VendingMachine])
  }

  "A FSM based vending machine" should{
    executeScenarios(Props[VendingMachineFSM])
  }
}



object FiniteStateMachineSpec {
  /**
   * Sometimes an actor has many states involved. This would usually result in having too many
   * receive methods that eventually adds to complexity.
   * Akka has a special api to manage this problem. It is done by using FSM.
   *
   * For example: A vending machine.
   * Flow:
   * - initially, the machine is initialized with inventory details and price of each item.
   * - when it receives a request for a product, it sends instructions to the screen,
   * - then it receives some money and delivers product and give back the change if applicable.
   * - when an error occurs at any point of time, it responds with the VendingError message.
   */

  case class Initialize(inventory: Map[String, Int], prices: Map[String, Int])
  case class RequestProduct(product: String)
  case class Instruction(instruction: String)  // message that a VM will show on screen
  case class ReceiveMoney(amount: Int)
  case class GiveBackChange(money: Int)
  case class DeliveredChange(amount: Int)
  case class Deliver(product: String)
  case class VendingError(errorMsg: String)
  case object ReceiveMoneyTimeOut


  // conventional way:
  class VendingMachine extends Actor with ActorLogging{
    implicit val executionContext = context.dispatcher

    override def receive: Receive = idle

    def idle: Receive = {
      case Initialize(inventory, prices) =>
        context.become(operational(inventory, prices))
      case _ => sender() ! VendingError("Machine is unavailable at the moment. Please try later...")
    }

    def operational(inventory: Map[String, Int], prices: Map[String, Int]): Receive = {
      case RequestProduct(product) =>
        inventory.get(product) match {
          case None | Some(0) =>
            sender() ! VendingError("Product is unavailable at the moment...")
          case Some(_) =>
            val price = prices(product)
            sender() ! Instruction(s"Please insert $price INR.")
            context.become(
              waitingForMoney(inventory, prices, product, 0, startReceiveMoneyTimeoutSchedule(), sender())
            )
        }
    }

    def waitingForMoney(inventory: Map[String, Int],
                        prices: Map[String, Int],
                        product: String,
                        money: Int,
                        moneyTimeOutSchedule: Cancellable,
                        requester: ActorRef
                       ) : Receive = {

      case ReceiveMoneyTimeOut =>
        requester ! VendingError("Request Timed Out")
        if(money > 0) requester ! GiveBackChange(money)
        context.become(operational(inventory, prices))

      case ReceiveMoney(amount) =>
        moneyTimeOutSchedule.cancel()
        val price = prices(product)
        if(money + amount >= price){
          requester ! Deliver(product)
          if(money + amount - price > 0) requester ! GiveBackChange(money + amount - price)
          val updatedProduct = inventory(product) - 1
          val newInventory = inventory + (product -> updatedProduct)
          context.become(operational(newInventory, prices))
        }
        else{
          val remainingMoney = price - amount - money
          requester ! Instruction(s"Please insert balance of $remainingMoney INR.")
          context.become(
            waitingForMoney(inventory, prices, product, money + amount, startReceiveMoneyTimeoutSchedule(), requester)
          )
        }
    }

    def startReceiveMoneyTimeoutSchedule() = {
      context.system.scheduler.scheduleOnce(1 second) {
        self ! ReceiveMoneyTimeOut
      }
    }
  }

  // Using akka FSM api:
  // Step 1: define states and data of the actor:
  sealed trait VendingState
  case object Idle extends VendingState
  case object Operational extends VendingState
  case object WaitingForMoney extends VendingState

  sealed trait VendingData
  case object UnInitialized extends VendingData
  case class Initialized(inventory: Map[String, Int], prices: Map[String, Int]) extends VendingData
  case class WaitingForMoneyData(inventory: Map[String, Int],
                                 prices: Map[String, Int],
                                 product: String,
                                 money: Int,
                                 requester: ActorRef) extends VendingData

  class VendingMachineFSM extends FSM[VendingState, VendingData] {
    /**
     *  In a FSM we do not have receive handlers to handle the reception of data.
     *  When a FSM receives the message, It generates an event.
     *  The event contains the message and data.
     *
     *  So in FSM we handle events and states and not messages directly...
     */

    startWith(Idle, UnInitialized)
    when(Idle){
      case Event(Initialize(inventory, prices), UnInitialized) =>
        goto(Operational) using Initialized(inventory, prices)
        // equivalent to context.become
      case _ =>
        sender() ! VendingError("Machine is unavailable at the moment. Please try later...")
        stay()
    }

    when(Operational) {
      case Event(RequestProduct(product), Initialized(inventory, prices)) =>
        inventory.get(product) match {
          case None | Some(0) =>
            sender() ! VendingError("Product is unavailable at the moment...")
            stay()
          case Some(_) =>
            val price = prices(product)
            sender() ! Instruction(s"Please insert $price INR.")
            goto(WaitingForMoney) using WaitingForMoneyData(inventory, prices, product, 0, sender())
        }
    }

    when(WaitingForMoney, stateTimeout = 1 second){
      case Event(StateTimeout, WaitingForMoneyData(inventory, prices, product, money, requester)) =>
        requester ! VendingError("Request Timed Out")
        if(money > 0) requester ! GiveBackChange(money)
        goto(Operational) using Initialized(inventory, prices)

      case Event(ReceiveMoney(amount), WaitingForMoneyData(inventory, prices, product, money, requester)) =>
        val price = prices(product)
        if(money + amount >= price){
          requester ! Deliver(product)
          if(money + amount - price > 0) requester ! GiveBackChange(money + amount - price)
          val updatedProduct = inventory(product) - 1
          val newInventory = inventory + (product -> updatedProduct)
          goto(Operational) using Initialized(newInventory, prices)
        }
        else{
          val remainingMoney = price - amount - money
          requester ! Instruction(s"Please insert balance of $remainingMoney INR.")
          stay() using WaitingForMoneyData(inventory, prices, product, money + amount, sender())
        }
    }

    whenUnhandled{
      case Event(_,_) =>
        sender() ! VendingError("command not found")
        stay()
    }
    onTransition{
      case stateA -> stateB => log.info(s"Transitioning from $stateA to $stateB")
    }

    initialize()
  }

}
