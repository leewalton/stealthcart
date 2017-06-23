object ShoppingCart {

  case class Product(price: Double)
  object Apple extends Product(0.60)
  object Orange extends Product(0.25)

  def checkOutTotal(items: List[Product]) : Double = {
    val total = items.map(_.price).sum
    val discount = calculateDiscount(items)
    total - discount
  }

  def calculateDiscount(items: List[Product]) : Double = {

    val apples = items.count( _ == Apple )
    val appleDiscount = (apples / 2) * Apple.price

    val oranges = items.count( _ == Orange )
    val orangeDiscount = (oranges / 3) * Orange.price

    appleDiscount + orangeDiscount

  }

  def testCheckOut() {
    val items = List(Apple, Apple, Orange, Apple, Orange, Apple, Orange, Apple)
    println(s"Total: ${checkOutTotal(items)}")
  }

  def main(args: Array[String]): Unit = {
    testCheckOut()
  }

}