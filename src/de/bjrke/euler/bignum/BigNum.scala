package de.bjrke.euler.bignum

object BigNum {
  val ZERO = '0'.toInt

  private def apply( reversed : Array[Int] ) =
    new BigNum {
      override val _reversed = reversed
    }

  def apply( numbers : List[Int] ) =
    new BigNum {
      override val _reversed = numbers.reverse.toArray
    }

  def apply( s : String ) =
    new BigNum {
      override val _reversed = s.reverse.toArray.map( _.toInt - ZERO )
    }

  val BIGZERO = BigNum( "0" )
  val BIGONE = BigNum( "1" )

}

private[bignum] class BigNum() {

  private[bignum] val _reversed : Array[Int] = Array()

  def digit( pos: Int ) : Int = {
    if( _reversed.length <= pos ) {
      0
    } else {
      _reversed.apply(pos)
    }
  }

  def + ( that : BigNum ) : BigNum = {
    val l = Math.max( _reversed.length, that._reversed.length )
    val result = new Array[Int](l)
    var uber = 0
    for ( i <- 0 until l ) {
      val s = digit(i) + that.digit(i) + uber
      uber = s / 10
      result.update(i, s - 10 * uber )      
    }
    if ( uber > 0 ) {
      BigNum( result ++ Array(uber) )
    } else {
      BigNum( result )
    }
  }

  private def shiftLeftTen( pos : Int ) : BigNum = {
    BigNum( Array.make( pos, 0 ) ++ _reversed )
  }

  def intMul( factor : Int ) : BigNum = {
    if ( factor == 0 ) {
      BigNum.BIGZERO
    } else {
      val dup = this + this
      val rest = dup.intMul( factor / 2 )
      if ( factor % 2 == 0 ) {
        rest
      } else {
        this + rest
      }
    }
  }

  def * ( that : BigNum ) : BigNum = {
    var result = BigNum.BIGZERO
    for ( i <- 0 until _reversed.length ) {
      result += that.intMul( digit(i) ).shiftLeftTen( i )
    }
    result
  }

  override def toString  =
    new String( _reversed.map( a => ( BigNum.ZERO + a ).toChar ) ).reverse     

  def toList = _reversed.reverse.toList

}
