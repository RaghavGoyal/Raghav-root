package customRuntime

import zio.internal.Platform
import zio.{ExitCode, Has, Runtime, URIO}

object Main extends scala.App {
  val customRuntime1 = Runtime(
    Has.allOf[Logging, Email](LoggingLive(), MockEmail()),
    Platform.default
  )

  // the custom runtime can also be created using default runtime as follows:
  // here we map the default zio env with the services that we want to add.
  val customRuntime2 = Runtime.default.map((zenv: zio.ZEnv) =>
    zenv ++ Has.allOf[Logging, Email](LoggingLive(), MockEmail())
  )

  customRuntime1.unsafeRun(
    for{
      _ <- Logging.log("This is a logger...")
      _ <- Email.send("testUser", "Sending a testing mail...")
    }yield()
  )
}
