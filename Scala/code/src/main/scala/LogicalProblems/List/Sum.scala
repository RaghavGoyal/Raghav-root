package LogicalProblems.List

/**
 * Program to compute the sum of all the numbers in a list.
 */
object Sum extends App {
  val list = List(1,2,3,4,5)
  val sum = getSum(list)
  println(sum)

  private def getSum(list: List[Int]) :Int = {
    list match {
      case Nil => 0
      case a::rest => a+getSum(rest)
    }
  }

}
