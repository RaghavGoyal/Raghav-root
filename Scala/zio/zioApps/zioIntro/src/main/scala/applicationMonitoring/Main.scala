package applicationMonitoring

import zio._
import zio.console.{getStrLn, putStrLn}
import zio.zmx.diagnostics.{Diagnostics, ZMXSupervisor}
// library dependency used is:
// libraryDependencies += "dev.zio" %% "zio-zmx" % "0.0.6"
// refer build.sbt.
object Main extends scala.App {

  val app = for{
    _ <- putStrLn("Please enter your name...")
    name <- getStrLn
    _ <- putStrLn(s"Hello $name. Welcome to ZIO...!")
  }yield()

  val diagnosticsLayer: ZLayer[ZEnv, Throwable, Has[Diagnostics]] =
    Diagnostics.make("localhost", 9000)

  val runtime = Runtime.default.mapPlatform(_.withSupervisor(ZMXSupervisor))

  runtime.unsafeRun(app.provideCustomLayer(diagnosticsLayer))

}
// next: application tracing.
