import zio._
import zio.internal.Platform

import java.lang.management.PlatformLoggingMXBean
import scala.concurrent.ExecutionContext.Implicits.global

// there are couple pf ways tp execute the effects.
// 1. using App trait and overriding the run method (that we have been doing so far)
// 2. using default runtime.
object RunningEffects extends scala.App {
  val runtime = Runtime.default
  runtime.unsafeRun(ZIO(println("hello World!")))
  runtime.unsafeRunToFuture(ZIO.succeed("hello")).map(println)

  // creating custom runtime
  val customRuntime = Runtime(10, Platform.default)
//  customRuntime.unsafeRun()
}

// effect from promise
