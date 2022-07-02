import zio._

import java.io.IOException
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.StdIn
import scala.util.Try

object CreatingEffects extends App {

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = effectFromFuture.exitCode

  // creating effects from success values:
  // Succeed returns an effect that models success with the specified value
  val s1: UIO[Int] = ZIO.succeed(10)
  val s2: UIO[Boolean] = ZIO.succeed(true)
  val task1: UIO[Double] = Task.succeed(3.0)

  // creating effects from fail values:
  // Fail returns an effect that models failure with the specified value.
  val f1: IO[Int, Nothing] = ZIO.fail(10)
  val f2: IO[Boolean, Nothing] = ZIO.fail(false)

  // there is no restriction on the type of value that can be in success or fail.
  // custom types are also acceptable.
  case object Test
  val s3: UIO[Test.type] = ZIO.succeed(Test)
  val f3: IO[Test.type, Nothing] = ZIO.fail(Test)

  // creating effect from option:
  val optionEffect: IO[Option[Nothing], Boolean] = ZIO.fromOption(Some(true))
  optionEffect.mapError(_ => "Handle error")

  // creating effect from either:
  val eitherEffectRight: IO[Nothing, Test.type] = ZIO.fromEither(Right(Test))
  val eitherEffectLeft: IO[Error, Nothing] = ZIO.fromEither(Left(new Error("Some error")))

  // creating effects from try:
  val tryEffect: Task[Int] = ZIO.fromTry(Try(10/0))

  // creating effect from function:
  val effectFromFunction: URIO[Int, String] = ZIO.fromFunction((i:Int) => s"${i * i}")
  // fromFunction is deprecated in zio 2.0.0. so use following:
  val effectFromFunction2: URIO[Int, String] = ZIO.access((i: Int) => s"${i * i}")

  // creating effect from future:
  val future = Future{
    println("hello from future...")
    Thread.sleep(2000)
    println("Long process completed after 2 sec.")
    10
  }

  val effectFromFuture: Task[String] = ZIO.fromFuture{ implicit ec =>
      future.map(_ => "Good Bye...")(ec)
  }
  // the error type for such case is always throwable as future can always fail with throwable values.

  // creating effects from side effects:
  val effectFromSideEffect: Task[String] = ZIO.effect(StdIn.readLine())
  // the effect created using `effect` will fail with Throwable.
  // if it is already certain that side-effect will not fail, then use:
  val totalEffectFromSideEffect: UIO[Unit] = ZIO.effectTotal(println("hello"))
  // to refine error:
//  val errorRefinedEffect = ZIO.effect(StdIn.readLine()).refineOrDie[IOException]

  case class User(name: String)
  case class AuthError(errorMsg: String)
  object legacy {
    def login(
               onSuccess: User => Unit,
               onFailure: AuthError => Unit): Unit = ???
  }

  val login: IO[AuthError, User] =
    IO.effectAsync[AuthError, User] { callback =>
      legacy.login(
        user => callback(IO.succeed(user)),
        err  => callback(IO.fail(err))
      )
    }

  // the following blocking effect will be executed on a separate thread pool,
  // designed specifically for blocking effects.
//  val sleeping: Task[Unit] = ZIO.effectBlocking(Thread.sleep(Long.MaxValue))

}
// next: basic operation