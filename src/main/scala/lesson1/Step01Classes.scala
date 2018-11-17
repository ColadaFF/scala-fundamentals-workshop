package lesson1

object Step01Classes extends App {

  //Defining a class
  class Person {
    val firstName = "David"
    val lastName = "Perez"

    def name: String = firstName + " " + lastName
  }

  //class instance
  val david = new Person
  println(david.name)

  // defining an object
  object alien {
    def greet(p: Person): String = {
      "Greetings, " + p.firstName + " " + p.lastName
    }
  }

  println(alien.greet(david))

  //class constructor
  class PersonWC(first: String, last: String) {
    val firstName: String = first
    val lastName: String = last

    def name: String = firstName + " " + lastName
  }

  val deco = new PersonWC("Deco", "Rubin")
  println(deco.name)

  // class constructor shorthand
  class PersonWCS(val firstName: String, val lastName: String) {
    def name: String = firstName + " " + lastName
  }

  /**
    * Exercises
    */

  /**
    * 1. write a counter class with the following specification
    * - Receives and Int in the constructor
    * - has methods inc and dec
    * Bonus:
    * - How can we count faster ?
    * - Default values to inc and dec
    * - Extend the counter to add a method adjust,
    * this should accept and Adder and return a new counter
    * with the result of applying the Adder to the count.
    * --- usage examples:
    * new Counter(10).inc.dec.inc.inc.count
    * Int = 12
    * new Counter(10).inc.inc(10).count
    * Int = 21
    *
    */


}
