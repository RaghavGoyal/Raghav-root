package LogicalProblems.String

import scala.io.StdIn

/**
 * Problem Statement:
 * Display the input string in a frame as:
 * Input: [Hello world in a frame]
 * Output:
 * * ***** *
 * * Hello *
 * * World *
 * * in    *
 * * a     *
 * * frame *
 * * ***** *
 */
object DisplayInFrame extends App {

  val infoMessage = s"Please enter a string: "
  println(infoMessage)
  val input = StdIn.readLine()

  createFrame(input)

  private def createFrame(string: String): Unit ={
    val words = string.split(" ").toList
    val maxWordLength = words.map{ word =>
        word.length
    }.max

    val modifiedWords = (("*"*maxWordLength) :: words ):+ ("*"*maxWordLength)

    modifiedWords.map{
      word =>
        createRow(word, maxWordLength)
    }.foreach(println)
  }
  private def createRow(string:String, maxLength:Int): String = {
    if(string.length == maxLength)
      s"* $string *"
    else{
      val space = " "*(maxLength - string.length)
      s"* $string$space *"
    }
  }
}
