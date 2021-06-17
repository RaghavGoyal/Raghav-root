package LogicalProblems.List

/**
 * Program to find whether or not an element exists in list
 */
object Exists extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75, 72)

  println(exists(list, 99))

  private def exists[T](list: List[T], element: T): Boolean = {
    list match {
      case Nil => false
      case a::Nil => if(a == element) true else false
      case a::rest => if(a == element) true else exists(rest,element)
    }
  }

}
