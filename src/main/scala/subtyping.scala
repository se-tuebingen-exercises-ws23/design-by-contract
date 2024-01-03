trait Item { def productNo: String }
trait Buyable extends Item { def price: Int }
trait Book extends Buyable { def isbn: String }


val myMonitor: Item = new Item {
  def productNo: String = "123456789"
}

object mateDrink extends Buyable {
  def productNo = "5955530"
  def price = 110
}

object seAtGoogle extends Book {
  def productNo = "55999"
  def isbn = "9781492082798"
  def price = 5095
}

object introductionToStaticAnalysis extends Book {
  def productNo = "56500"
  def isbn = "9780262043410"
  def price = 6500
}

trait VAT { def addTax(b: Buyable): Buyable }

def demoSubtyping(vat: VAT) = {
  // vat.addTax(mateDrink)

  val taxedMate = vat.addTax(mateDrink)
  val taxedBook = vat.addTax(seAtGoogle)

  println(taxedBook.price)
  // println(taxedBook.isbn)
}

// class Monitor(no: String) extends Item {
//   def productNo: String = no
// }
// val myMonitor = new Monitor("123456789")


