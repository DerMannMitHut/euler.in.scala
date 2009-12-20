package de.bjrke.euler.problem0016

import de.bjrke.euler.problem0013.Problem0013

/**
 * result: 1366
 */
object Problem0016 {
  def main(args : Array[String]) : Unit = {
    val max = 1000
    val result = ( 0 until max ).toList.foldLeft( Problem0013.stringToReversedInts( "1" ) ) {
      ( s, a ) => Problem0013.add( s, s )
    }
    println( result.foldLeft( 0 ) { _ + _ } )
  }
}
