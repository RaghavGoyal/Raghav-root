package LogicalProblems.String.misc

object Misc extends App {

  /**
   * Problem 1:
   * Write a Scala program to create a new string with
   * the last char added at the front and back of a given string of length 1 or more.
   */
  def solution1(input: String): Unit = {
    println(input.last + input + input.last)
  }

  solution1("est")

  /**
   * Problem 2:
   * Write a Scala program to check whether a string 'yt' appears at index 1 in a given string.
   * If it appears return a string without 'yt'
   * otherwise return the original string
   */

  def solution2(input: String): Unit ={
    println(
      if (input.drop(1).startsWith("yt")){
        input.take(1) + input.drop(3)
      }
      else input
    )
  }

  solution2("gytun")

  /**
   * Problem 3:
   * Write a Scala program to count the number of times a given character is present in a string.
   */

  def solution3(input: String, charToCheck: Char): Unit ={
    println(
      input.count(_ == charToCheck)
    )
  }
  solution3("rsghshs",'h')


}
