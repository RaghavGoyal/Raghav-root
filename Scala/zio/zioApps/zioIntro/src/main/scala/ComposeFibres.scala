import zio._
import zio.console.putStrLn

object ComposeFibres extends App {

  // zio lets you combine multiple fibres a into single fibre that provides the result of both the fibres.
  // this is done by composing the fibres using zip methods:

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = app2.exitCode

  val app = for{
    fibre1 <- ZIO.succeed(10).fork
    fibre2 <- ZIO.succeed(20).fork
    zipped = fibre1 zip fibre2
    tuple <- zipped.join
    _ <- putStrLn(s"tuple result: $tuple")
  }yield()


  // using orElse, the fibres can be composed in such a way that-
  // If the first fiber succeeds,
  //    the composed fiber will succeed with its result;
  // otherwise,
  //    the composed fiber will complete with the exit value of the second fiber (whether success or failure).

  val app2 = for{
    first <- IO.fail("This is failed").fork
    second <- IO.succeed("This is secondary response").fork
    composed = first.orElse(second)
    tuple <- composed.join
    _ <- putStrLn(tuple)
  }yield ()
}
// next: parallelism
