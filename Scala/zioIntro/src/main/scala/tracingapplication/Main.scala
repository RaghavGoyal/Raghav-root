package tracingapplication

import zio.internal.Tracing
import zio.internal.tracing.TracingConfig
import zio.Runtime
import zio.console.{getStrLn, putStrLn}

object Main extends scala.App {

  val rt1 = Runtime.default.mapPlatform(_.withTracing(Tracing.disabled))
  val rt2 = Runtime.default.mapPlatform(_.withTracing(Tracing.enabledWith(TracingConfig.stackOnly)))

  val config = TracingConfig(
    traceExecution = true,
    traceEffectOpsInExecution = true,
    traceStack = true,
    executionTraceLength = 100,
    stackTraceLength = 100,
    ancestryLength = 10,
    ancestorExecutionTraceLength = 10,
    ancestorStackTraceLength = 10
  )
  val rt3 = Runtime.default.mapPlatform(_.withTracingConfig(config))

  rt3.unsafeRun(
      for{
      _ <- putStrLn("hello... enter the name...")
      name <- getStrLn
      _ <- putStrLn(s"Nice meeting you $name")
    } yield ()
  )

//  Note:
//  when we are doing benchmark operation, it is better to create a Runtime without tracing capability
//  because tracing has an expensive activity in terms of resources.
//  There are lots of allocations that all need to be garbage collected afterward.
//  So it has a tremendous impact on the complexity of the application runtime.
}
// next: benchmarking
