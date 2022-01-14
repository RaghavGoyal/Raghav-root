package LogicalProblems.List

object NoOfElements extends App {

  val list = List(1,2,3,4,5,6,3,2,1,6,4,8,0)
  println(getNoOfElements(list, 0))

  private def getNoOfElements(list: List[Int], startcount:Int): Int ={
    list match{
      case Nil => startcount
      case a::rest => getNoOfElements(rest, startcount+1)
    }
  }

}
