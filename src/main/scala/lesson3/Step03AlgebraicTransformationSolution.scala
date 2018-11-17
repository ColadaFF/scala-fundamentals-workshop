package lesson3

object Step03AlgebraicTransformationSolution extends App {

  /**
    * 1. Maybe Fold
    */

  sealed trait Maybe[A] {
    def fold[B](full: A => B, empty: B): B =
      this match {
        case Full(v) => full(v)
        case Empty() => empty
      }
  }

  final case class Full[A](value: A) extends Maybe[A]

  final case class Empty[A]() extends Maybe[A]


  /**
    * 2. Sum Fold
    * 3. Sum Map
    */

  sealed trait Sum[A, B] {
    def fold[C](left: A => C, right: B => C): C =
      this match {
        case Left(a) => left(a)
        case Right(b) => right(b)
      }

    def map[C](fn: B => C): Sum[A, C] =
      this match {
        case Left(value) => Left(value)
        case Right(value) => Right(fn(value))
      }
  }

  final case class Left[A, B](value: A) extends Sum[A, B]

  final case class Right[A, B](value: B) extends Sum[A, B]


}
