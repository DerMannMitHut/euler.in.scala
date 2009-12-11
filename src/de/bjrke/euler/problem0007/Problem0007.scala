package de.bjrke.euler.problem0007

/**
 * result is 104743
 */
object Problem0007 {
  def main(args : Array[String]) : Unit = {
    println(findPrime1(10001,List(2)))
  }  
  
  def findPrime1(number: Long, primes: List[Long]) : Long = {
    if ( primes.size == number ) {
      primes.last
    } else {
      findPrime1(number, newPrime(primes))
    }
  }
  
  def newPrime( previous: List[Long] ) : List[Long] = newPrime( previous, previous.last + 1 )

  def newPrime( previous: List[Long], last: Long ) : List[Long] = {
    if ( isPrime(previous, last) ) {
      previous ::: List(last)
    } else {
      newPrime(previous, last+1)
    }
  }
  
  def isPrime( previous: List[Long], cand: Long ) : Boolean = {
    var isPrime = true;
    previous.forall( a => {
      if ( a * a > cand ) {
        false
      } else {
        isPrime = cand % a != 0
        isPrime
      }
    })
    isPrime
  }

}
