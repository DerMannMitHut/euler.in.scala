package de.bjrke.euler.problem0002

object Problem0002 {
  def main(args : Array[String]) : Unit = {
    println(sum(0, fibtupel(0,1)))
  }

  def sum( current:Int, tupel: fibtupel) : Int = {
    if (tupel.c >= 4000000) {
      current
    } else if (tupel.c % 2 == 0 ) {
      sum( current + tupel.c, tupel.next ) 
    } else {
      sum( current, tupel.next )
    }
  }
  case class fibtupel( val a:Int, val b:Int) {
    val c : Int = a + b    
    def next = fibtupel(b,c)
  }
}
