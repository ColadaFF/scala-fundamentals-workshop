package lesson1

object Step01ClassesSolution extends App {

  /**
    * - Receives and Int in the constructor
    * - has methods inc and dec
    */

  class Counter(val count: Int) {
    def dec: Counter = new Counter(count - 1)

    def inc: Counter = new Counter(count + 1)

    //faster
    def decFaster(amount: Int = 1): Counter = new Counter(count - amount)

    def incFaster(amount: Int = 1): Counter = new Counter(count + amount)
  }

  new Counter(10).decFaster() // -> Valid
  new Counter(10).decFaster(10) //-> Valid
  // new Counter(10).decFaster // -> Invalid

  class CounterApplier(val count: Int) {
    def dec: CounterApplier = dec()

    def inc: CounterApplier = inc()

    def dec(amount: Int = 1): CounterApplier = new CounterApplier(count - amount)

    def inc(amount: Int = 1): CounterApplier = new CounterApplier(count + amount)
  }

  new CounterApplier(10).inc.inc(10).count // valid

  /**
    * Bonus !
    */

  class Adder(amount: Int) {
    def add(in: Int): Int = in + amount
  }


  class CounterWithAdder(val count: Int) {
    def dec = new Counter(count - 1)

    def inc = new Counter(count + 1)

    def adjust(adder: Adder) =
      new Counter(adder.add(count))
  }


}
