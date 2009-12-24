package de.bjrke.euler.problem0025

import de.bjrke.euler.bignum.BigNum

/**
 * result: 4782
 */
object Problem0025 {
  def main(args : Array[String]) : Unit = {
    var flast = BigNum.BIGONE
    var fn = BigNum.BIGONE
    
    var pos = 2

    while ( fn.numOfDigits < 1000 ) {
      pos += 1
      val fneu = fn + flast
      println( pos + ":" + fneu )
      flast = fn
      fn = fneu
    }
  }

}
