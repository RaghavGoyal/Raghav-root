import zio.console.putStrLn
import zio.duration.durationInt
import zio.{Exit, ExitCode, URIO, ZIO}

object ExitStatus extends zio.App {
  val exitStatusDemoApp = for {
    // run method can be used to extract the exit status of any effect.
    exitStatus <- ZIO.succeed(1).run
    _ <- exitStatus match {
      case Exit.Success(value) =>
        putStrLn(s"exited with success value: ${value}")
      case Exit.Failure(cause) =>
        putStrLn(s"exited with failure state: $cause")
    }
  } yield ()

  val typesOfExitStatus = for {
    failExit <- ZIO.fail("Oh! Error!").run
    _ <- putStrLn(s"$failExit")
    dieExit  <- ZIO.effectTotal(5 / 0).run
    _ <- putStrLn(s"$dieExit")
    thenExit <- ZIO.fail("first").ensuring(ZIO.die(throw new Exception("second"))).run
    _ <- putStrLn(s"$thenExit")
    bothExit <- ZIO.fail("first").zipPar(ZIO.die(throw new Exception("second"))).run
    _ <- putStrLn(s"$bothExit")
    fiber    <- ZIO.sleep(1.second).fork
    _        <- fiber.interrupt
    interruptionExit <- fiber.join.run
    _ <- putStrLn(s"$interruptionExit")
  } yield ()

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = typesOfExitStatus.exitCode
}
// next: custom Runtime
