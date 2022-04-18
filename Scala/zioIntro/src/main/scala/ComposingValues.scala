import zio._

import java.io.IOException
import java.util.UUID
import scala.util.Try

//Second
object ComposingValues extends ZIOAppDefault {

  /**
   * Using `for comprehension` for composing different ZIO effects.
   */

  val app: ZIO[Has[Console], IOException, Unit] = for {
    _ <- Console.printLine("Hello! What is your name?")
    n <- Console.readLine
    _ <- Console.printLine(s"Hello $n, Nice to meet you.")
  }yield ()

  /**
   * Using `zip` for composing multiple ZIO effects:
   */

    val app2: ZIO[Has[Console] with Has[Random], IOException, Unit] = for {
      _ <- Console.printLine("Enter the username:")
      response <- Random.nextUUID zip Console.readLine
      _ <- Console.printLine(s"uuid: ${response._1} and username: ${response._2}")
    }yield()

  override def run: ZIO[Has[Console] with Has[Random], IOException, Unit] = app

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

// next: Resource safety