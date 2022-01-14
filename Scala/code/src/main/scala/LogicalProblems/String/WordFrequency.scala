package LogicalProblems.String

/**
 * Problem Statement:
 * Write a program to find and print the occurrence of each word in string
 */
object WordFrequency extends App {
  val input = s"hello hi hello bye bye hello hi bye bye"

  val output = getFrequencyOfWords(input)
  println(output)

  val output2 = getFrequencyOfWordsUsingMap(input)
  println(output2)

  private def getFrequencyOfWords(string: String) = {
    val words = string.split(" ").toList
    words.distinct.map { word =>
      (word, getCount(word, words))
    }
  }

  private def getFrequencyOfWordsUsingMap(string: String) = {
    val wordToFrequencyMap = scala.collection.mutable.Map[String, Int]()
    string.split(" ").toList.foreach{word =>
      if(wordToFrequencyMap.contains(word))
        wordToFrequencyMap.update(word, wordToFrequencyMap(word) + 1)
      else
        wordToFrequencyMap.put(word, 1)
    }
    wordToFrequencyMap
  }

  private def getCount(word: String, list: List[String]) : Int = {
    list match {
      case Nil => 0
      case a::Nil => if(a == word) 1 else 0
      case a::rest => (if(a == word) 1 else 0) + getCount(word,rest)
    }
  }

}
