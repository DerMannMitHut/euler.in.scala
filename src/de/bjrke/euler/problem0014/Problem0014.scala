package de.bjrke.euler.problem0014

/**
 * result: 837799
 */
object Problem0014 {
  def main(args : Array[String]) : Unit = {
    val max = 1000000
    var m = Map[Long, Long]() + ( 1L -> 1L ) + ( 0L -> 1L )
    
    var resultMap = (2 to max).toList.foldLeft( m ) { calc( _, _ ) }

    val r = resultMap.foldLeft((0L,0L)) { (max, cur) => {
      if (max._2 < cur._2) {
        cur
      } else {
        max
      }
    } }
    println(r)
  }

  def calc( m : Map[Long, Long], v: Long ) : Map[Long, Long] = {
    if ( m.contains(v)) {
      m
    } else {
      val v2 = successor( v )
      val m2 = calc( m, v2 )
      
      m2.get(v2) match {
        case Some(vv) => m2 + ( v -> (vv + 1) )
        case None => throw new IllegalStateException("scheiße hier")
      }
    }
  }
  
  def successor( i: Long ) : Long = {
    if ( i % 2 == 0 ) {
      i / 2
    } else {
      3 * i + 1
    }
  }
}
