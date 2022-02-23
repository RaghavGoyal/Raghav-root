package LogicalProblems.String.misc

object ExchangeFirstAndLastChar extends App {
  /**
   * The aim is to exchange the first and last characters from the input string and return the new string.
   */

  val string = "T"
  println(
    if(string.length > 1)
      string.last + string.tail.init + string.head
    else string
  )
}
