/**
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:
 *
 *    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 *
 *    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 *
 * result: 73682
 */
package de.bjrke.euler.problem0031

object Problem0031 {
  def main(args : Array[String]) : Unit = {
    def values = List(200,100,50,20,10,5,2,1)
    println( test( 200, values ) )
  }

  def test( left : Int, values : List[Int] ) : Int = {
    if ( left == 0 || values.size == 1 ) {
      1
    } else {
      ( left to 0 by -values.head ).foldLeft( 0 ) { _ + test( _, values.tail) }
    }
  }
}
