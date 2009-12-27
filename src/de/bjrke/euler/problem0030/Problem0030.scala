/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 *    1634 = 1⁴ + 6⁴ + 3⁴ + 4⁴
 *    8208 = 8⁴ + 2⁴ + 0⁴ + 8⁴
 *    9474 = 9⁴ + 4⁴ + 7⁴ + 4⁴
 *
 * As 1 = 1⁴ is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * result is: 443839
 */
package de.bjrke.euler.problem0030

import de.bjrke.euler.digits.Digits

object Problem0030 {
  def main(args : Array[String]) : Unit = {
    val result = ( 10 to 1000000 ).foldLeft( 0 ) { (s,i) =>
      if ( i == calc(i) ) {
        println(i)
        s + i
      } else {
        s
      }
    }
    println( result )
  }

  def calc( i : Int ) : Int =
    Digits.toDigits( i ).foldLeft( 0 ) { (s,a) => s + pow( a, 5 ) }

  def pow( i : Int, j : Int ) : Int = {
    if ( j == 0 ) {
      1
    } else {
      val result = pow( i * i, j / 2 )
      if ( j % 2 == 0 ) {
        result
      } else {
        i * result
      }
    }
  }

}
