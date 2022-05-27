package modulePattern.version2

import zio.{Has, UIO, URLayer}
import zio.clock.Clock
import zio.console.Console

case class LoggingLive(console: Console.Service, clock: Clock.Service) extends Logging {

  override def log(line: String): UIO[Unit] = for{
    current <- clock.currentDateTime.orDie
    _ <- console.putStrLn(s"[${current.toString}] - $line").orDie
  } yield ()
}

object LoggingLive{

  val layer: URLayer[Has[Console.Service] with Has[Clock.Service], Has[Logging]] =
    (LoggingLive(_,_)).toLayer
}
