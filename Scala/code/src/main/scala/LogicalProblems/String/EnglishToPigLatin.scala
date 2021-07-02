package LogicalProblems.String

import scala.io.StdIn

/**
 * Problem:
 * English to PigLatin conversion.
 *
 * An English word is converted to Pig Latin by moving the first letter of word to last and adding 'ay' to it.
 * Example:
 * Input -> "The quick brown fox"
 * Output -> "Hetay uickqay rownbay oxfay”
 */
object EnglishToPigLatin extends App {
  val infoMessage = s"Enter the string you want to convert to Pig Latin: "
  println(infoMessage)

  val input = StdIn.readLine()

  val output = convertToPigLatin(input)
  println(output)

  private def convertToPigLatin(str: String): String = {
    val words = str.split(" ").toList
    words.map(convert).mkString(" ")
  }

  private def convert(word: String) : String = {
    val append = "ay"
    s"${word.tail}${word.head}$append".toLowerCase
  }
}
