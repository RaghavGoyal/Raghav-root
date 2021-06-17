package sorting

/**
 * Selection Sort works by identifying the minimum value at each iteration and then placing it at the correct index.
 */
object SelectionSort extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 19, 29, 35, 80, 75)

  val sortedList = selectionSort(list)
  println(sortedList)

  private def selectionSort(list:List[Int]) : List[Int] = {
    list match {
      case Nil => Nil
      case a::Nil => List(a)
      case a::rest =>
        val min = findMin(rest)
        if(a < min)
          a :: selectionSort(rest)
        else selectionSort(rest :+ a)
    }
  }

  private def findMin(list:List[Int]) :Int = {
    list match {
      case a::Nil => a
      case a::b::rest => findMin((if(a < b) a else b)::rest)
    }
  }

}
