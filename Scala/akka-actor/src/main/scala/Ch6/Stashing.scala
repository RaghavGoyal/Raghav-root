package Ch6

import akka.actor.{Actor, ActorLogging, ActorSystem, Props, Stash}

object Stashing extends App {
  /**
   * Stashing is the process of keeping a few messages aside that should not be processed at this exact point
   * of time.
   * Example:
   * There is an actor that has access to a resource. This resource be file.
   * When it is open, actor can receive the requests to read & write.
   * Otherwise, postpone all read-write requests until it is open.
   *
   * When an actor starts, it is in closed state.
   *  ResourceActor is open:
   *    read/write are handled
   *    close => switch to closed state
   *  ResourceActor is closed:
   *    Open => Switch to open state
   *    read/write => POSTPONE
   */

  case object Open
  case object Close
  case object Read
  case class Write(data: String)

  class ResourceActor extends Actor with ActorLogging with Stash {

    var innerData = ""

    override def receive: Receive = closed

    def closed: Receive = {
      case Open =>
        log.info("Opening the resource")
        unstashAll()
        context.become(open)
      case message =>
        log.info(s"Stashing the message [$message]")
        stash()
    }

    def open: Receive = {
      case Close =>
        log.info("Resource will be closed now...")
        unstashAll()
        context.become(closed)
      case Read =>
        log.info(s"Reading the data... \n Read data is: \n $innerData")
      case Write(data) =>
        log.info(s"Writing the data...")
        innerData = innerData + data
      case message =>
        log.info(s"Received $message while in Open State. Stashing....")
        stash()
    }
  }

  val system = ActorSystem("Stash-demo")
  val resourceActor = system.actorOf(Props[ResourceActor], "resource-actor")
  resourceActor ! Read
  resourceActor ! Open
  resourceActor ! Open
  resourceActor ! Write("I like stash")
  resourceActor ! Close
  resourceActor ! Read

  /**
   * Important consideration:
   * - There are potential memory bounds to stash and so you may not stash very large number of messages.
   * - Mailbox bounds may be affected due to un-stashing.
   * - You can not stash same message Twice as it will throw an exception.
   * - Stash trait should be mixed in last, because it overrides the preRestart lifecycle method.
   */




}
