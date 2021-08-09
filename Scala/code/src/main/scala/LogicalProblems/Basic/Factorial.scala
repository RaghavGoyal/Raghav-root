package LogicalProblems.Basic

import scala.io.StdIn

object Factorial extends App {
  println("enter a number")
  val input = StdIn.readInt()
  val factorial = getFactorial(input)
  println(factorial)

  private def getFactorial(num: Int): Int ={
    if(num>1)
      num * getFactorial(num-1)
    else
      1
  }
}
