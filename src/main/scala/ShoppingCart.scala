object ShoppingCart {

  case class Product(price: Double)
  object Apple extends Product(0.60)
  object Orange extends Product(0.25)

  def checkOutTotal(items: List[Product]) : Double = {
    items.map(_.price).sum
  }

  def testCheckOut() {
    val items = List(Apple, Apple, Orange, Apple)
    println(s"Total: ${checkOutTotal(items)}")
  }

  def main(args: Array[String]): Unit = {
    testCheckOut()
  }

}