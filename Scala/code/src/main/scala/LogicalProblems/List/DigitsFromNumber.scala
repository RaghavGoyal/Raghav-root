package LogicalProblems.List

import scala.io.StdIn

/**
 * Write a function that takes a number and returns a list of its digits.
 * For Example:
 * Input 2342 should return [2,3,4,2].
 */
object DigitsFromNumber extends App {

  val infoMessage = s"Please enter a number greater tha 0"
  println(infoMessage)
  val input = StdIn.readInt()

  val output = getListOfDigits(input)
  println(output)

  private def getListOfDigits(num: Int) : List[Int] = {
    if(num > 0)
      getListOfDigits(num/10) :+ (num % 10)
    else
      Nil
  }

}
