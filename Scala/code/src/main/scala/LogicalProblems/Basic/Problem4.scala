package LogicalProblems.Basic

/**
 * Problem Statement:
 * Write a program that prints a multiplication table for numbers up to 12.
 */

object Problem4 extends App {
  2 to 12 foreach (printTable)

  private def printTable(num: Int): Unit = {
    val info = s"Multiplication table for $num"
    println(info)
    1 to 10 foreach (
      tableRow(num, _)
      )
  }

  /**
   * will print row in the form:
   * a * b = product
   *
   * @param a number whose table is printed
   * @param b the row number that is to be printed
   */
  private def tableRow(a: Int, b: Int): Unit = {
    val row = s" $a * $b = ${a * b} "
    println(row)
  }

}
