package persistentActors

import akka.actor.{ActorSystem, Props}

object Main extends App {
  import Counter._

  val system = ActorSystem("persistent-actor-demo")
  val counterActor = system.actorOf(Props[Counter])
  counterActor ! Cmd(Increment(3))
  counterActor ! Cmd(Increment(5))
  counterActor ! Cmd(Decrement(3))

  counterActor ! "print"

  Thread.sleep(1000)
  system.terminate()

}
