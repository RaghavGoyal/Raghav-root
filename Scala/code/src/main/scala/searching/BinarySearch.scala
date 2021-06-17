package searching

/**
 * Binary Search:
 * Binary search works on sorted list or array.
 * for each iteration, the mid element is identified and compared with element to search.
 * if match occurs then returns
 * if element to be searched is smaller than element in mid then recursively apply algo to the left side of list/array
 * if element to be searched is greater than element in mid then recursively apply algo to the right side of list/array
 */
object BinarySearch extends App {

  val list = List(10, 11, 13, 9, 5, 30, 14, 99, 55, 29, 35, 80, 75)

  val output = binarySearch(list, 29)
  println(output)

  private def binarySearch(list:List[Int], element: Int): Boolean = {
    binSearch(sortList(list),element)
  }

  private def sortList(list: List[Int]):List[Int] = {
    list match {
      case Nil => Nil
      case a::Nil => List(a)
      case a::b::rest => if(a < b) a :: sortList(b :: rest) else b :: sortList(rest :+ a)
    }
  }

  private def binSearch(list :List[Int], element: Int):Boolean = {
    val length = list.length
    val midIndex = length/2
    val midElem = list(midIndex)
    val (left,right) = list.splitAt(midIndex)

    if(midElem == element)
      true
    else if(midElem < element) binSearch(left,element)
    else binSearch(right,element)
  }

}
