package de.bjrke.euler.problem0048

/**
 * The series, 1¹ + 2² + 3³ + ... + 10¹⁰ = 10405071317.
 *
 * Find the last ten digits of the series, 1¹ + 2² + 3³ + ... + 1000¹⁰⁰⁰.
 *
 * result is 9110846700
 */
object Problem0048 {
  def main(args : Array[String]) : Unit = {
    val result = ( 1 to 1000 ).foldLeft( BigInt( 0 ) ) { ( r, a ) => ( r + hoch( a, a ) ) }
    println( result % tenbillion )
  }

  val tenbillion = BigInt("10000000000");

  def hoch( a : BigInt, b : BigInt ) : BigInt =
    ( b.intValue match {
      case 0 => 1
      case 1 => a
      case n =>
        val r = hoch( a, n / 2 );
        if ( n % 2 == 0 ) { ( r * r ) % tenbillion } else { ( a * r * r ) % tenbillion }
    } )

}
