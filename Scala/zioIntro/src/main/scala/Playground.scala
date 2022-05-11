import zio.{ExitCode, URIO}
import zio._
import zio.console.putStrLn

import scala.util.Try

object Playground extends App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = (for{
    resp <- task
    _ <- putStrLn(s"$resp")
  }yield()).exitCode

  val failingEffect: Task[Int] = ZIO.fromTry(Try{
    println("trying to divide by 0")
    10/0
  })
//  val effectWithRetry: ZIO[Any with Clock, Throwable, Int] = failingEffect.retryOrElse(Schedule.once, ZIO.succeed("hello"))

  val task = ZIO.succeed("hello").mapEffect(_.toInt)


}
