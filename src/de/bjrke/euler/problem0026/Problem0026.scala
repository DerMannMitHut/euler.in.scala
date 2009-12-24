package de.bjrke.euler.problem0026

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2 = 0.5
 * 1/3 = 0.(3)
 * 1/4 = 0.25
 * 1/5 = 0.2
 * 1/6 = 0.1(6)
 * 1/7 = 0.(142857)
 * 1/8 = 0.125
 * 1/9 = 0.(1)
 * 1/10	= 0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 *
 * result: 983 with 982 digits cycle
 */
object Problem0026 {
  def main(args : Array[String]) : Unit = {
    val result = ( 1 to 1000 ).foldLeft( (0, 0) ) { (max, cur) => {
      val m = fillmap( 1, cur, Map(), false )
      if ( m.size > max._2 ) {
        ( cur, m.size )
      } else {
        max
      }
    } }
    println( result )
  }

  def fillmap( currentDividend: Int, divisor: Int,
               previous : Map[Int, DivResult], 
               second : Boolean ) : Map[Int, DivResult] =
  {
    previous.get( currentDividend ) match {
      case Some( result ) => {
        if ( second ) {
          previous
        } else {
          fillmap( currentDividend, divisor, Map(), true )
        }
      }
      case None => {
        val result = DivResult( currentDividend / divisor, currentDividend % divisor )
        fillmap( result.rest * 10, divisor, previous + ( currentDividend -> result ), second )
      }
    }
  }

  case class DivResult( val quotient : Int, val rest : Int )

}
