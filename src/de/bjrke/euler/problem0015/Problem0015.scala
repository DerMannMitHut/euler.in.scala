package de.bjrke.euler.problem0015

/**
 * result: 137846528820
 */
object Problem0015 {
  def main(args : Array[String]) : Unit = {
    val p = Position(20,20)
    println(count( Map() + ( Position(0,0) -> 1L), p ).get( p ))   
  }

  def count( map: Map[Position, Long], pos: Position ) : Map[Position, Long] = {
    if ( map.contains(pos) ) {
      map
    } else if ( pos.x < 0 || pos.y < 0 ) {
      map + ( pos -> 0L )
    } else {
      val newMap = List( pos.down, pos.right ).foldLeft(map) { (m,p) => count(m, p)}
      newMap + ( pos -> ( newMap.get( pos.right ).get + newMap.get( pos.down ).get ) )
    }
  }

  case class Position( val x: Int, val y: Int ) {
    private val min = Math.min(x,y)
    private val max = Math.max(x,y)
    override def hashCode = 31 + min.hashCode + 2 * max.hashCode
    override def equals( a: Any ) = a match {
      case p : Position => p.min == min && p.max == max
      case _ => false
    }
    lazy val down = Position( x, y - 1 )
    lazy val right = Position( x - 1, y )
  }

}
