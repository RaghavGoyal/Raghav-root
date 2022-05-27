package modulePattern.version1

import zio.clock.Clock
import zio.console.Console
import zio.{Has, UIO, URIO, URLayer, ZIO, ZLayer}

// creating an object that defines the module name
object loggingWithTimeStamp {

  // creating a type alias for service type
  type LogWithTimeStamp = Has[LogWithTimeStamp.Service]

  // companion object for the alias
  object LogWithTimeStamp{
    // service define in the form of trait
    trait Service{
      def log(line: String): UIO[Unit]
    }
    // provide implementation of service.
    val live: URLayer[Clock with Console, LogWithTimeStamp] =
    // if service has further dependencies, they are provided using ZLayer.fromServices method.
      ZLayer.fromServices[Clock.Service, Console.Service, LogWithTimeStamp.Service]{
        (clock: Clock.Service, console: Console.Service) =>
          // service implementation
          new Service {
            override def log(line: String): UIO[Unit] = for{
                current <- clock.currentDateTime.orDie
                _ <- console.putStrLn(s"[${current.toString}] $line").orDie
              } yield()
          }
      }

    // accessor method
    def logWithTimeStamp(line: String): URIO[LogWithTimeStamp, Unit] = ZIO.accessM(_.get.log(line))
  }
}
