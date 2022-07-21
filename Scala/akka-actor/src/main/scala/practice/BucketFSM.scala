package practice

import akka.actor.{ActorSystem, FSM, Props}
import practice.BucketFSM.{BucketStateMachine, MasterCutOff, MasterLock, TradeCancelled, TradeEligible}

/**
 * The objective of this task is to create a bucket FSM.
 * The bucket FSM has following states:
 *  - Init
 *  - Open
 *  - Cutoff
 *  - Locked
 *  - Busted
 *
 * Events received in Init state:
 *  - TradeEligible (Transition)
 * Events received in Open state:
 *  - TradeEligible (stay)
 *  - TradeCancelled (stay)
 *  - MasterCutOff (Transition)
 * Events received in Cutoff state:
 *  - TradeEligible (stay)
 *  - MasterLock (transition to locked)
 *  - TradeCancelled (Transition to Busted)
 *  - MasterBust (Transition to Busted)
 * Events received in Locked & Busted state:
 *  - TradeEligible (stay)
 *
 */
object BucketFSM {

  // States
  sealed trait State
  case object Init extends State
  case object Open extends State
  case object CutOff extends State
  case object Locked extends State
  case object Busted extends State

  // data
  case class BucketData(trades: List[String])

  // messages
  case class TradeEligible(trade: String)
  case class TradeCancelled(trade: String)
  case object MasterCutOff
  case object MasterBust
  case object MasterLock

  class BucketStateMachine extends FSM[State, BucketData]{

    startWith(Init, BucketData(List.empty))

    when(Init){
      case Event(TradeEligible(trade: String), BucketData(_)) =>
        log.info(s"Eligible trade received. Opening a new bucket...")
        log.info(s"Trade '$trade' added to bucket.")
        goto(Open) using(BucketData(List(trade)))
      case _ =>
        sender() ! "Bucket not open yet..."
        stay()
    }

    when(Open){
      case Event(TradeEligible(trade), BucketData(data)) =>
        val newData = data :+ trade
        log.info(s"Adding trade '$trade' to bucket. BucketData: ${newData}")
        stay() using(BucketData(newData))

      case Event(TradeCancelled(trade), BucketData(data)) =>
        val newData = data.filterNot(_.equals(trade))
        log.info(s"Removing $trade from bucket...")
        log.info(s"Bucket now contains: $newData")
        stay() using(BucketData(newData))

      case Event(MasterCutOff, BucketData(data)) =>
        log.info(s"Cutoff triggered... BucketData: $data")
        goto(CutOff) using(BucketData(data))
    }

    when(CutOff){
      case Event(TradeEligible(trade), bucketData) =>
        log.info(s"Can not add new trade to bucket after cutoff...")
        stay() using(bucketData)

      case Event(TradeCancelled(trade), bucketData: BucketData) =>
        log.info(s"Trade $trade cancelled... Bucket will bust now. BucketData: ${bucketData.trades}")
        goto(Busted) using(bucketData)

      case Event(MasterBust, bucketData: BucketData) =>
        log.info(s"Master caused bucket to Bust. BucketData: $bucketData")
        goto(Busted) using(bucketData)

      case Event(MasterLock, bucketData: BucketData) =>
        log.info(s"Going to locked state now... BucketData: ${bucketData.trades}")
        goto(Locked) using(bucketData)
    }

    when(Locked){
      case Event(TradeEligible, bucketData: BucketData) =>
        log.info(s"Can not add trade when locked. BucketData: ${bucketData.trades}")
        stay() using bucketData
      case _ =>
        sender() ! "Bucket locked. Can not perform this operation"
        stay()
    }

    when(Busted){
      case Event(TradeEligible, bucketData: BucketData) =>
        log.info(s"Can not add trade when Busted. BucketData: ${bucketData.trades}")
        stay() using(bucketData)
      case _ =>
        sender() ! "Could not apply this operation as Bucket is Busted..."
        stay()
    }
  }

}

object Main extends App {
  val system = ActorSystem("BucketFSM-demo")
  val bucketFSM = system.actorOf(Props[BucketStateMachine], "Bucket-1")

  bucketFSM ! TradeEligible("trade1")
  bucketFSM ! TradeEligible("trade2")
  bucketFSM ! TradeEligible("trade3")
  bucketFSM ! TradeCancelled("trade1")
  bucketFSM ! TradeEligible("trade4")
  bucketFSM ! MasterCutOff
  bucketFSM ! MasterLock

}
