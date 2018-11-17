package lesson3

object Step02Functions extends App {

  /**
    * Functions
    *
    * Functions allow us to abstract over methods,
    * turning methods into values that we can pass
    * around and manipulate within our programs.
    *
    * Function types
    *
    * We write a function type like (A, B) => C where A and B
    * are the types of the parameters and C is the result type.
    * The same pattern generalises from functions of no arguments
    * to an arbitrary number of arguments.
    *
    * Syntax
    *
    * Declaration
    * (A, B, ...) => C
    *
    * where:
    *
    * A, B, ... are the types of the input parameters; and
    * C is the type of the result.
    */

  /**
    * Function literals
    *
    * Syntax
    *
    * (parameter: type, ...) => expression
    */


  val sayHi = () => "Hi!"

  sayHi()
  // String = Hi!

  val add1 = (x: Int) => x + 1
  // add1: Int => Int = <function1>

  add1(10)
  // res0: Int = 11

  val sum = (x: Int, y: Int) => x + y
  // sum: (Int, Int) => Int = <function2>

  sum(10, 20)
  // res0: Int = 30


}
