package de.bjrke.euler.problem0009

/**
 * result 31875000
 */
object Problem0009 {
  def main(args : Array[String]) : Unit = {
    ( 0 to 999 ).toList.foreach( 
      a => ( a+1 to 999 ).foreach ( 
        b => ( b+1 to 999 ).foreach( 
          c => if (test(a,b,c)) { 
            println(a + "*" + b + "*" + c + "=" + a*b*c )
          } )) )    
  }

  def test(a:Int, b:Int, c:Int) : Boolean =
    a * a + b * b == c * c && a < b && b < c && a + b + c == 1000 

}
