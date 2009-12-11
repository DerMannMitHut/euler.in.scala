package de.bjrke.euler.problem0179

/**
 * 986262
 */
object Problem0179 {
  def main(args : Array[String]) : Unit = {
    val max = 10000000
    val a = new Array[Int](max+1)
    var result = 0
    for (v <- 1 to max) {
      for(p <- v until max by v) {
        a.update(p, a.apply(p) + 1)
      }
      if ( a.apply(v-1) == a.apply(v) ) {
        result=result + 1
      }
    }
    println(result)
  }

  def solution1() {
    var last = -1
    val result = (1 to 10000000).toList.foldLeft(0)( (s,a) => {
      val cur = countDivisors(a)
      if ( last == cur) {
        println("match" + a)
        s + 1
      } else {
        println("nomatch" + a)
        last = cur
        s
      }
    }) 
    println(result)
  }

  def countDivisors( a: Int ) : Int = {
    val wz = Math.sqrt(a)
    val result = (2 to wz).toList.foldLeft(2) { (s, d) => {
  	  if ( a % d == 0 ) {
  	    s + 2
  	  } else {
  	    s
	  }
  	}}
    if ( wz * wz == a ) {
      result - 1
    } else {
      result
    }
  }
}

