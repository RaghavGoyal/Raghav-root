package customRuntime

import zio.{Has, Task, URIO, ZIO}

trait Email {

  def send(user: String, content: String): Task[Unit]

}

object Email{
  def send(user: String, content: String): ZIO[Has[Email], Throwable, Unit] = {
    ZIO.serviceWith[Email](_.send(user, content))
  }
}