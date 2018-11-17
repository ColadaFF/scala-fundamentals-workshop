package lesson2

object Step01Traits extends App {

  /**
    * Traits: AKA abstraction over classes.
    *
    * Traits are templates for creating classes,
    * in the same way that classes are templates
    * for creating objects.
    *
    * Traits allow us to express that two or more
    * classes can be considered the same and, therefore,
    * both implement the same operations.
    *
    * In other words, traits allow us to express that
    * multiple classes share a common super-type
    * (outside of the Any super-type that all classes share).
    *
    * Syntax:
    *
    * trait TraitName {
    * declarationOrExpression ...
    * }
    *
    *
    * class Name(...) extends TraitName {
    * ...
    * }
    *
    * case class Name(...) extends TraitName {
    * ...
    * }
    */


  /**
    * The visitors of the website.
    */

  import java.util.Date

  case class Anonymous(id: String, createdAt: Date = new Date())

  case class User(
                   id: String,
                   email: String,
                   createdAt: Date = new Date()
                 )

  import java.util.Date

  trait Visitor {
    def id: String

    def createdAt: Date
  }

  case class AnonymousWT(
                          id: String,
                          createdAt: Date = new Date()
                        ) extends Visitor

  case class UserWT(
                     id: String,
                     email: String,
                     createdAt: Date = new Date()
                   ) extends Visitor


  /**
    * This or That and Nothing else:
    * Sealed traits
    *
    * When we mark a trait as sealed we must define all
    * of its subtypes in the same file. Once the trait is sealed,
    * the compiler knows the complete set of subtypes and will warn
    * us if a pattern matching expression is missing a case.
    *
    *
    * Consider making subtypes final if there is no case for extending them
    */

  sealed trait VisitorSealed {
    /* ... */
  }

  final case class UserFinal(/* ... */) extends VisitorSealed

  final case class AnonymousFinal(/* ... */) extends VisitorSealed


  /**
    * Data modeling with traits...
    *
    *
    * Patterns:
    *
    * - Product type pattern
    * --- Description: "A has a B and C"
    *
    * case class A(b: B, c: C)
    *
    * trait A {
    *   def b: B
    *   def c: C
    * }
    *
    * - Sum type pattern.
    * --- Description: "A is a B or C"
    *
    * sealed trait A
    *   final case class B() extends A
    *   final case class C() extends A
    *
    *
    * - Algebraic Data Type.
    *
    * The algebraic data type is any that uses the
    * above two patterns.
    * In Functional programing literature,
    * “has-a and” pattern is known as a product type
    * “is-a or” pattern is a sum type.
    *
    *
    *
    * What about "is-a and" and "has-a or" ?
    *
    * - "is-a and" the reverse of the sum pattern
    *
    * trait B
    * trait C
    * trait A extends B with C
    *
    *
    * - "has-a or"
    * -- description: "A has a B or C"
    *
    * trait A {
    *   def d: D
    * }
    *
    * sealed trait D
    * final case class B() extends D
    * final case class C() extends D
    *
    *
    * Or: A is a D or E, and D has a B and E has a C
    *
    * sealed trait A
    * final case class D(b: B) extends A
    * final case class E(c: C) extends A
    */


  /**
    * Exercises
    */

  /**
    * 1. Not only cats!
    * Define a trait Feline and then define all the different
    * species as subtypes of Feline.
    *
    * Specs:
    * - on Feline a colour as before;
    * - on Feline a String sound, which for a
    * cat is "meow" and is "roar" for all other felines;
    * - only Cat has a favourite food;
    * - Lions have an Int maneSize.
    */


  /**
    * 2. The division problem.
    *
    * Dividing by zero is a tricky problem, it can lead to exceptions.
    * The JVM has us covered as far as floating point division is
    * concerned but integer division is still a problem:
    *
    * 1.0 / 0.0
    * // res0: Double = Infinity
    *
    * 1 / 0
    * // java.lang.ArithmeticException: / by zero
    *
    * Create an object called divide with an apply method
    * that accepts two Ints and returns DivisionResult.
    *
    * DivisionResult should be a sealed trait with two subtypes:
    * a Finite type encapsulating the result of a valid division,
    * and an Infinite type representing the result of dividing by 0.
    *
    * Usage example:
    *
    * val x = divide(1, 2)
    * // x: DivisionResult = Finite(0)
    *
    * val y = divide(1, 0)
    * // y: DivisionResult = Infinite
    */


  /**
    * 3. Traffic lights
    * A traffic light is red, green, or yellow.
    * Translate this description into Scala code.
    */

  /**
    * 4. Calculation
    * A calculation may succeed (with an Int result)
    * or fail (with a String message).
    * Translate this description into Scala code.
    */


}
