import zio._
import zio.console.{Console, putStrLn}
import zio.random.{Random, nextInt}

import java.io.IOException

object ProvideLayerDemo extends zio.App {

  val effect: ZIO[Console, Nothing, Unit] = putStrLn("Hello, World!").orDie
  val mainApp: ZIO[Any, Nothing, Unit] = effect.provideLayer(Console.live)

  // creating an app with multiple layers:
  val randomNumberGenerator: ZIO[Console with Random, IOException, Unit] = for{
    num <- nextInt
    _ <- putStrLn(s"generated random number: $num")
  }yield()

  val app2 = randomNumberGenerator.provideLayer(Console.live ++ Random.live)
  // since both console and random are provided by zio itself, there is no need to provide the live
  // implementations via provideLayer. This syntax can however be used when we need to provide
  // custom service implementations.
  // the app2 can also be executed like:
  val app3 = randomNumberGenerator.exitCode

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = app2.exitCode
}
// next: ModulePattern
