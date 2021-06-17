package LogicalProblems.Basic

import scala.io.StdIn

/**
 * Problem Statement:
 * Write a program that asks the user for a number n and
 * gives them the possibility to choose between computing the sum and computing the product of 1,…,n.
 */
object Problem3 extends App {
  println("Enter any number greater than 0")
  val num = StdIn.readInt()
  val choiceMessage =
    s"""
       |Select one operation:
       |S- To compute sum from 1 to $num
       |M- To compute product from 1 to $num
       |""".stripMargin

  println(choiceMessage)

  val operation = StdIn.readLine().trim
  operation match {
    case sum if operation.equalsIgnoreCase("s") => println(getSum(num))
    case product if operation.equalsIgnoreCase("m") => println(getProduct(num))
  }

  private def getSum(number: Int): Int = {
    (1 to number).reduce(_ + _)
  }

  private def getProduct(number: Int): Int = {
    (1 to number).reduce(_ * _)
  }
}
