package LogicalProblems.List

/**
 * Write a function that rotates a list by k elements.
 * For example: [1,2,3,4,5,6] rotated by two becomes [3,4,5,6,1,2].
 *
 * Note: Try solving this without creating a copy of the list
 */
object Rotate extends App {
  val list = List(1,2,3,4,5,6)

  val output = rotate(list,10)
  println(s"Original List: $list")
  println(s"Rotated List: $output")

  println(list.drop(10 % list.length) ++ list.take(10 % list.length))

  private def rotate(list:List[Any], times: Int): List[Any] = {
    if(times > 0){
      list match {
        case Nil => Nil
        case a::Nil => List(a)
        case a::tail => rotate(tail :+ a, times-1)
      }
    }
    else list
  }
}
