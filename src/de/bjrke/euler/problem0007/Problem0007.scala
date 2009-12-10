package de.bjrke.euler.problem0007

object Problem0007 {
  def main(args : Array[String]) : Unit = {
    val a: List[Int] = List( 3, 2)
    println(findPrime(10001,a))
  }  
  
  def findPrime(number: Int, primes: List[Int]) : Int = {
    if ( primes.size == number ) {
      primes.head
    } else {
      findPrime(number, nextPrime(primes) :: primes)
    }
  }
  def nextPrime( previous: List[Int] ) : Int = nextPrime( previous, previous.head )
  def nextPrime( previous: List[Int], lastTested: Int ) : Int = {
    val cand = lastTested + 2
    if ( previous.exists ( cand % _ == 0 ) ) {
      nextPrime( previous, cand )
    } else {
      cand
    }
  }
}
