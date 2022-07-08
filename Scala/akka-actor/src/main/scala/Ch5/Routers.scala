package Ch5

import akka.actor.{Actor, ActorLogging, ActorSystem, Props, Terminated}
import akka.routing.{ActorRefRoutee, Broadcast, FromConfig, RoundRobinGroup, RoundRobinPool, RoundRobinRoutingLogic, Router}
import com.typesafe.config.ConfigFactory

object Routers extends App {
  /**
   * Routers are used when it is required to delegate or separate work into other actors of similar kind.
   * Routers are middle level actors that forward message to other actors.
   */

  /**
   * Manual Router:
   */
  class Master extends Actor {
    // Step1: Define/create routee(s)
    private val slaves = (1 to 5).map{ id =>
      val slave = context.actorOf(Props[Slave], s"slave-$id")
      context.watch(slave)
      ActorRefRoutee(slave)
    }
    // Step2: create router using Routee(s) above
    private var router = Router(RoundRobinRoutingLogic(), slaves)

    override def receive: Receive = {
      // Step4: handle termination message
      case Terminated(ref) =>
        // remove the terminated ref from router
        router = router.removeRoutee(ref)
        // add new slave ref to the router
        val newSlave = context.actorOf(Props[Slave])
        context.watch(newSlave)
        router = router.addRoutee(newSlave)

      // Step3: Route the messages to slave via router created.
      case message =>
        router.route(message, sender())
    }
  }

  class Slave extends Actor with ActorLogging {
    override def receive: Receive = {
      case message => log.info(message.toString)
    }
  }

  val system = ActorSystem("Routers-demo")
  val master = system.actorOf(Props[Master], "MasterActor")

//  (1 to 10).foreach(id =>
//    master ! s"Hello-id:$id"
//  )

  /**
   * Different types of routing logic available:
   * 1. RoundRobin           -> sequence the incoming messages to routees one after another (in cyclic fashion)
   * 2. Ramdom               -> Randomly assigns the message to a routee.
   * 3. smallestMailbox      -> Assigns the incoming message to the routee with least number of messages in queue.
   * 4. broadcast            -> sends an incoming message to all the routee.
   * 5. scatter-gather-first -> broadcast the message and receives only the first response,
   *                            discardes all other response.
   * 6. Tail-chopping        -> Forwards the message to all routee sequentially until it receives first response,
   *                            All other replies are discarded
   * 7. consistent-hashting  -> All the messages with same hash are directed to same routee.
   */

  /**
   * Method2: POOL ROUTER:
   * A pool router is a router actor that has its own children.
   */
  val poolMaster = system.actorOf(RoundRobinPool(5).props(Props[Slave]), "PoolMaster")
//  (1 to 10).foreach(id =>
//    poolMaster ! s"Hello Pool Master [$id]"
//  )

  /**
   * Method 3: POOL ROUTER FROM CONF.
   * The pool router can also be created by reading the configurations from the conf files as:
   */

  val systemWithConfigFactory = ActorSystem(
    "routersDemo2",
    ConfigFactory.load().getConfig("routersDemo")
  )
  val poolMaster2 = systemWithConfigFactory.actorOf(FromConfig.props(Props[Slave]), "poolMaster2")
//  (1 to 10).foreach(id =>
//    poolMaster2 ! s"Hello poolmaster2 [${id}]"
//  )

  /**
   * Method 3:
   * Group Router:
   * Used when the actors are created elsewhere.
   */
  // ... elsewhere in application:
  val slaves = (1 to 5).map(id =>
    system.actorOf(Props[Slave], s"slave-$id")
  ).toList

  val slavePaths = slaves.map(_.path.toString)
  val groupMaster = system.actorOf(RoundRobinGroup(slavePaths).props())
//  (1 to 10).foreach( id =>
//    groupMaster ! s"[$id] Hello Group Master"
//  )

  /**
   * In the above approach also, the configuration can be picked from conf file. as:
   */

  val groupMaster2 = systemWithConfigFactory.actorOf(
    FromConfig.props(),
    "groupMaster2"
  )
//  (1 to 10).foreach(id =>
//    groupMaster2 ! s"[$id] Hello group master 2"
//  )

  /**
   * Special messages:
   */
  groupMaster ! Broadcast("hello all")
  // PoisionPill and Kill can not be routed.

}
// Dispatchers
