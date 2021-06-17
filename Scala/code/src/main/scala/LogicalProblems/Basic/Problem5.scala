package LogicalProblems.Basic

import scala.io.StdIn

/**
 * Problem Statement:
 * Write a program that prints all prime numbers up to a given number.
 */

object Problem5 extends App {

  val infoMessage = "Enter a number up to which prime numbers should be printed:"
  val invalidInputMessage = "The input number is not valid. Please enter a number greater than 1."
  println(infoMessage)
  val num = StdIn.readInt()

  num match {
    case invalid: Int if num < 2 => println(invalidInputMessage)
    case _: Int => println(getPrimeNumbersUpTo(num))
  }

  private def getPrimeNumbersUpTo(number: Int): List[Int] = {
    (2 to number filter isPrime).toList
  }

  private def isPrime(number: Int): Boolean = {
    !(2 until number).exists(x => number % x == 0)
  }

}
