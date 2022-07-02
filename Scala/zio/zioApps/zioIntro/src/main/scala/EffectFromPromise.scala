import zio._
import zio.console.putStrLn
import scala.util.{Failure, Success, Try}

object EffectFromPromise extends App {

  def function(str: String) = str.toUpperCase

  val app = for{
    promise <- ZIO.succeed(scala.concurrent.Promise[String]())
    _ <- ZIO.effect{
      Try{
        function("hello world from future...!")
      } match {
        case Success(value) => promise.success(value)
        case Failure(exception) => promise.failure(exception)
      }
    }.fork
    value <- ZIO.fromPromiseScala(promise)
    _ <- putStrLn(value)
  } yield()

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = app.exitCode
}

// next: Resource safety using bracket
