package LogicalProblems.String

import scala.io.StdIn

/**
 * Program to check if the given string is palindrome or not
 */
object Palindrome extends App {
  val infoMessage = s"Please enter a string: "
  println(infoMessage)
  val input = StdIn.readLine()

  println(isPalindrome(input))

  private def isPalindrome(str: String): Boolean = {
    val reversed = getReversedString(str)
    println(reversed)

    input.equalsIgnoreCase(reversed)
  }

  private def getReversedString(str: String): String = {
    str match {
      case empty if str.isEmpty => ""
      case s => getReversedString(s.tail) + s.head
    }
  }
}
