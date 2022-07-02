package LogicalProblems.List

/**
 * Program to reverse the elements of list
 */

object Reverse extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75, 72)

  val reversedList = getReverseList(list)

  println(s"Original list : $list")
  println(s"Reversed list : $reversedList")
  println(s"Recursive: ${getReverseListRec(list)}")

  /**
   * `:+` is alias for append. Here first element is appended at the end of rest of list
   * @param list : input list of any type
   * @tparam T: place holder for generic type
   * @return : Reversed list of same type
   */
  private def getReverseList[T](list: List[T]) : List[T] = {
    list match {
      case Nil => Nil
      case first::Nil => List(first)
      case first::rest => getReverseList(rest ) :+ first
    }
  }

  // tail recursive:
  private def getReverseListRec[T](input: List[T], output: List[T]= List.empty): List[T] ={
    input match {
      case Nil => output
      case a::Nil => a::output
      case a::rest =>
        getReverseListRec(rest,a :: output)
    }
  }

}
