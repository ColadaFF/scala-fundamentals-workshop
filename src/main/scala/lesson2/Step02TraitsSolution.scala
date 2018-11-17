package lesson2

object Step02TraitsSolution extends App {

  /**
    * 1. Feline!
    */

  trait Feline {
    def colour: String

    def sound: String
  }

  case class Lion(colour: String, maneSize: Int) extends Feline {
    val sound = "roar"
  }

  case class Tiger(colour: String) extends Feline {
    val sound = "roar"
  }

  case class Panther(colour: String) extends Feline {
    val sound = "roar"
  }

  case class Cat(colour: String, food: String) extends Feline {
    val sound = "meow"
  }

  /**
    * What about that roar for all?
    */

  /**
    * Approach 1
    * Generally a bad practice.
    */

  trait FelineDefault {
    def colour: String

    def sound: String = "roar"
  }

  /**
    * Approach 2.
    * A better practice
    */

  trait BigCat extends Feline {
    override val sound = "roar"
  }

  /**
    * case class Tiger(...) extends BigCat
    * case class Lion(...) extends BigCat
    * case class Panther(...) extends BigCat
    */


  /**
    * 2. The division problem
    */

  sealed trait DivisionResult

  final case class Finite(value: Int) extends DivisionResult

  case object Infinite extends DivisionResult

  object divide {
    def apply(num: Int, den: Int): DivisionResult =
      if (den == 0) Infinite else Finite(num / den)
  }

  divide(1, 0) match {
    case Finite(value) => s"It's finite: ${value}"
    case Infinite => s"It's infinite"
  }

  // res0: String = It's infinite


  /**
    * 3. Traffic lights
    */

  sealed trait TrafficLight

  case object Red extends TrafficLight

  case object Green extends TrafficLight

  case object Yellow extends TrafficLight


  /**
    * 4. Calculation
    */

  sealed trait Calculation

  final case class Success(result: Int) extends Calculation

  final case class Failure(reason: String) extends Calculation



}
