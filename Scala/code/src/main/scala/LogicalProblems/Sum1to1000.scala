package LogicalProblems

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * print and calculate the sum of the first 1000 natural numbers.
 * Should be done in batches of 100
 * Each batch should be executed in parallel (using future)
 */
object Sum1to1000 extends App {

  def calculateSum(start: Int, end: Int): Future[Int] = {
    Future((start to end).sum)
  }

  val range = Future.sequence((0 to 9).map(elem => calculateSum((elem*100)+1, (elem+1)*100))).map(_.sum)

  Thread.sleep(50)

  println(range)

}
