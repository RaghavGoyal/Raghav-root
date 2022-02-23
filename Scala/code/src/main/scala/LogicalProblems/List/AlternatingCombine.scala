package LogicalProblems.List

/**
 * Write a function that combines two lists by alternatingly taking elements
 * e.g. [a,b,c,d], [1,2,3] → [a,1,b,2,c,3,d].
 */
object AlternatingCombine extends App {
  val list1 = List(1,2,3)
  val list2 = List('a','b','c','d')

  val output = alternateCombine(list1,list2)
  println(output)

  // without recursion:
  println(list1.zipAll(list2, "","").flatMap{
    case (a,b) => Seq(a,b)
  }.filter(_ != ""))

  private def alternateCombine(list1: List[Any], list2: List[Any]) : List[Any] = {
    (list1,list2) match {
      case (Nil,Nil) => Nil
      case (Nil,_) => list2
      case (_,Nil) => list1
      case (a::rest1,b::rest2) => List(a,b) ::: alternateCombine(rest1, rest2)
    }
  }
}
