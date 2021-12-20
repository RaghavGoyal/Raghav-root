package Ch3

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{CallingThreadDispatcher, TestActorRef, TestProbe}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

import scala.concurrent.duration.Duration

class SynchronousSpec extends WordSpecLike with BeforeAndAfterAll {
  implicit val system = ActorSystem("SynchronousSpec")
  override def afterAll(): Unit = {
    system.terminate()
  }

  import SynchronousSpec._

  "A counter" should{
    "synchronously increase its count" in {
      val counter = TestActorRef[Counter](Props[Counter])
      counter ! Inc

      assert(counter.underlyingActor.count == 1)
    }

    "synchronously increase its count when receive function is used to send the action " in {
      val counter = TestActorRef[Counter](Props[Counter])
      counter.receive(Inc)
      assert(counter.underlyingActor.count == 1)
    }

    "work on the calling thread dispatcher" in {
      val counter = TestActorRef[Counter](Props[Counter].withDispatcher(CallingThreadDispatcher.Id))
      val probe = TestProbe()

      probe.send(counter, Read)
      probe.expectMsg(Duration.Zero, 0)
    }
  }
}

object SynchronousSpec{

  case object Inc
  case object Read
  class Counter extends Actor {
    var count = 0
    override def receive: Receive = {
      case Inc => count = count + 1
      case Read => sender() ! count
    }
  }
}
