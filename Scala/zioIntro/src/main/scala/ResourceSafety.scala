import zio._

import scala.io.Source

// third
object ResourceSafety extends ZIOAppDefault {

  /**
   * ZIO has another effect that models the resource safe construct so that there are no resource leaks in application.
   * This effect is provided by- `acquireReleaseWith`
   *
   * Syntax:
   * ZIO.acquireReleaseWith(acquireEffect)(releaseEffect){
   *    usageEffect
   * }
   */

    val app = ZIO.acquireReleaseWith(
      // acquire effect
      ZIO.attemptBlocking(Source.fromFile("/home/knoldus/Desktop/raghav/Scala/zioIntro/src/main/resources/test.txt"))
    )(
      // Release effect
      file => ZIO.attempt(file.close()).orDie
    ){ // usage effect
       file =>
         ZIO.attemptBlocking(file.getLines().mkString("\n"))
    }

  override def run: ZIO[Any, Throwable, String] = app
}

/**
 * Acquire-and-Release is suitable when we want to manage one resource,
 * but it’s not a good choice when we have multiple resources because -
 *    the ZIO.acquireReleaseWith constructs are not compostable.
 * ZIO has a composable data type for resource management called `ZManaged`.
 */


