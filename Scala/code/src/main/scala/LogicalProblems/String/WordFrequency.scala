package LogicalProblems.String

/**
 * Problem Statement:
 * Write a program to find and print the occurrence of each word in string
 */
object WordFrequency extends App {
  val input = s"hello hi hello bye bye hello hi bye bye"

  val output = getFrequencyOfWords(input)
  println(output)

  private def getFrequencyOfWords(string: String) = {
    val words = string.split(" ").toList
    words.distinct.flatMap { word =>
      Map(word -> getCount(word, words))
    }
  }

  private def getCount(word: String, list: List[String]) : Int = {
    list match {
      case Nil => 0
      case a::Nil => if(a == word) 1 else 0
      case a::rest => (if(a == word) 1 else 0) + getCount(word,rest)
    }
  }

}
