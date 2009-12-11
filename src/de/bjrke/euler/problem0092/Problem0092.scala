package de.bjrke.euler.problem0092

/**
 * result 8581146
 */
object Problem0092 {
  def main(args : Array[String]) : Unit = {
    val max = 10000000
    var m = Map[Int, Int]() + ( 1 -> 1 ) + ( 0 -> 0 ) + ( 89 -> 89 )
    
    var resultMap = (0 to max).toList.foldLeft( m ) { calc( _, _ ) }

    
    println(resultMap.values.foldLeft(0) { (s,v) => 
      if ( v == 89 ) { 
        s + 1 
      } else { 
        s 
      } })
  }

  def calc( m : Map[Int, Int], v: Int ) : Map[Int, Int] = {
    println(v)
    if ( m.contains(v)) {
      m
    } else {
      val v2 = sqsum(v)
      val m2 = calc( m, v2 )
      m2.get(v2) match {
        case Some(vv) => m2 + ( v -> vv )
        case None => throw new IllegalStateException("scheiße hier")
      }
    }
  }
  
  def sqsum( a: Int ) :Int = {
    a.toString.toList.map( _.toInt - '0'.toInt ).map( a => a * a ).foldLeft(0) { _ + _ }
  }
}
