package LogicalProblems.List

/**
 * Write a function onAll that applies a function to every element of a list.
 * Use it to print the first twenty perfect squares.
 * The perfect squares can be found by multiplying each natural number with itself.
 * The first few perfect squares are 1*1= 1, 2*2=4, 3*3=9, 4*4=16.
 * Twelve for example is not a perfect square because there is no natural number m so that m*m=12.
 */
object on_all extends App {

  val list = (1 to 20).toList
  val output = onAll(getSquare,list)
  println(output)

  private def getSquare(number :Int) :Int = {
    number * number
  }

  private def onAll(fn: Int => Int, list:List[Int]) : List[Int] = {
    list match {
      case Nil => Nil
      case element::Nil => List(fn(element))
      case element::rest => fn(element) :: onAll(fn,rest)
    }
  }
}
