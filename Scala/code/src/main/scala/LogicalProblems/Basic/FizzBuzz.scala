package LogicalProblems.Basic

import scala.io.StdIn

object FizzBuzz extends App {
  println("enter upperbound: ")
  val input = StdIn.readInt()
  println(fizzBuzz(input))

  private def fizzBuzz(number: Int) = {
    (1 to number).toList.map(getFizBuzzz).mkString(" ")
  }

  private def getFizBuzzz(i: Int) = {
    i match {
      case a if(a % 15 == 0) => "FizzBuzz"
      case b if(b % 3 == 0) => "Fizz"
      case c if(c % 5 == 0) => "Buzz"
      case _ => i.toString
    }
  }

}
