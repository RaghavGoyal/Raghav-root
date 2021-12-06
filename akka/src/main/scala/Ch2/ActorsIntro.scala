package Ch2

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {

//  creating an Actor System:
  /**
   *  An actor system is a heavy data structure that controls the number of threads under the hood.
   *  Actor system name can only contain the alpha-numeric characters, non-leading _ and -
   */
  val actorSystem = ActorSystem("FirstActor")

  /**  An actor system comprises of multiple actors.
   *   Each actor is uniquely identifiable (By name; passed while instantiating).
   *   Actors are like human beings; they receive your msg, process them when they are idle and respond accordingly.
   *   These messages are received asynchronously.
   *   Different actors may respond differently to same message.
   *   Actors are really encapsulated and hence, its difficult to read through them or force anything on them.
   */

//  creating actor:

  class WordCountActor extends Actor {
    var words = 0
//  Receive ia type alias for `PartialFunction[Any, Unit]`
    override def receive: Receive = {
      case msg: String =>
        println(s"[word counter]: received- $msg")
        words += msg.split(" ").length
      case _ => println("[word counter]: unable to read words")
    }
  }

//  Instantiating the actor:
  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordCounter")
  val wordCounter2 = actorSystem.actorOf(Props[WordCountActor], "wordCounter2")

//  Sending a message to the actor:
  wordCounter ! "This is a test string."
  wordCounter2 ! "This is a another test string."
//  The message sending to actor is completely asynchronous.

//  The actor class can not be instantiated using new keyword. It has to be created using the factory method.
//  Creating the actor from parameterised class.
  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case true => println(s"[Person]: received name- $name")
      case _ => println("[Person]: No name found.")
    }
  }

  val personActor = actorSystem.actorOf(Props(new Person("Raghav")), "Person1")
  personActor ! true

//  Tha above method of creating the instance of actor is discouraged. The most ideal way is using a companion object as:
  object Person{
    def props(name: String) = Props(new Person(name))
  }
  val personActor2 = actorSystem.actorOf(Person.props("Raghav"), "Person2")
  personActor2 ! true

}
