package LogicalProblems.Basic

import scala.io.StdIn

/**
 * Problem Statement:
 * Write a program that prints the next 20 leap years
 */
object Problem6 extends App {
  val infoMessage = "Enter the current year:"

  println(infoMessage)
  val currentYear = StdIn.readInt()

  println((currentYear until 3000 filter isLeapYear).toList.take(20))

  private def isLeapYear(year: Int): Boolean = {
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
  }
}
