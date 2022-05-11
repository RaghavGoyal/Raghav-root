import zio._
import zio.console._
import zio.random.Random

import java.io.IOException

object ComposingValues extends App {

  /**
   * Using `for comprehension` for composing different ZIO effects.
   */

  val app: ZIO[Console, IOException, Unit] = for {
    _ <- putStrLn("Hello! What is your name?")
    n <- getStrLn
    _ <- putStrLn(s"Hello $n, Nice to meet you.")
  }yield ()

  /**
   * Using `zip` for composing multiple ZIO effects:
   */

  val app2 = for {
    _ <- putStrLn("Enter the username:")
    response <- ZIO.succeed("123-456-789-ldkdhf") zip getStrLn
    _ <- putStrLn(s"uuid: ${response._1} and username: ${response._2}")
  }yield()

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = app.exitCode

  def parseToInt(s:String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
}

/**
 * In this example, three effects are composed  together.
 * First of all, we print a message for the user to insert his/her name,
 * then we read that from the console and
 * feed it another effect, which is responsible for printing another message to the user.
 */

//Next: HandlingError