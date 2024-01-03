// Covariance
// ----------
// can be marked covariant!
trait Producer[A] {
  def produce(): A
}
object buyableProducer extends Producer[Buyable] {
  def produce() =
    if (math.random() > 0.5) seAtGoogle else mateDrink
}
object bookProducer extends Producer[Book] {
  def produce() =
    if (math.random() > 0.5) seAtGoogle else introductionToStaticAnalysis
}


def consumeBuyables(b: Producer[Buyable]) = {
  println(s"Got a product with price: ${b.produce().price} ct")
  println(s"Got a product with price: ${b.produce().price} ct")
  println(s"Got a product with price: ${b.produce().price} ct")
}


def mainCovariance = {
  consumeBuyables(buyableProducer)
  // consumeBuyables(bookProducer) // requires covariance.
}



// Contravariance
// --------------

// can be marked contravariant!
trait Consumer[A] {
  def consume(a: A): Unit
}

object ISBNPrinter extends Consumer[Book] {
  def consume(b: Book): Unit =
    println(s"ISBN is: ${b.isbn}")
}

object pricePrinter extends Consumer[Buyable] {
  def consume(b: Buyable): Unit =
    println(s"The price of this item is: ${ b.price / 100.0 } EUR")
}

def feedBuyables(b: Consumer[Buyable]) = {
  b.consume(mateDrink)   // buyable
  b.consume(seAtGoogle)  // book <: buyable
}

def feedBooks(b: Consumer[Book]) = {
  b.consume(seAtGoogle)
  b.consume(introductionToStaticAnalysis)
}

def mainContravariance = {
  feedBuyables(pricePrinter)
  feedBooks(ISBNPrinter)

  // requires Consumer to be contravariant:
  // consumeAllBooks(pricePrinter)
}

// remark: we can (of course) even store the different consumers into a list and then have subtyping on the whole list.


