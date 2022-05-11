package customRuntime

import zio.{UIO, ZIO}

case class LoggingLive() extends Logging {
  override def log(line: String): UIO[Unit] = ZIO.effectTotal(println(line))
}
