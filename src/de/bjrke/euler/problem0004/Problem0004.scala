package de.bjrke.euler.problem0004

/**
 * result is: 906609
 */
object Problem0004 {

  def main(args : Array[String]) : Unit = {
    println(findPalindrome1(999,0))    
  }

  def findPalindrome1( a: Int, currentMax: Int ) : Int = {
    if ( a * a < currentMax ) {
      currentMax
    } else {
      val newMax = findPalindrome2( a, a, currentMax )
      findPalindrome1( a -1, newMax)
    }
  }
  
  def findPalindrome2( a: Int, b: Int, currentMax: Int ) : Int = {
    val p = a * b;
    if ( p < currentMax ) {
      currentMax
    } else if ( isPalindrome (p) ) {
      p
    } else {
      findPalindrome2( a, b-1, currentMax)
    }
  }

  def isPalindrome( p: Int ) : Boolean = isPalindrome(p.toString)
  
  def isPalindrome( p: String ) : Boolean = {
    if ( p.length <= 1) {
      true
    } else {
      p.charAt(0) == p.charAt(p.length-1) && isPalindrome(p.substring(1,p.length-1))
    }
  }
}
