import zio._
import zio.console.putStrLn
import zio.duration.durationInt

import scala.util.Try

object Parallelism extends App {
  // ZIO provides multiple methods to execute effects in parallel.
  // These methods are all named with a Par suffix that helps in identifying opportunities to parallelize code

  // For example,
  // the ordinary ZIO#zip method zips two effects together, sequentially.
  // But there is also a ZIO#zipPar method, which zips two effects together in parallel.

  // NOTE:
  // 1. For all the parallel operations, if one effect fails, others will be interrupted to minimize unnecessary computation.

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = (for{
    response <- app
    _ <- putStrLn(s"$response")
  }yield()).exitCode

  // ZIO lets you race multiple effects in parallel, returning the first successful result:
  val app = IO.succeed(10).race(IO.succeed(20))

  // Timeout:
  // ZIO lets you timeout any effect using the ZIO#timeout method,
  // which returns a new effect that succeeds with an Option.
  // A value of `None` indicates the timeout elapsed before the effect completed.

  val app2 = ZIO.fromTry(Try{
    Thread.sleep(2000)
    10
  }).timeout(1.second)


}
// next: Running effects
