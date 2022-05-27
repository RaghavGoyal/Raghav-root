import zio._
import zio.internal.Executor

import java.util.concurrent.{LinkedBlockingDeque, ThreadPoolExecutor, TimeUnit}

object UserDefinedExecutor extends scala.App {
  /**
   * An executor is responsible for executing effects.
   * The way how each effect will be run (including detail of threading, scheduling, etc)
   * is separated from the caller.
   * So,
   * if we need to have a specialized executor according to our requirements,
   * we can create an executor as:
   */
  val customExecutor = Executor.fromThreadPoolExecutor(_ => 1024){
    new ThreadPoolExecutor(
      5,
      10,
      5000,
      TimeUnit.MILLISECONDS,
      new LinkedBlockingDeque[Runnable]()
    )
  }

  /**
   * The custom executor can mow be provided to the runtime as:
   */
  val runtime = Runtime.default.mapPlatform(_.withExecutor(customExecutor))

  runtime.unsafeRun(ZIO.effectTotal(println("Hello world...")))
}
