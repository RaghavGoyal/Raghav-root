import zio._
import zio.console.{Console, putStrLn}

import java.io.FileNotFoundException

object HandlingError extends App {

  override def run(args: List[String]): URIO[Console, ExitCode] = multipleErrorsHandle.exitCode

  // using either:
  val failingEffectEither = ZIO.fail("This will fail...").either

  // absolve method is used to convert the either in success channel to a IO of that either types.
  // consider the example to find square root of a given double number:
  def sqrt(io: UIO[Double]): IO[String, Double] =
    ZIO.absolve(
      io.map(value =>
        if (value < 0.0) Left("Value must be >= 0.0")
        else Right(Math.sqrt(value))
      )
    )

  // call this executor in overridden run method and the above sqrt functional effect will be called.
  val sqrtExecutor = (for{
    error <- sqrt(ZIO.succeed(4.0))
    _ <- putStrLn(s"$error")
  }yield()).exitCode

  // catching all type of errors:
  def openFile(fileName: String): ZIO[Any, Throwable, String] = ???
  openFile("test").catchAll(_ => openFile("backup"))

  // catch particular type of error:
  openFile("test").catchSome{
    case _: FileNotFoundException => ??? // handle error as required.
  }

  // fallback: try another effect if first one fails:
  val test: ZIO[Any, Nothing, String] = openFile("config").orElse(ZIO.succeed("test"))

  // fold methods:
  // fold method can non-effectfully handle both success and failure simultaneously.
  case object DefaultData
  val primaryOrDefaultData = openFile("primary").fold(
    // failure case
    _ => DefaultData,
    // success case
    data => data
  )

  // similar handle can be effectfully done via foldM:
  val primaryOrSecondaryData = openFile("primary").foldM(
    _ => openFile("secondary"),
    data => ZIO.succeed(data)
  )

  val multipleErrorsHandle = IO.fail("e1").ensuring(IO.effectTotal(throw new Exception("e2"))).catchAll{
      case "e1" => putStrLn("e1")
      case "e2" => putStrLn("e2")
    }
  // error e1 is not absorbed here. thats the beauty of zio.
  /**
   * Conventional code equivalent of above:
   * try {
        try throw new Error("e1")
        finally throw new Error("e2")
      } catch {
     case e: Error => println(e)
    }
   absorbs the error e1 while exposing the error e2; though the actual cause of failure is e1.

   */

}
// Next: resource Safety using bracket
