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

  def apply( i : Int ) : BigNum = BigNum( i.toString )

  val BIGZERO = BigNum( "0" )
  val BIGONE = BigNum( "1" )

}

class BigNum() {

  private[bignum] val _reversed = new Array[Int]( 0 )

  private lazy val _normalized = normalize( checked( _reversed ) )

  private def normalize( a : Array[Int] ) : Array[Int] = {
    val l = a.length
    if ( l == 0 || a.apply( l - 1 ) > 0 ) {
      a
    } else {
      normalize( a.take( l - 1 ) )
    }
  }

  private def checked( a : Array[Int] ) =
    a.filter( v => 
      if ( v < 0 || v > 9 ) { 
        throw new IllegalStateException 
      } else {
        true
      }
    )

  def digit( pos: Int ) : Int = {
    if( _normalized.length <= pos ) {
      0
    } else {
      _normalized.apply(pos)
    }
  }

  def + ( that : BigNum ) : BigNum = {
    val l = Math.max( _normalized.length, that._normalized.length )
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
    BigNum( Array.make( pos, 0 ) ++ _normalized )
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
    for ( i <- 0 until _normalized.length ) {
      result += that.intMul( digit(i) ).shiftLeftTen( i )
    }
    result
  }

  override def toString  =
    new String( _normalized.map( a => ( BigNum.ZERO + a ).toChar ) ).reverse

  def toList = _normalized.reverse.toList

  def numOfDigits = _normalized.length

  override def equals( that : Any ) : Boolean = {
    return that != null && that.isInstanceOf[BigNum] && this._normalized.toList == that.asInstanceOf[BigNum]._normalized.toList
  }

  override def hashCode : Int = {
    247 + _normalized.toList.hashCode
  }

  def pot( y : Int ) : BigNum = 
    if ( y == 0 ) {
      BigNum.BIGONE
    } else if ( y < 0 ) {
      throw new IllegalStateException
    } else {
      val result = ( this * this ).pot( y / 2 )
      if ( y % 2 == 0 ) {
      result
      } else {
      this * result
      }
    }
  

}
