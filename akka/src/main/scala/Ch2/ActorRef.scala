package Ch2

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// Third:
// this class is a demo of using actor references.
// Actor references can be used to communicate between two or more actors.

object ActorRef extends App {

  class TestActor extends Actor {
    override def receive: Receive = {
      case "Hi" => sender() ! s"$self received hi from ${sender()}"
      case msg: String => println(s"[TestActor] Got String message: $msg from sender: $sender")
      case SendMessageToSelf(content) => self ! content   // Triggers the case above with content
      case SayHiTo(ref) => ref ! "Hi"   // Actor1 is being implicitly passed as sender here.
      case ForwardMessage(content, dest) => dest forward(s"$content; can be manipulated here")  // sender here wont be actor1.
    }
  }

  val actorSystem = ActorSystem("TestActorSystem")

//  Sending message to self:
  val actorSelf = actorSystem.actorOf(Props[TestActor], "selfActor")
  case class SendMessageToSelf(content: String)
  actorSelf ! SendMessageToSelf("I am self actor and I am sending message to myself")

//  Application of actor ref:
//  1. sending message to a given actor reference (as above).
//  2. sending message/reply to the sender reference.
//  3. forwarding the message to a given actor reference.

//  sending message to a given actor reference
  val actor1 = actorSystem.actorOf(Props[TestActor], "Actor1")
  val actor2 = actorSystem.actorOf(Props[TestActor], "Actor2")
  case class SayHiTo(ref: ActorRef)
  actor1 ! SayHiTo(actor2)    // Actor 2 reference here can be from same or different actor system.

//  sending message/reply to the sender reference:
//  For sending reply to the sender actor ref, the sender() is used that returns the reference to the sender actor.
//  Note: whenever the tell method is invoked, the sender actor reference is implicitly passed.

//  forwarding the message to a given actor reference:
  case class ForwardMessage(content: String, destination: ActorRef)
  actor1 ! ForwardMessage("this is forwarded message", actor2)
}
// NEXT: ActorBehaviour
