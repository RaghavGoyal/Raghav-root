package modulePattern.version2

import zio.{ExitCode, Has, IO, URIO}

object Main extends zio.App {

  val app: URIO[Has[Logging], Unit] = Logging.log("Application Started")

  val executor = app.provideSomeLayer((zio.console.Console.live ++ zio.clock.Clock.live) >>> LoggingLive.layer)

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = executor.exitCode
}
