package Ch2

import Ch2.Exercise2.BankAccount.{Deposit, Statement, Withdraw}
import Ch2.Exercise2.Person.LiveLife
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
 * In this Exercise the objective is:
 * 1. to create a bank account class using actors. It should:
 *    - when received with withdraw message, the amount should be withdrawn from the balance.
 *    - when received with the deposit message, the amount should be deposited to the balance.
 *    - when received with statement message, the current balance should be printed.
 *
 *  2. The actor should respond to the sender with Success or Failure message depending on
 *     whether the operation performed is successful or not.
 *
 *  3. This actor should be used by different actor(s).
 *
 */
object Exercise2 extends App {

  object BankAccount{
    case class Deposit(amount: Int)
    case class Withdraw(amount: Int)
    case object Statement
    case class Transaction(status: String, message: String)
  }
  class BankAccount extends Actor {
    import BankAccount._
    var balance = 0
    override def receive: Receive = {
      case Deposit(amount) =>
        if(amount > 0){
          balance += amount
          sender() ! Transaction("Success", s"$amount deposited to your account")
        }
        else sender() ! Transaction("Failure", s"Invalid amount $amount")
      case Withdraw(amount) =>
        if(amount > 0 && balance >= amount) {
          balance -= amount
          sender() ! Transaction("Success", s"$amount withdrawn from your account")
        }
        else sender() ! Transaction("Failure", s"can not withdraw $amount.")
      case Statement => sender() ! Transaction("Success", s"Your balance is: $balance")
    }
  }

  object Person{
    case class LiveLife(account: ActorRef)
  }
  class Person extends Actor {
    import Person._
    override def receive: Receive = {
      case LiveLife(account) =>
        account ! Deposit(1000)
        account ! Deposit(2000)
        account ! Withdraw(100)
        account ! Statement
      case msg => println(s"From Person Actor: ${sender()} sent: $msg")
    }
  }

  val actorSystem = ActorSystem("ActorSystem")
  val accountActor = actorSystem.actorOf(Props[BankAccount], "BankAccount")
  val person = actorSystem.actorOf(Props[Person], "Person")

  person ! LiveLife(accountActor)
}
