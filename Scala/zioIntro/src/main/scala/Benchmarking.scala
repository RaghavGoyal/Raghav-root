import zio._
import zio.internal.Platform

object Benchmarking extends scala.App {

  // create a runtime with benchmarking platform.
  //
  val runtime = Runtime.default.mapPlatform(_ => Platform.benchmark)

  // use this runtime to execute the effects/ app.

  /**
   * Note:
   * To do benchmark operation, we need a Runtime with settings suitable for that.
   * It would be better to disable tracing and auto-yielding.
   * ZIO has a built-in Platform proper for benchmark operations, called `Platform.benchmark`
   * which we can map the default Platform to the benchmark version as shown above...
   */
}

// next: ProvideLayer Demo
