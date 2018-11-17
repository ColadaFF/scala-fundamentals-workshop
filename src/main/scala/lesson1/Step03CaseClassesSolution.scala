package lesson1

object Step03CaseClassesSolution {

  /**
    * 1. Cat case class.
    */
  case class Cat(colour: String, food: String)

  /**
    * 2. Counter case class
    */
  case class Counter(count: Int = 0) {
    def dec: Counter = copy(count = count - 1)

    def inc: Counter = copy(count = count + 1)
  }

  /**
    * 3. ChipShop
    */

  object ChipShop {
    def willServe(cat: Cat): Boolean =
      cat match {
        case Cat(_, "Chips") => true
        case Cat(_, _) => false
      }
  }

}
