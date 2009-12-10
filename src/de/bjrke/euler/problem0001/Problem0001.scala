package de.bjrke.euler.problem0001;

/**
 * result: 233168
 */
object Problem0001 {
  def main(args : Array[String]) : Unit = {
    val result = (0 to 999).toList.filter( isMultipleOf3Or5(_)).foldLeft(0) { _ + _ }
    println(result)
  }
  
  private def isMultipleOf3Or5( a: Int ) : Boolean = {
    isMultipleOf(a,3) || isMultipleOf(a,5)
  }

  private def isMultipleOf( a: Int, b: Int) : Boolean = {
    a % b == 0
  }
  
}
