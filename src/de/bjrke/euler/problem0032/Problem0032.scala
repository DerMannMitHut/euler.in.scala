/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 
 * 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing 
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 *
 * result 45228
 */
package de.bjrke.euler.problem0032

import de.bjrke.euler.digits.Digits

object Problem0032 {
  def main(args : Array[String]) : Unit = {
    val digits = List(1,2,3,4,5,6,7,8,9)
    val results = permut( digits, 4 ).foldLeft( Set[Int]() ) { (sa, a) => {
        permut( digits -- Digits.toDigits( a ).toList, 4 ).foldLeft(sa) { (sb, b) => {
            if (checkResult(a, b)) {
              println( a + "*" + b + "=" + (a*b))
              sb + ( a * b )
            } else {
              sb
            }
          }
        }
      }
    }
    println( results.foldLeft( 0 ) { _ + _ } )
  }

  def permut( a : List[Int], len : Int ) : Set[Int] = {
    if ( a.isEmpty ) {
      Set()
    } else if ( len == 1 ) {
      Set() ++ a
    } else if ( len > a.size ) {
      permut(a, a.size )
    } else {
      a.foldLeft( Set[Int]() ) { (s,e) => s ++ permut( a - e, len - 1).map( _ * 10 + e ) } ++ permut( a, len - 1 )
    }
  }

  def checkResult( a : Int, b : Int ) : Boolean = {
    val c = a * b
    val list = List() ++ Digits.toDigits( a ) ++ Digits.toDigits( b )++ Digits.toDigits( c )
    val set = Set() ++ list

    set.size == 9 && list.size == 9 && !set.contains( 0 )
  }

}
