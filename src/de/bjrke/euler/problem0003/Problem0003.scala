package de.bjrke.euler.problem0003

import de.bjrke.euler.problem0007.Problem0007

/**
 * result: 6857
 */
object Problem0003 {
  def main(args : Array[String]) : Unit = {
    println(largestPrimeFactor(600851475143L, List( 2 )))    
  }

  def largestPrimeFactor(x : Long, primes : List[Long] ) : Long = {
    val last = primes.last
    if ( x == last ) {
      last
    } else if ( x % last == 0 ) {
      largestPrimeFactor(x/last, primes)
    } else {
      largestPrimeFactor(x, Problem0007.newPrime(primes) )
    }
  }

}
