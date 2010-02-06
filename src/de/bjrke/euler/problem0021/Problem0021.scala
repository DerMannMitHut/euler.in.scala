package de.bjrke.euler.problem0021

/**
 * result = 31626
 */
object Problem0021 {
  def sumOfProperDivisors( i : Int ) = (1 until i).filter(i%_==0).foldLeft(0)(_+_)
  def isAmicable( a : Int ) : Boolean = {
    val b = sumOfProperDivisors(a)
    if( b == a ) return false
    return a == sumOfProperDivisors(b)
  }
  def main(args : Array[String]) : Unit = {
    val e = (1 until 10000).filter(isAmicable)
    println( e.reduceLeft(_+_) )
  }
}
