package lesson3

import lesson3.Step03AlgebraicTransformation.SuccessMap

object Step03AlgebraicTransformation extends App {

  /**
    * Algebraic Transformations
    *
    */

  /**
    * Let's use our Result[A] class from before
    */

  sealed trait Result[A]

  case class Success[A](result: A) extends Result[A]

  case class Failure[A](reason: String) extends Result[A]

  /**
    * Fold pattern:
    *
    * For an algebraic dataType A,
    * fold converts it to a generic type B.
    * Fold is a structural recursion with:
    *
    * - one function parameter for each case in A;
    * - each function takes as parameters the fields for its associated class;
    * - if A is recursive, any function parameters that
    * refer to a recursive field take a parameter of type B.
    */


  sealed trait ResultFold[A] {
    def fold[B](success: A => B, failure: B): B = {
      this match {
        case SuccessFold(result) => success(result)
        case FailureFold(_) => failure
      }
    }
  }

  case class SuccessFold[A](result: A) extends ResultFold[A]

  case class FailureFold[A](reason: String) extends ResultFold[A]


  val square = (value: Int) => value * value


  val folded: Int = SuccessFold(10).fold(square, 10)

  /**
    * Sequencing Transformation
    *
    *
    * Map:
    * Map is an operation on a type F[A] that
    * transforms it into F[B] using a function
    * A => B
    */

  sealed trait ResultMap[A] {
    def map[B](fn: A => B): ResultMap[B] = {
      this match {
        case SuccessFold(result) => SuccessMap(fn(result))
        case FailureFold(reason) => FailureMap(reason)
      }
    }
  }

  case class SuccessMap[A](result: A) extends ResultMap[A]

  case class FailureMap[A](reason: String) extends ResultMap[A]


  /**
    * Exercises
    */

  /**
    * 1. Maybe Fold
    * 2. Sum Fold
    * 3. Sum Map: if left return same left, if right,
    * apply the function to transform value
    */


}
