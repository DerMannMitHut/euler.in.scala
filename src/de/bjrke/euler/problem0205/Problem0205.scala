package de.bjrke.euler.problem0205

/**
 * result 0.5731441
 */
object Problem0205 {
  def main(args : Array[String]) : Unit = {
    val pp = rolldice(9,4)
    val cc = rolldice(6,6)

    var cwins = 0L
    var pwins = 0L
    var draws = 0L

    pp.foreach( p => cc.foreach ( c =>
      {
        val t = p._2 * c._2
        if ( p._1 < c._1 ) {
          cwins += t
        } else if ( p._1 > c._1 ) {
          pwins += t
        } else {
          draws += t
        }
      }
    ) )

    println( "c: " + cwins + " p: " + pwins + " d: " + draws )
    val total : Double = cwins + pwins + draws
    val pdouble : Double = pwins
    println( pdouble / total )
//    println( rolldice(6,6) )
//    println( rolldice(6,6).values.foldLeft(0) { _ + _ } )
    
  }

  def rolldice( cubes: Int, sides: Int) : Map[Int, Int] = {
    if ( cubes == 1 ) {
      (1 to sides).toList.foldLeft(Map[Int,Int]()) { (m,r) => m + ( r -> 1 ) }
    } else {
      val z = rolldice( cubes - 1, sides )
      (1 to sides).foldLeft(Map[Int,Int]()) { (m, r) => addMap( m, bla(z, r) ) }
    }
  }

  def addMap( a : Map[Int, Int], b : Map[Int, Int] ) : Map[Int, Int] = {
    b.foldLeft(a) { (m, e) => {
       m.get(e._1) match {
         case Some(existing) => m + (e._1 -> (e._2 + existing)) 
         case None => m + e
       }               
    } }
  }

  def bla( oldmap : Map[Int, Int], roled : Int ) : Map[Int, Int] = {
    Map() ++ oldmap.map( e => (e._1 + roled, e._2) )
  }
  
}

