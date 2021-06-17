package LogicalProblems.List

import scala.annotation.tailrec

/**
 * Problem Statement:
 * Write a program to find the largest element of List
 */

object LargestElement extends App {
  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75, 72)

  val max = getMax(list)

  println(max)

  @tailrec
  private def getMax(list : List[Int]): Int = {
    list match {
      case Nil => 0
      case a :: Nil => a
      case a :: b :: rest => getMax( (if(a > b) a else b) :: rest )
    }
  }

}
