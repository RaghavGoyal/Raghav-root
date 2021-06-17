package LogicalProblems.List

/**
 * Problem Statement:
 * Write a program to remove consecutive duplicates from a list.
 * Example:
 * List(1,1,1,2,2,3,4,1,2,3,4,4) -> List(1,2,3,4,1,2,3,4)
 */
object ConsecutiveDuplicates extends App {

  val list = List(1,1,1,2,2,3,4,1,2,3,4,4)

  val output = removeConsecutiveDuplicates(list)
  println(output)

  private def removeConsecutiveDuplicates[T](list: List[T]) :List[T] = {
    list match {
      case Nil => Nil
      case a::Nil => List(a)
      case a::b::rest =>
        if(a == b)
          removeConsecutiveDuplicates(a :: rest)
        else
          a :: removeConsecutiveDuplicates(b :: rest)
    }
  }
}
