import zio._
import zio.console._

object BasicOperations extends App {

  override def run(args: List[String]): URIO[ZEnv, ExitCode] = (for{
   value <- zipRight1
    _ <- putStrLn(value)
  }yield()).exitCode

  // map over the success channel:
  val mapDemp = ZIO.succeed(10).map(_ + 1)

  // map over error channel:
  val mapErrorDemo = ZIO.fail("This is a failure").map(msg => s"[Map Error] $msg")
  // the above will not work since we re mapping over the effect and by default map operates on success channel.
  // to apply map on failure channel, use mapError as below:
  val mapErrorDemo2 = ZIO.fail("This is a failure").mapError(msg => s"[Map Error] $msg")

  // chaining/ sequencing operations:
  val sequenced =
    getStrLn.flatMap(input => putStrLn(s"You entered: $input"))

  // combining effects:
  // zip method can be used to combine effects in a tuple.
  // the resulting tuple contains the values from success of both the effects.

  val zipped1: ZIO[Any, Nothing, (Int, Int)] = ZIO.succeed(10) zip ZIO.succeed(100)
  // this would not generate a tuple since second effect is certain to fail.
  val zipped2: ZIO[Any, Int, (Int, Nothing)] = ZIO.succeed(11) zip ZIO.fail(100)
  // if first one failed, second one in zip becomes irrelevant.
  val zipped3: ZIO[Any, Int, (Nothing, Nothing)] = ZIO.fail(10) zip ZIO.fail(100)
  // above example is also the result of the fact that:
  // zip operates sequentially: the effect on the left side is executed before the effect on the right side.

  // there are also ZIO#zipLeft or ZIO#zipRight functions,
  // which first perform a zip, and then map over the tuple to discard one side or the other
  val zipRight1 = putStrLn("What is your name?").zipRight(getStrLn)

  // zipRight and zipLeft functions have symbolic aliases, known as *> and <*, respectively

}
// Next: Composing values