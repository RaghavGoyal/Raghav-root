import zio._
import zio.console.{Console, putStrLn}

object ResourceHandling extends App {

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = executeFinalized2.exitCode

  // just like conventional try/ catch and finally, zio offers finalizing mechanism
  // if an effect starts and then gets terminated for any reason, then the finalizer is executed.
  val finalizingEffect = UIO.effectTotal(println("Finalizing..."))
  val finalizedEffect = ZIO.fail("some failure").ensuring(finalizingEffect)
  // the effect inside ensuring will always execute just like finally block;
  // irrespective of original effect failing or succeeding.

  // ensuring can also be used with a succeeding effect:
  val finalized2 = ZIO.succeed("This is a successful effect").ensuring(finalizingEffect)
  val executeFinalized2 = for{
    value <- finalized2
    _ <- putStrLn(value)
  }yield ()
}
// Next: Fibres