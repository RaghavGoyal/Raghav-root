package LogicalProblems.List
/**
 * Problem Starement:
 * Write a program that calculates and print the running total of a list.
 * Condition: Running total should be printed at each step.
 *
 * Running Total: is the sum of elements of list starting from 0.
 * Example:
 * List(1,2,3)
 * Elements  RunningTotal
 *  1           1
 *  2           3
 *  3           6
 *
 * Note: For input type string, running total will be string concatenation at each step
 */
object RunningTotal extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75)

  printHeader
  getRunningTotal(list)

  private def getRunningTotal(list: List[Int], initialSum: Int = 0): Unit = {
    list match {
      case Nil =>
      case a::Nil => printStep(a, initialSum+a)
      case a::rest =>
        val sum = initialSum + a
        printStep(a,sum)
        getRunningTotal(rest, sum)
    }
  }

  private def printStep(element: Int, stepTotal: Int) = {
    val step = s"$element          $stepTotal"
    println(step)
  }

  private def printHeader = {
    val header = s"Element     RunningSum"
    println(header)
  }

}
