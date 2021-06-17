package LogicalProblems.List

/**
 * Write a function that merges two sorted lists into a new sorted list.
 * [1,4,6],[2,3,5] → [1,2,3,4,5,6].
 * You can do this quicker than concatenating them followed by a sort.
 */
object CombineSortedList extends App {
  val list1 = List(1,4,6)
  val list2 = List(2,3,5,7,9)

  val output = combineSortedList(list1,list2)
  println(output)

  private def combineSortedList(list1:List[Int], list2:List[Int]) :List[Int] = {
    (list1,list2) match {
      case (Nil,Nil) => Nil
      case (a,Nil) => a
      case (Nil,b) => b
      case (a::rest1,b::rest2) =>
        if(a < b) a :: combineSortedList(rest1,b::rest2)
        else b :: combineSortedList(a::rest1,rest2)
    }
  }
}
