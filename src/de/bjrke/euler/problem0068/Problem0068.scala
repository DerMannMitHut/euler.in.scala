package de.bjrke.euler.problem0068

/**
 * solution: 6531031914842725
 */
object Problem0068 {
  def main(args : Array[String]) : Unit = {
    val nums = (1 to 10).toList.reverse
    nums.foreach( 
      a1 => {
        val numsa1 = nums - a1
        numsa1.foreach { a2 =>
          val numsa2 = numsa1 - a2
          numsa2.foreach { b1 =>
            val numsb1 = numsa2 - b1
            numsb1.foreach { b2 =>
              val numsb2 = numsb1 - b2
              numsb2.foreach { c1 =>
                val numsc1 = numsb2 - c1
                numsc1.foreach { c2 =>
                  val numsc2 = numsc1 - c2
                  numsc2.foreach { d1 =>
                    val numsd1 = numsc2 - d1
                    numsd1.foreach { d2 =>
                      val numsd2 = numsd1 - d2
                      numsd2.foreach{ e1 =>
                        val numse1 = numsd2 - e1
                        numse1.foreach{ e2 =>
                          val t = magic5gon(a1, a2, b1, b2, c1, c2, d1, d2, e1, e2)
                          if (t.test) {
                            t.output
                          }
                          
                        }
                      }
                    }
                  }                  
                }
              }
            }
          }
        }
      }    
    )
  }
  
  case class magic5gon(
    val a1: Int,
    val a2: Int,
    val b1: Int,
    val b2: Int,
    val c1: Int,
    val c2: Int,
    val d1: Int,
    val d2: Int,
    val e1: Int,
    val e2: Int    
  ) {
    val a3 = b2
    val b3 = c2
    val c3 = d2
    val d3 = e2
    val e3 = a2
    
    def testSum = {
      val sum = a1 + a2 + a3
      b1 + b2 + b3 == sum && c1 + c2 + c3 == sum && d1 + d2 + d3 == sum && e1 + e2 + e3 == sum
    }
    
    def testOrder = {
      a1 < b1 && a1 < c1 && a1 < d1 && a1 < e1
    }

    def testStringLen = {
      a2 < 10 && b2 < 10 && c2 < 10 && d2 < 10 && e2 < 10
    }

    def test = testSum && testOrder && testStringLen
    
    def output {
      println( a1 + "" + a2 + "" + a3 + "" + b1 + "" + b2 + "" + b3 + "" + c1 + "" + c2 + "" + c3 + "" + d1 + "" + d2 + "" + d3 + "" + e1 + "" + e2 + "" + e3 )
    }
  }
}
