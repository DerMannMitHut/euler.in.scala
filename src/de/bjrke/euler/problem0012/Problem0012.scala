package de.bjrke.euler.problem0012

import de.bjrke.euler.problem0179.Problem0179

/**
 * result 76576500
 */
object Problem0012 {
  def main(args : Array[String]) : Unit = {
    var i = 1
    var s = 1
    while ( Problem0179.countDivisors(s) <= 500 ) {
      i += 1
      s += i
      println("testing " + s)
    }
    println("result " + s)
  }
}
