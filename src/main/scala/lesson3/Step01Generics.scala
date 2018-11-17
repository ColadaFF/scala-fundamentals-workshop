package lesson3

object Step01Generics extends App {

  /**
    * Generics
    *
    * Generic types allow us to abstract over types.
    * There are useful for all sorts of data structures,
    * but commonly encountered in collections.
    *
    * Syntax
    *
    * case class Name[A](...){ ... }
    * trait Name[A]{ ... }
    *
    *
    * Methods
    * def name[A](...){ ... }
    *
    *
    */

  final case class Box[A](value: A)


  val box = Box(2)
  // Box[Int] = Box(2)

  box.value
  // Int = 2

  val box2 = Box("hi") // if we omit the type parameter, scala will infer its value
  // Box[String] = Box(hi)

  box2.value

  // String = hi


  /**
    * What if we change the calculation class from before ?
    */

  sealed trait Calculation

  final case class SuccessCalculation(result: Double) extends Calculation

  final case class FailureCalculation(reason: String) extends Calculation

  /**
    * Translates to:
    */


  sealed trait Result[A]

  case class Success[A](result: A) extends Result[A]

  case class Failure[A](reason: String) extends Result[A]


  /**
    * Generic list
    *
    * Let's start with an int list
    */

  sealed trait IntList

  case object End extends IntList

  final case class PairInt(head: Int, tail: IntList) extends IntList

  /**
    * Now let's make it generic ...
    *
    * (Is this a linked list?)
    */

  sealed trait LinkedList[A]

  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  final case class End[A]() extends LinkedList[A]

  val example = Pair(1, Pair(2, Pair(3, End())))

  // Let's implement the length of this list.

  sealed trait LinkedListWithLength[A] {
    def length: Int =
      this match {
        case PairLength(hd, tl) => 1 + tl.length
        case EndLength() => 0
      }
  }

  final case class PairLength[A](head: A, tail: LinkedListWithLength[A]) extends LinkedListWithLength[A]

  final case class EndLength[A]() extends LinkedListWithLength[A]


  /**
    * Exercises
    */

  /**
    * 1. The pair class
    *
    * Implement a class that receives to generic arguments
    *
    * Example usage:
    *
    * val pair = Pair[String, Int]("hi", 2)
    */

  /**
    * 2. The algebraic sum
    *
    * Implement a trait Sum[A, B] with two subtypes Left and Right.
    * Create type parameters so that Left and Right can wrap up values
    * of two different types.
    *
    * Hint: you will need to put both type parameters on all three types.
    *
    * Example usage:
    *
    * Left[Int, String](1).value
    *   // res9: Int = 1
    *
    * Right[Int, String]("foo").value
    *   // res10: String = foo
    *
    * val sum: Sum[Int, String] = Right("foo")
    *   // sum: sum.Sum[Int,String] = Right(foo)
    *
    * sum match {
    *   case Left(x) => x.toString
    *   case Right(x) => x
    * }
    *   // res11: String = foo
    */

  /**
    * 3. Maybe that was a mistake
    *
    * Create a generic trait called Maybe of a
    * generic type A with two subtypes, Full containing
    * an A, and Empty containing no value.
    *
    * Example usage:
    *
    * val perhaps: Maybe[Int] = Empty[Int]
    *
    * val perhaps: Maybe[Int] = Full(1)
    */


}
