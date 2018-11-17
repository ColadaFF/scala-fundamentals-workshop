package lesson4

object Step01Collections extends App {
  /**
    * Sequences
    */

  val sequence = Seq(1, 2, 3)
  // sequence: Seq[Int] = List(1, 2, 3)

  // accessing elements
  sequence.apply(0)
  // res0: Int = 1

  sequence(0) // sugared syntax
  // res1: Int = 1

  sequence.head
  // res2: Int = 1

  // length

  sequence.length
  // res19: Int = 3

  // Searching elements
  sequence.contains(2)
  // res20: Boolean = true

  sequence.find(_ == 3)
  // res21: Option[Int] = Some(3)

  sequence.find(_ > 4)
  // res22: Option[Int] = None

  sequence.filter(_ > 1)
  // res23: Seq[Int] = List(2, 3)

  // Appending / prepending

  sequence.:+(4)
  // res25: Seq[Int] = List(1, 2, 3, 4)

  sequence :+ 4
  // res26: Seq[Int] = List(1, 2, 3, 4)

  sequence.+:(0)
  // res27: Seq[Int] = List(0, 1, 2, 3)

  sequence ++ Seq(4, 5, 6)
  // res29: Seq[Int] = List(1, 2, 3, 4, 5, 6)

  // transformation

  // mapping

  sequence.map(elt => elt * 2)
  // res0: Seq[Int] = List(2, 4, 6)

  // placeholder
  sequence.map(_ * 2)
  // res1: Seq[Int] = List(2, 4, 6)

  "dog".permutations
  // res2: Iterator[String] = non-empty iterator

  "dog".permutations.toList
  // res3: List[String] = List(dog, dgo, odg, ogd, gdo, god)

  Seq("a", "wet", "dog").map(_.permutations.toList)
  // res4: Seq[List[String]] = List(
  //  List(a),
  //  List(wet, wte, ewt, etw, twe, tew),
  //  List(dog, dgo, odg, ogd, gdo, god)
  // )

  // flatMap

  Seq("a", "wet", "dog").flatMap(_.permutations.toList)
  // res5: Seq[String] = List(a, wet, wte, ewt, etw, twe, tew, dog, dgo, odg, ogd, gdo, god)

  Seq(1, 2, 3).flatMap(num => Seq(num, num * 10))
  // res6: Seq[Int] = List(1, 10, 2, 20, 3, 30)

  /**
    * Option:
    * One way of thinking about an Option is as a sequence of 0 or 1 elements
    */

  def readInt(str: String): Option[Int] =
    if(str matches "-?\\d+") Some(str.toInt) else None

  def sum(optionA: Option[Int], optionB: Option[Int]): Option[Int] =
    optionA.flatMap(a => optionB.map(b => a + b))

  sum(readInt("1"), readInt("2"))
  // res2: Option[Int] = Some(3)

  sum(readInt("1"), readInt("b"))
  // res3: Option[Int] = None

  sum(readInt("a"), readInt("2"))
  // res4: Option[Int] = None

  sum(readInt("1"), readInt("b")).getOrElse(0)
  // res5: Int = 0


  /**
    * It’s worth noting that Option and Seq are also compatible in some sense.
    * We can turn a Seq[Option[A]] into a Seq[A] using flatMap:
    */
  Seq(readInt("1"), readInt("b"), readInt("3")).flatMap(x => x)
  // res6: Seq[Int] = List(1, 3)


  /**
    * Maps
    */

  val mapExample = Map("a" -> 1, "b" -> 2, "c" -> 3)

  mapExample("a") // The same as mapExample.apply("a")
  // res1: Int = 1

  mapExample.getOrElse("d", -1)
  // res5: Int = -1

  mapExample.contains("a")
  // res6: Boolean = true

  mapExample.+("c" -> 10, "d" -> 11, "e" -> 12)
  // res8: scala.collection.immutable.Map[String,Int] = Map(e -> 12, a -> 1, b -> 2, c -> 10, d -> 11)


  /**
    * Exercises
    *
    * Using the data bellow, complete the exercises
    */


  val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow")

  /**
    * 1.
    * Write a method favoriteColor that accepts a person’s name
    * as a parameter and returns their favorite colour.
    */

  /**
    * 2.
    * Update favoriteColor to return a person’s favorite
    * color or beige as a default.
    */


}
