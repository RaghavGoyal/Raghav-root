package Ch5

import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props}
import akka.dispatch.{ControlMessage, PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.{Config, ConfigFactory}

/**
 * Mailbox in Akka is a DS that holds the messages directed towards an actor.
 * It is based on a queue, and every incoming message is enqueued at the end.
 * This default behaviour of mailbox can be overridden using custom mailboxes.
 */
object Mailboxes extends App {

  val system = ActorSystem("MailboxDemo")

  class SimpleActor extends Actor with ActorLogging{
    override def receive: Receive = {
      case message => log.info(message.toString)
    }
  }

  /**
   * Creating custom priority mailbox
   */
  // Step 1: define a mailbox class that defines a PF to handle priorities as:
  class SupportTicketPriorityMailbox(settings: ActorSystem.Settings, config: Config)
      extends UnboundedPriorityMailbox(
        PriorityGenerator{
          // lesser the number is, higher is the priority
          case message: String if message.startsWith("[P0]") => 0
          case message: String if message.startsWith("[P1]") => 1
          case message: String if message.startsWith("[P2]") => 2
          case message: String if message.startsWith("[P3]") => 3
          case _ => 4
        }
      )
  // Step 2: Make this priority known in configuration (application.conf)
  // Step 3: attach dispatcher to an actor
  val supportTicketLogger = system.actorOf(Props[SimpleActor].withDispatcher("support-ticket-dispatcher"))
//  supportTicketLogger ! PoisonPill
  supportTicketLogger ! "[P1] Hello..."
  supportTicketLogger ! "[P0] Hi..."
  supportTicketLogger ! "[P3] Good..."

  /**
   * Irrespective of the sequence in which the messages are sent to the actor,
   * the are processed in accordance with the custom priority provided.
   * In such a case, even if PoisionPill is sent, it will be de-prioritised
   *
   * However, if the poision pill is sent in the beginning and then thread sleeps for some time,
   * and then those priority messages are sent, then they will be delivered to deadletters.
   *
   * Logical question is:
   * How long is the wait time? or until when the messages can be sent and be prioritised accordingly?
   * The answer is:
   * It can neither be determined nor be configured.
   * Reason: The processing of messages in mailbox happens when the actor is scheduled by the scheduler.
   * This scheduling is done by JVM and we programmers can not intervene there.
   *
   */

  /**
   * Control Aware mailbox:
   * We want to process some messages before regardless of what is already enqueued.
   * Done by using UnboundedControlAwareMailbox
   */
  // Step 1: Mark important messages as control messages:
  case object ManagementTicket extends ControlMessage

  // Step 2: Configure who gets the mailbox:
  // Make an actor attach to mailbox:
  val controlAwareSystem = ActorSystem(
    "Control-aware-system",
    ConfigFactory.load().getConfig("mailboxes-demo")
  )
  val controlAwareActor = controlAwareSystem.actorOf(
    Props[SimpleActor].withMailbox("control-mailbox"),
    "control-aware-actor"
  )

  // Step 3: Mark the above mailbox in configuration [application.conf]
  controlAwareActor ! "[P0] Very Important !"
  controlAwareActor ! "[P1] Important !"
  controlAwareActor ! ManagementTicket

  /**
   * Alternate way to configure mailbox is through deployment configuration.
   */
  val altControlAwareActor = controlAwareSystem.actorOf(Props[SimpleActor], "alt-control-aware-actor")
  altControlAwareActor ! "[P0] Very Important !"
  altControlAwareActor ! "[P1] Important !"
  altControlAwareActor ! ManagementTicket

}
// stashing in chapter 6
