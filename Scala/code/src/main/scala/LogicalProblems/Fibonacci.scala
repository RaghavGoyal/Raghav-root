package LogicalProblems

/**
 * Given the input, should print the fibonacci number of that position.
 * 0,1,1,2,3,5....
 * Given 1 => 0 output
 * given 5 => 3 output
 */
object Fibonacci extends App {

  def fibonacciNumber(element: Int): Int = {
    val fibo = scala.collection.immutable.List(0,1)
    if(element > 2)
      fibonacciNumber(element-1) + fibonacciNumber(element-2)
    else fibo(element-1)

  }
  println(fibonacciNumber(6))

}
