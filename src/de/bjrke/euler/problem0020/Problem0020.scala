package de.bjrke.euler.problem0020

import de.bjrke.euler.bignum.BigNum

/**
 * result is 648
 */
object Problem0020 {
  def main(args : Array[String]) : Unit = {
    val result = ( 1 to 100 ).foldLeft( BigNum.BIGONE ) { _.intMul( _ ) }
    println( result.toList.foldLeft( 0 ) { _ + _ } )
  }
}
