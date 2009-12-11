package de.bjrke.euler.problem0010

import de.bjrke.euler.problem0007.Problem0007

/**
 * result 142913828922
 */
object Problem0010 {
  def main(args : Array[String]) : Unit = {
    var primes = List(2L)
    var result = 0L
    while ( primes.last < 2000000 ) {
      println( primes.last )
      result += primes.last
      primes = Problem0007.newPrime( primes)
    }
    println(result)
  }
}
