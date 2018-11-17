package lesson4

object Step01CollectionsSolution extends App {

  val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow")

  /**
    * 1
    */

  def favoriteColor(person: String): Option[String] =
    favoriteColors.get(person)

  /**
    * 2. default color
    */

  def favoriteColorDefault(person: String): String =
    favoriteColors.get(person).getOrElse("beige")

  def favoriteColorDefaultShort(person: String): String =
    favoriteColors.getOrElse(person, "beige")

}