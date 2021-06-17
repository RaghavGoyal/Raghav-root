package searching

/**
 * Linear Search iterates over the list or array and compares each element with the element to be searched;
 * Returns true if the match is found
 * else returns false
 */
object LinearSearch extends App {
  val list = List(1,2,8,4,6,9)
  val toFind = 6

  val output = linearSearch(list,toFind)
  println(output)

  private def linearSearch[T](list: List[T], element: T): Boolean = {
    list match {
      case Nil => false
      case a::rest => if(a == element) true else linearSearch(rest,element)
    }
  }
}
