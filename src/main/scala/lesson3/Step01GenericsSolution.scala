package lesson3

object Step01GenericsSolution extends App {

  /**
    * 1. The Pair
    */

  case class Pair[A, B](one: A, two: B)


  /**
    * 2. The algebraic sum
    */

  sealed trait Sum[A, B]

  final case class Left[A, B](value: A) extends Sum[A, B]

  final case class Right[A, B](value: B) extends Sum[A, B]

  // This in scala standard library is known as the Either class


  /**
    * 3. Maybe that was a mistake
    */

  sealed trait Maybe[A]

  final case class Full[A](value: A) extends Maybe[A]

  final case class Empty[A]() extends Maybe[A]

}
