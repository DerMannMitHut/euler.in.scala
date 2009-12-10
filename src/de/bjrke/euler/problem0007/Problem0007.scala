package de.bjrke.euler.problem0007

object Problem0007 {
  def main(args : Array[String]) : Unit = {
    val a: List[Long] = List( 3, 2)
    println(findPrime(10001,a))
  }  
  
  def findPrime(number: Long, primes: List[Long]) : Long = {
    if ( primes.size == number ) {
      primes.head
    } else {
      findPrime(number, nextPrime(primes) :: primes)
    }
  }
  def nextPrime( previous: List[Long] ) : Long = nextPrime( previous, previous.head )
  def nextPrime( previous: List[Long], lastTested: Long ) : Long = {
    val cand = lastTested + 2
    if ( previous.exists ( cand % _ == 0 ) ) {
      nextPrime( previous, cand )
    } else {
      cand
    }
  }
}
