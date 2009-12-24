/**
 * Euler published the remarkable quadratic formula:
 *
 * n² + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive 
 * values n = 0 to 39. However, when n = 40, 40² + 40 + 41 = 40(40 + 1) + 41
 * is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly 
 * divisible by 41.
 *
 * Using computers, the incredible formula  n² − 79n + 1601 was discovered, 
 * which produces 80 primes for the consecutive values n = 0 to 79. The product
 * of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 *
 * result: -59231 with 71 primes
 */

package de.bjrke.euler.problem0027

import de.bjrke.euler.prime.Prime

object Problem0027 {
  def main(args : Array[String]) : Unit = {
    val m = 999
    val range = ( -m until m )
    val result = range.foldLeft( ( 0, 0L ) ) { ( r, a ) => {
        range.foldLeft( r ) { ( max, b ) => {
            var c = countPrimes( a, b )
            if ( max._2 < c ) {
              ( a * b , c )
            } else {
              max
            }
          }
        }
      }
    }
    
    println( result )
  }

  def countPrimes( a : Long, b : Long ) : Long = {
    var n = 0L
    while ( Prime.isPrime( Math.abs( calc( a, b, n ) ) ) ) {
      n += 1
    }
    n
  }

  def calc( a : Long, b : Long, n : Long ) : Long = n * n + a * n + b

}
