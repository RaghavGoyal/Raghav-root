package LogicalProblems.Basic

import scala.io.StdIn

/**
 * Problem Statement:
 * Read a number and print the sum of multiples of 3 and 5 from 1 to that number.
 */
object Problem2 extends App {

  println("Enter a number")
  val num = StdIn.readInt()

  num match {
    case negative: Int if num < 0 => println("Please enter a positive number")
    case zero: Int if num == 0 => println("enter the number greater than 0")
    case _: Int => println(getSum(num))
  }

  private def getSum(number: Int): Int = {
    (1 to number).filter { num =>
      num % 3 == 0 || num % 5 == 0
    }.sum
  }
}
