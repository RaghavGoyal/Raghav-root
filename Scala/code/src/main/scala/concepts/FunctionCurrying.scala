package concepts

/**
 * Function Currying:
 * it is a concept in scala where a function accepting multiple parameters can be converted to a function that takes
 * lesser parameters and remaining parameters can be provided later in the code.
 * Function currying at each point returns a new function that is partially resolved; i.e resolved with respect to
 * supplied parameter and remains unresolved for the parameter that is not yet supplied
 *
 */
object FunctionCurrying extends App {
  println("started execution")
  val partiallyAppliedFunction = functionWithMultipleParams(4,_)
  println("going to sleep for 5 seconds")
  Thread.sleep(5000)
  println("Back from sleep")
  println("executing the function")
  println(partiallyAppliedFunction(6))

  private def functionWithMultipleParams(a:Int, b:Int) ={
    a+b
  }
}
