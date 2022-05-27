package modulePattern.version1

import modulePattern.version1.logging.{Logging, log}
import modulePattern.version1.loggingWithTimeStamp.LogWithTimeStamp
import modulePattern.version1.loggingWithTimeStamp.LogWithTimeStamp.logWithTimeStamp
import zio.{RIO, URIO}

object Main extends zio.App {

  // effect for logging demo
  val simpleLoggingApp: URIO[Logging, Unit] = log("hello world")
  val executor = simpleLoggingApp.provideLayer(Logging.live).exitCode

  // effect for loggingWIthTimeStamp Demo.
  val logWithDateTime = logWithTimeStamp("Hello world!")
  val executor2 = logWithDateTime.provideLayer(LogWithTimeStamp.live).exitCode

  override def run(args: List[String]) = executor

}
