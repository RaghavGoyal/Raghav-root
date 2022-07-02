package programs

import zio._
import zio.console.putStrLn

object Fibonacci extends App {

  def fibonacci(n:Int): UIO[Int] = {
    if(n <= 1)
      UIO.succeed(1)
    else{
      for{
        fibre1 <- fibonacci(n-2).fork
        fibre2 <- fibonacci(n-1).fork
        n1 <- fibre1.join
        n2 <- fibre2.join
      } yield n1 + n2
    }
  }

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = (for{
    number <- fibonacci(4)
    _ <- putStrLn(s"$number")
  }yield ()).exitCode
}
