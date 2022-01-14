package LogicalProblems.Basic

import scala.io.StdIn

object MinuteToHour extends App {
  println("enter the minutes")
  val input = StdIn.readInt()
  println(convertToHours(input))

  def convertToHours(i: Int) ={
    val hours = (i / 60).floor.toInt
    val minutes = i % 60
    "%02d : %02d".format(hours, minutes)
  }
}
