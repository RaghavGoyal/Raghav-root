package LogicalProblems.String.misc

object CopyCharFromString extends App {

  /**
   * Problem:
   *  Write a Scala program to create a new string which is 4 copies of the 2 front characters of a given string.
   *  If the given string length is less than 2 return the original string
   */

  val string = "tresdfg"

  println(
    if(string.length >= 2){
      string.take(2) * 4 + string.drop(2)
    }
    else string
  )



}
