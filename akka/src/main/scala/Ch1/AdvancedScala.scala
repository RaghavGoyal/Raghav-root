package Ch1

object AdvancedScala extends App{

  /**
   * Partial Functions:
   */
  val partialFunction: PartialFunction[Int, Int] = {
    case 1 => 10
    case 2 => 20
    case 3 => 30
  }

//  simplified syntax for creating the partial function
  val pf = (x: Int) => x match {
    case 1 => 10
    case 2 => 20
    case 3 => 30
  }

//  lifting the partial function:
//  Lifting means converting a partial function to a total function.
//  the total function will return Option[Int] in this case.

  val lifted1 = partialFunction.lift(2)  // Some(20) because the partial function is defined at 2
  val lifted2 = partialFunction.lift(5)  // None because the partial function is not defined at 5
  println(lifted1)
  println(lifted2)

//  Chain Partial function with additional definition:
//  use orElse method.

  val chained = partialFunction.orElse[Int, Int]{
    case 4 => 40
    case 5 => 50
  }

  println(chained(4))   // from chained partial function
  println(chained(2))   // from initial partial function
//  chained(6)          // will throw match error

  /**
   * Creating type alias:
   */
//  type alias is used to provide alternate type name to a more complex type.
  type Alias = PartialFunction[Int, Int]
  val partialFunctionWithAlias : Alias = {
    case 1 => 1
    case 2 => 4
    case 3 => 9
  }
  println(partialFunctionWithAlias(2))

  /**
   * Implicits:
   */
  implicit val timeOut = 3000
  def withTimeout(function: () => Unit)(implicit timeOut: Int) = function()

  withTimeout(() => println("This method will be invoked with timeout of 3000"))

//  Implicit Conversions by means of method:
  case class Person(name: String) {
    def greet = s"Hello, I am $name"
  }
  implicit def stringToPerson(string: String) = Person(string)

  println("Raghav".greet)   // implicit method converts the string to person object and then greet is called on person

//  Implicit conversion by means of class
  implicit class Dog(name: String) {
    def bark() = println("bark!!")
  }
  "Tommy".bark()

//  Compiler follows the following order for looking up the implicits:
//  1. Local scope
//  2. Imported scope
//  3. Companion object of the object involved

}
