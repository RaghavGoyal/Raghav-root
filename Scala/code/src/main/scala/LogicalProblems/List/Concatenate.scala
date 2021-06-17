package LogicalProblems.List

/**
 * Write a function that concatenates two lists.
 * [a,b,c], [1,2,3] → [a,b,c,1,2,3]
 */
object Concatenate extends App{
  val list1 = List(1,2,3)
  val list2 = List('a','b','c')

  val output = concatenateList(list1,list2)

  println(output)

  /**
   * ::: operator is used to add the elements of a list at the beginning of list.
   */
  private def concatenateList(list1: List[Any], list2:List[Any]): List[Any] = {
//    list1 ::: list2
    (list1,list2) match {
      case (Nil, Nil) => Nil
      case (a, Nil) => a
      case (Nil, b) => b
      case (a, b) => List(a, b).flatten
    }
  }

}
