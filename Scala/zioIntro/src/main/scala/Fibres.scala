import zio._
import zio.console.putStrLn

object Fibres extends App {

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = (for{
    yieldResponse <- app3
    _ <- putStrLn(s"yield response: $yieldResponse")
  }yield ()).exitCode

  val app = for {
    // create a separate fibre using fork
    fibre <- IO.succeed("This is a succeeding effect that runs separate on fibre").fork
    // getting the value/ msg using join
    message <- fibre.join
    _ <- putStrLn(message)
  }yield()

  // join returns the effect that will succeed or fail depending on the fibre that is joined.

  // using await:
  val app2 = for{
    f <- IO.succeed("hello").fork
    value <- f.await
    _ <- putStrLn(s"value is: $value")
  }yield()
  // await provides not only the value with which the effect completes, it also describes how it has completed.

  // interrupting a running fibre:
  val app3 = for{
    f <- IO.succeed("hey").forever.fork
    exit <- f.interrupt
  }yield exit
  // Note: A fiber whose result is no longer needed may be interrupted,
  // which immediately terminates the fiber, safely releasing all resources and running all finalizers.

}
// Next: composing Fibres
