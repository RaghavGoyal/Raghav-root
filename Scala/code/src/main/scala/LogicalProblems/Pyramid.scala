package LogicalProblems

/**
 * Should print following pattern for given number of rows:
 * Ex: for 5 rows:
 *            *
 *           * *
 *          * * *
 *         * * * *
 *        * * * * *
 */
object Pyramid extends App {

  def printPyramid(rows: Int): Unit = {
    def printRow(rowNum: Int): Unit = {
      print(" "* (rows - rowNum))
      print("* " *rowNum)
      println()
    }

    (1 to rows).foreach(elem =>
      printRow(elem)
    )
  }

  printPyramid(100)
}
