package practice

import akka.actor.{ActorLogging, FSM}

/**
 * A trade FSM has following states:
 *  - Init
 *  - Pending
 *  - Ineligible
 *  - Netted
 *  - Removed
 *  - NettedLocked
 *
 *  Events that can be received in Init state:
 *    - EqCreated (transition to Pending)
 *  Events that can be received in Pending state:
 *    - EqCancelled           (stay)
 *    - TradeClassified       (stay)
 *    - BucketTradePlaced     (stay)
 *    - BucketTradeRefUpdated (stay)
 *    - TradeUnclassified     (Transition to Ineligible)
 *    - TradeLate             (Transition to Ineligible)
 *    - TradeAboveTolerance   (Transition to Ineligible)
 *    - TradeExceededLimit    (Transition to Ineligible)
 *    - TradeInvalid          (Transition to Ineligible)
 *    - BucketTradeLate       (Transition to Ineligible)
 *    - BucketTradeRemoved    (Transition to Removed)
 *    - BucketTradeAggregated (Transition to Netted)
 *  Events that can be received in Netted state:
 *    - EqCancelled        (stay)
 *    - BucketTradeBusted  (Transition to Ineligible)
 *    - BucketTradeRemoved (Transition to Removed)
 *    - BucketTradeLocked  (NettedLocked)
 */
class TradeFSM {

  sealed trait State
  case object Init extends State
  case object Pending extends State
  case object Ineligible extends State
  case object Netted extends State
  case object Removed extends State
  case object NettedLocked extends State

  sealed trait TradeData
  case object Uninitialized extends TradeData
  case class Initialized(trade: Trade) extends TradeData
  case class Trade(tradeId: String, pb: String, eb: String, side: String, amount: Double)

  // messages:
  case class EqCreated(trade: Trade)
  case class EqCancelled(trade: Trade)

  class TradeStateMachine extends FSM[State, TradeData] with ActorLogging {

    startWith(Init, Uninitialized)

    when(Init){
      case Event(EqCreated(trade), _) =>
        goto(Pending) using Initialized(trade)
      case _ =>
        log.info("Illegal event for uninitialized trade.")
        stay()
    }

    when(Pending){
      case Event(EqCancelled(trade), tradeData: Initialized) =>
        if(tradeData.trade.tradeId == trade.tradeId)
          stay() using Uninitialized
        else
          stay() using tradeData

      case Event()
    }
  }

}

object Main extends App{

}
