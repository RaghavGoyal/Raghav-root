package Ch2

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
 * In this exercise the objective is to create a voting system.
 * There should be two kinds of actors:
 *    1. Citizen actor
 *    2. VoteAggregator actor
 *
 *  The citizen actor should receive the message of type Vote(candidate); the citizen should be marked as voted.
 *  Also, VoteAggregator actor should be able to send message of type AggregateVotes(citizens: Set[ActorRef])
 *  to the citizen actor, asking who they have voted for.
 *  The VoteAggregator will ask for each citizen the status of vote from citizen actor via voteStatusRequest(actorRef)
 *  and basis the citizen has voted or not, will return the response via VoteStatusResponse(candidate: Option[String])
 *
 *  Finally, print the count of number of votes received by each candidate.
 */
object Exercise4 extends App {

  object Citizen{
    case class Vote(candidate: String)
    case object VoteStatusRequest
    case class VoteStatusResponse(candidate: Option[String])
  }
  class Citizen extends Actor {
    import Citizen._
    override def receive: Receive = {
      case Vote(candidate: String) => context.become(voted(candidate))
      case VoteStatusRequest => sender() ! VoteStatusResponse(None)
    }

    def voted(candidate: String): Receive = {
      case VoteStatusRequest => sender ! VoteStatusResponse(Some(candidate))
    }
  }

  object VotesAggregator{
    case class AggregateVotes(citizens: Set[ActorRef])
  }
  class VotesAggregator extends Actor {
    import VotesAggregator._
    import Citizen._
    override def receive: Receive = {
      case AggregateVotes(citizens: Set[ActorRef]) =>
        citizens.foreach( citizen => citizen ! VoteStatusRequest)
        context.become(awaitForStatusResponses(citizens, Map()))
    }

    def awaitForStatusResponses(waitingFor: Set[ActorRef], currentStats: Map[String, Int] ) : Receive = {
      case VoteStatusResponse(None) =>
        sender() ! VoteStatusRequest
      case VoteStatusResponse(Some(candidate)) =>
        val pending = waitingFor - sender()
        val currentVotesOfCandidate = currentStats.getOrElse(candidate, 0)
        val newStats = currentStats + (candidate -> (currentVotesOfCandidate + 1))
        if (pending.isEmpty)
          println(s"[VotesAggregator] Poll Stats are: $newStats")
        else
          context.become(awaitForStatusResponses(pending, newStats))
    }
  }

  import Citizen._
  import VotesAggregator._

  val votingSystem = ActorSystem("VotingSystem")
  val citizen1 = votingSystem.actorOf(Props[Citizen], "Name1")
  val citizen2 = votingSystem.actorOf(Props[Citizen], "Name2")
  val citizen3 = votingSystem.actorOf(Props[Citizen], "Name3")
  val citizen4 = votingSystem.actorOf(Props[Citizen], "Name4")

  citizen1 ! Vote("Candidate1")
  citizen2 ! Vote("Candidate2")
  citizen3 ! Vote("Candidate1")
  citizen4 ! Vote("Candidate1")

  val votesAggregator = votingSystem.actorOf(Props[VotesAggregator], "Aggregator")
  votesAggregator ! AggregateVotes(Set(citizen1, citizen2, citizen3, citizen4))
}
// parent-child actor after this.
