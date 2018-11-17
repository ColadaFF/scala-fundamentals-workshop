package lesson1

object Step03CaseClasses extends App {


  /**
    * Case classes are a very useful shorthand for creating classes,
    * companion objects and many defaults in one simple step.
    * they are ideal for creating simple data holding classes
    * with the minimum amount of code.
    * And all we need to do is add the world "case" at the beginning
    * of the class definition.
    */

  case class Person(firstName: String, lastName: String) {
    def name: String = firstName + " " + lastName
  }

  val david = new Person("David", "Perez") // we have a class
  val david2 = Person("David", "Perez") // we have a companion object !

  println(david) // better to String
  // res0: Person = Person(David,Perez)

  /**
    * A good equals
    */
  new Person("David", "Perez").equals(new Person("David", "Perez"))
  // res0: Boolean = true

  new Person("David", "Perez") == new Person("David", "Perez")
  // res1: Boolean = true

  /**
    * A copy method to creating new instances from previous ones
    */
  david.copy()
  // res2: Person = Person(David,Perez)

  david.copy(firstName = "David2")

  // res3: Person = Person(David2,Perez)

  /**
    * Case objects
    * If you find that you are defining a case class without
    * any arguments in the constructor, you could instead
    * create a case object.
    * A case object is like a regular singleton object but,
    * like the case class, has a better toString method and
    * also extends the Product and Serializable traits.
    */


  case object Citizen {
    def firstName = "John"

    def lastName = "Sanchez"

    def name: String = firstName + " " + lastName
  }

  Citizen.toString

  // res0: String = Citizen

  /**
    * Pattern matching
    *
    * Until now we have interacted with objects by using methods or
    * accessing fields. With case classes we can interact in another way,
    * via pattern matching.
    *
    * Pattern matching is like an extended if expression that allows us
    * to evaluate an expression depending on the “shape” of the data.
    *
    * Syntax:
    *
    * expr0 match {
    *   case pattern1 => expr1
    *   case pattern2 => expr2
    *   ...
    * }
    *
    * Let's implement a StormTrooper that is looking for members of a
    * rebellion in Person objects.
    */

  object StormTrooper {
    def inspect(person: Person): String =
      person match {
        case Person("Luke", "Skywalker") => "Stop, rebel scum!"
        case Person("Han", "Solo") => "Stop, rebel scum!"
        case Person(first, last) => s"Move along, $first"
      }
  }




  /**
    * Exercises
    */

  /**
    * Simple finger
    * 1. Create a case class Cat that receives a colour (String)
    * and food (String)
    */

  /**
    * 2. Implement the previous counter class as a case class
    */

  /**
    * 3. Define an object ChipShop with a method willServe.
    * This method should accept a Cat and return true if the
    * cat’s favourite food is chips, and false otherwise.
    * Use pattern matching.
    */

}
