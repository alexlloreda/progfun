package week3

object classes {
	val x = new Rational(1,3)                 //> x  : week3.Rational = 1/3
	val y = new Rational(5,7)                 //> y  : week3.Rational = 5/7
	val z = new Rational(3,2)                 //> z  : week3.Rational = 3/2
	x + y                                     //> res0: week3.Rational = 22/21
	-x                                        //> res1: week3.Rational = 1/-3
	val result = x - y - z                    //> result  : week3.Rational = -79/42
	val added = x + x                         //> added  : week3.Rational = 2/3
	x < y                                     //> res2: Boolean = true
	x max y                                   //> res3: week3.Rational = 5/7
	
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denomination must be non-zero")
  
  def this(x: Int) = this(x, 1)
  
	private def gcd(a:Int, b:Int): Int = if (b==0) a else gcd(b, a%b)
	private val g = gcd(x, y)
	def numer = x / g
	def denom = y / g
	
	override def toString = numer + "/" + denom
	
	def +(that: Rational): Rational =
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom)
	
	def unary_- : Rational = new Rational(-numer, denom)
	
	def - (that: Rational): Rational = this + -that
	
	def < (that: Rational): Boolean = numer * that.denom < that.numer * denom
	
	def max(that: Rational): Rational = if (this < that) that else this
}
  