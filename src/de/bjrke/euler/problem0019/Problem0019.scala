package de.bjrke.euler.problem0019

/**
 * result: 171
 */
object Problem0019 {
  
  type Date = (Int,Int,Int) // year, month, day
  
  def main(args : Array[String]) : Unit = {
    val e = for( month <- 1 to 12; year <- 1901 to 2000 ) yield dow( year, month, 1 )
    println( e.filter(_==0).length )
  }
  
  // calculate the day of week; see http://de.wikipedia.org/wiki/Wochentagsberechnung
  // result: 0: sunday, 1: monday, ..., 6: saturday
  def dow( date : Date ) = {
	val day = date._3
	val month = Array(0,3,3,6,1,4,6,2,5,0,3,5)(date._2-1)
	val year = (3-(date._1/100)%4)*2 + (date._1%100 + (date._1%100)/4)
	val isLeapYear = ((date._1%4==0) && (date._1%100>0)) || (date._1%400==0)
	val leapYearCorrection = if(date._2<3 && isLeapYear) 6 else 0
    (day + month + year + leapYearCorrection)%7
  }
}
