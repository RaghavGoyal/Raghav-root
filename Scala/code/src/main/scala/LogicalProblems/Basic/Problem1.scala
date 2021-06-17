package LogicalProblems.Basic

import scala.io.StdIn

/**
 * Problem Statement:
 * Write a program that asks the user for a number n and prints the sum of the numbers 1 to n
 */

object Problem1 extends App {
  /**
   * Reading user input from console
   */
  println("Enter a number:")
  val num = StdIn.readInt()
  num match {
    case invalid: Int if num < 0 => println("Invalid number: Enter number greater than 0")
    case zero: Int if num == 0 => println("Sum is calculated from 1 to higher number")
    case _: Int => println(getSum(num))
  }

  private def getSum(number: Int): Int = {
    (1 to number).sum
  }

}
