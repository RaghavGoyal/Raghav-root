package LogicalProblems.String.misc

object RemoveCharFromIndex extends App{

  /**
   * Remove the character at the given index from the given string.
   */

  val string = "test String"
  val indexToRemove = 6
  println(string.take(indexToRemove) + string.drop(indexToRemove+1))

  // alternate way:
  println(string.zipWithIndex.filter(_._2 != indexToRemove).map(_._1).mkString)

}
