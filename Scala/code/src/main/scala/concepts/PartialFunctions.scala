package concepts

/**
 * Partial Functions:
 * when a function is defined in such a way that it will produce the output only for a subset of input,
 * it is called partial function.
 *
 * Partial functions can be implemented in a number of ways
 */
object PartialFunctions extends App {
  /**
   * creating a partial function using trait
   */
  val pf = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int): Boolean = (x == 12)

    def apply(num: Int): Int = num * 12
  }
  /**
   * Calling a partial function
   */
  println(pf(12))
  println(pf(10))
}
