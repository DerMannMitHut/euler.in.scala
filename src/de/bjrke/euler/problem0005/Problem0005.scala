package de.bjrke.euler.problem0005

/**
 * result: 232792560
 */
object Problem0005 {
  def main(args : Array[String]) : Unit = {
    println(kgV((1 to 20).toList))
  }
  
  def kgV(a : List[Int]) : Int = {
    if ( a.size == 1) {
      a.head
    } else {
      a.head * kgV(a.tail.map{ e => 
        if (e % a.head == 0) { 
          e / a.head
        } else {
          e
        }
      })
    }
  }
}
