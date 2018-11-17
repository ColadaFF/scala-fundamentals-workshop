package lesson1

object Step02Objects extends App {

  class Adder(amount: Int) {
    def add(in: Int): Int = in + amount
  }

  /**
    * In Scala, by convention, an object can be “called” like a function
    * if it has a method called apply.
    * Naming a method apply affords us a special shortened call syntax:
    * foo.apply(args) becomes foo(args).
    */
  class AdderApply(amount: Int) {
    def apply(in: Int): Int = in + amount
  }


  val add3 = new AdderApply(3) // add3: Adder = Adder@5e1d193b
  add3.apply(2) // res0: Int = 5
  add3(4) // shorthand for add3.apply(4)
  // res1: Int = 7

  /**
    * Function application syntax
    * This call: object.apply(parameter, ...)
    * can be also written as: object(parameter, ...)
    */

  /**
    * Companion objects
    * Where are static methods like in java ?
    * multiple constructors ?
    *
    * What if we want to create methods that belong to a class but
    * are independent of any particular object ?
    * In java we would use a static method, but in scala is simpler
    * a solution that we have seen already: Singleton objects
    *
    * Think about auxiliary constructor in a class, scala has a syntax
    * for that, but most scala developers prefer to have only one
    * constructor and multiple ways to calling that constructor, this
    * in the programming world is known as factories.
    * In Scala we would create a companion object,
    * and there, our factories.
    */

  class Timestamp(val seconds: Long)

  object Timestamp {
    def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
      new Timestamp(hours * 60 * 60 + minutes * 60 + seconds)
  }

  Timestamp(1, 1, 1).seconds
  // res1: Long = 3661

  /**
    * Exercise
    * Implement a companion object for Person containing
    * an apply method that accepts a whole name as a
    * single string rather than individual first and last names.
    *
    * -- Tip
    * You can split the parts into an array as follows:
    * val parts = "Juan Perez".split(" ")
    * parts(0) -> Juan
    * parts(1) -> Perez
    */


}
