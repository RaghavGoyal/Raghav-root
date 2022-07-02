package Ch2

import Ch2.ActorBehaviour.Kid.AskState
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// Fourth
// This class shows the default behaviour of the actor.
object ActorBehaviour extends App {
  object Kid{
    val HAPPY = "happy"
    val SAD = "sad"
    case object AskState
  }
  class Kid extends Actor {
    import Kid._
    import Mother._
    var state = HAPPY
    override def receive: Receive = {
      case Food(`VEGES`) => state = SAD
      case Food(`JUNK`) => state = HAPPY
      case AskState => sender ! state
    }
  }

  object Mother{
    val VEGES = "vegetables"
    val JUNK = "chocolate"
    case class Food(item: String)
  }
  class Mother extends Actor {
    import Mother._
    import Kid._
    override def receive: Receive = {
      case StartInteraction(kidRef) =>
        kidRef ! AskState
        kidRef ! Food(VEGES)
        kidRef ! AskState
        kidRef ! Food(JUNK)
        kidRef ! AskState
      case msg => println(s"[Mother]: got the response $msg from $sender")
    }
  }

  case class StartInteraction(kid: ActorRef)

  val system = ActorSystem("ActorSystem")
  val motherActor = system.actorOf(Props[Mother])
  val kidActor = system.actorOf(Props[Kid])

  motherActor ! StartInteraction(kidActor)

//  Problem with the above code:
//  The major issue with the code above is that it uses var (mutable type variable) to change the state of kid.
//  in scala, this is not recommended.
//  so this can be avoided by changing the actor behaviour as follows:

//  Changing actor behaviour

  object StatelessKid{
    val HAPPY = "happy"
    val SAD = "sad"
  }
  class StatelessKid extends Actor {
    import StatelessKid._
    import Mother._

    override def receive: Receive = happyState

    def happyState: Receive = {
      case Food(`VEGES`) => context.become(sadState, false)   // stack.push
      case Food(`JUNK`) => context.unbecome()   // stack.pop
      case AskState => sender() ! HAPPY
    }

    def sadState: Receive = {
      case Food(`VEGES`) => context.unbecome()
      case Food(`JUNK`) => context.become(happyState, false)
      case AskState => sender() ! SAD
    }
  }
//  In this actor, instead of using the mutable variable, we have changed the context of the actor.
//  Setting discardOld to true: removes the context of previous state as it replaces the current handler
//  Setting discardOld to false: maintains the previous contexts in a stack as the previous handler is pushed on the stack

  val statelessKidActor = system.actorOf(Props[StatelessKid])
  motherActor ! StartInteraction(statelessKidActor)
}

// exercise 3 and 4 after this
