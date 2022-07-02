package customRuntime

import zio.{Has, UIO, URIO, ZIO}

trait Logging {

  def log(line : String) : UIO[Unit]

}

object Logging{
  def log(line: String): URIO[Has[Logging], Unit] = {
    ZIO.serviceWith[Logging](_.log(line))
  }
}
