package LogicalProblems.List

/**
 * Problem Statement:
 * Write a program that returns the elements on odd positions in a list
 */
object ElementsOnOddPosition extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75)
  val oddPositionElements = getOddPositionElements(list)
  println(s"Original List : $list")
  println(s"Odd position elements from List : $oddPositionElements")


  /**
   * :: operator is used to add an element to the beginning of list
   * @param list
   * @tparam T
   * @return
   */
  private def getOddPositionElements[T](list: List[T]): List[T] = {
    list match {
      case Nil => Nil
      case a::Nil => List(a)
      case odd::even::rest => odd :: getOddPositionElements(rest)
    }
  }

}
