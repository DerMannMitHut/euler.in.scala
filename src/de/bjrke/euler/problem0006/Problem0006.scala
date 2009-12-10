package de.bjrke.euler.problem0006

/**
 * result: 25164150
 */
object Problem0006 {
  def main(args : Array[String]) : Unit = {
    val a = (1 to 100).toList
    val squares = a.foldLeft(0) { (sqsum ,value) => sqsum + value * value }
    val sum = a.foldLeft(0) { _ + _ }
    println( sum * sum - squares )
  }
}
