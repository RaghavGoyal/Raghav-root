package modulePattern.version1

import zio.{Has, UIO, URIO, ZIO, ZLayer}

// creating an object that defines the module name
object logging {

  // creating a type alias for service type
  type Logging = Has[Logging.Service]

  // companion object for the alias
  object Logging{
    // define a service in the form of a trait
    trait Service{
      def log(line: String) : UIO[Unit]
    }
    // provide implementation of service and lift that implementation using ZLayer.succeed
    val live = ZLayer.succeed(
      new Service {
        override def log(line: String): UIO[Unit] = ZIO.effectTotal(println(line))
      }
    )
  }

  // accessor method
  def log(line: String): URIO[Logging, Unit] = ZIO.accessM(_.get.log(line))

}
