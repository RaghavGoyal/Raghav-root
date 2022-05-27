package LogicalProblems.List

/**
 * Given a list that is not sorted,
 * the task is to determine the largest number out of it.
 */
object LargestNumber extends App {

  val list = List(10, 15, 5, 20, 13, 18, 55, 16, 19, 10, 15, 77)
  println(list.reduceRight((a, b) => if (a > b) a else b))

}
