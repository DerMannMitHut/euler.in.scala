package de.bjrke.euler.prime

object Prime {

  def isPrime( p : Long ) : Boolean = {
    if ( p < 0 ) {
      throw new IllegalStateException
    } else if ( p == 0L || p == 1L || p % 2L == 0 ) {
      false
    } else {
      var d : Long = 3L
      while ( d * d <= p && p % d != 0 ) {
        d += 2
      }
      d * d > p
    }
  }

}
