package Ch2

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
 * In this exercise, the objective is to create a distributed word counting system.
 * The distributed word counting system will consist of a master worker and one or multiple workers.
 *
 * The master will receive the message to initialize the n number of workers.
 * Then it will receive the msg containing the string whose words is to be counted.
 * The master will send the counting request to one of its worker (basis round robin)
 *  which will respond with a message containing the word count.
 * This count will be sent to the sender via master.
 */
object Exercise5 extends App {

  object WordCounterMaster{
    case class InitializeChild(n: Int)
    case class WordCountTask(taskId: Int, input: String)
    case class WordCountReply(id: Int, count: Int)
  }
  class WordCounterMaster extends Actor {
    import WordCounterMaster._
    override def receive: Receive = {
      case InitializeChild(n) =>
        val childRef = (1 to n).toList.map{
          id => context.actorOf(Props[WordCounterWorker], s"WordCountWorker$id")
      }
      context.become(wordCounterWithWorkers(childRef, 0, 0, Map()))
    }

    def wordCounterWithWorkers(childRef: List[ActorRef], currentWorkerIndex:Int, currentTaskId: Int, requestMap: Map[Int, ActorRef]) : Receive ={
      case input: String =>
        val newRequestMap = requestMap + (currentTaskId -> sender())
        childRef(currentWorkerIndex) ! WordCountTask(currentTaskId, input)
        val nextWorkerIndex = (currentWorkerIndex + 1) % childRef.length
        val nextTaskId = currentTaskId + 1
        context.become(wordCounterWithWorkers(childRef, nextWorkerIndex, nextTaskId, newRequestMap))

      case WordCountReply(taskId, count) =>
        val originalSender = requestMap(taskId)
        originalSender ! count
        context.become(wordCounterWithWorkers(childRef, currentWorkerIndex, currentTaskId, (requestMap - taskId) ))
    }
  }

  class WordCounterWorker extends Actor {
    import WordCounterMaster._
    override def receive: Receive = {
      case WordCountTask(taskId, input) =>
        sender() ! WordCountReply(taskId, input.split(" ").length)
    }
  }

  class TestActor extends Actor {
    import WordCounterMaster._
    override def receive: Receive = {
      case "go" =>
        val master = context.actorOf(Props[WordCounterMaster], "Master")
        val input = List("Hi I am", "Test input", "This is akka worker", "Scala is a great programming language")
        master ! InitializeChild(input.length)
        input.foreach(master ! _)
      case count: Int => println(s"[testActor] MasterResponded with: $count")
    }
  }

  val system = ActorSystem("wordCounterActorSystem")
  val testActor = system.actorOf(Props[TestActor], "test")
  testActor ! "go"

}
// Next: Actor Logging
