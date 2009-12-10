package de.bjrke.euler.problem0003

import de.bjrke.euler.problem0007.Problem0007

/**
 * result: 6857
 */
object Problem0003 {
  def main(args : Array[String]) : Unit = {
    println(largestPrimeFactor(600851475143L, List( 3, 2 )))    
  }

  def largestPrimeFactor(x : Long, primes : List[Long] ) : Long = {
    if ( x == primes.head ) {
      primes.head
    } else if ( x % primes.head == 0 ) {
      largestPrimeFactor(x/primes.head, primes)
    } else {
      largestPrimeFactor(x, Problem0007.nextPrime(primes) :: primes )
    }
  }

}
