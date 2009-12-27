package de.bjrke.euler.digits

object Digits {

  def toDigits( i : Int ) : Seq[Int] =
    i.toString.map( _.toInt - '0'.toInt )

  def digitLength( i : Int ) : Int =
    i.toString.length
}
