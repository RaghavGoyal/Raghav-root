import zio._
import zio.console.Console

import java.io.IOException

// First
object HelloWorldApp extends App {

  val myApp: ZIO[Console, IOException, Unit] = console.putStrLn("Hello world !")

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = myApp.exitCode
}

/**
 * The core datatype around zio library is: `ZIO[R, E, A]`
 * R represents the dependency/ environment of the effect.
 * E represents the type of error that effect may throw in case of failure
 * A represents the return type of the effect
 *
 * In the above example, the type of myApp is ZIO[Has[Console], IOException, Unit].
 * The environment of this effect is Has[Console] meaning - ZIO Runtime needs the Console service to run this effect.
 * The E type parameter is IOException, and the A parameter is Unit.
 * This means that running this effect returns the Unit value or may throw IOException.
 */

// next: creating effects