// Operartor Overloading
/*

   -  Operator overloading defines how operator works for user defined types like objects. 
   -  We can overload the standard operators.
   -  All of the unary, binary, relational operators can be overloaded.
   -  When we use operator in Kotlin, it's corresponding member function is called

Eligible Operators =>	
	
Unary Operators –	
					Operator expression		Corresponding function
					+x						x.unaryPlus()
					-x						x.unaryMinus()
					!x						x.not()
					
Increment and Decrement Operators –
					Operator expression		Corresponding function
					++x						x.inc()
					– – x					x.dec()	
					
Binary Operators –	
					Operator expression		Corresponding function		
					x1 + x2					x1.plus(x2)
					x1 – x2					x1.minus(x2)
					x1 * x2					x1.times(x2)
					x1/ x2					x1.div(x2)
					x1 % x2					x1.rem(x2)
					x1..x2					x1.rangeTo(x2)	
					
Other operators –		
					Operator expression		Corresponding function
					x1 in x2				x2.contains(x1)
					x1 !in x2				!x2.contains(x1)
					x[i]					x.get(i)
					x[i, j]					x.get(i, j)
					x[i] = b				x.set(i, b)
					x[i, j] = b				x.set(i, j, b)
					x()						x.invoke()
					x(i)					x.invoke(i)
					x(i, j)					x.invoke(i, j)
					x1 += x2				x1.plusAssign(x2)
					x1 -= x2				x1.minusAssign(x2)
					x1 *= x2				x1.timesAssign(x2)
					x1 /= x2				x1.divAssign(x2)
					x1 %= x2				x1.remAssign(x2)

/*


e.g. 
	val a = 10
	val b = 5
	println(a+b)	// print (a.plus(b))		// O/p : 15
	
e.g.

		class Point(val x: Int = 0, val y: Int = 10) {

		// overloading + function
		operator fun plus(p: Point) : Point {
			return Point(x + p.x, y + p.y)
		}
		
		// overloading -- function
		 operator fun dec() = Point(--x, --y)
		 
	}
		 
		 
	fun main(args: Array<String>) {
    val p1 = Point(3, -8)
    val p2 = Point(2, 9)

    var sum = Point()
    sum = p1 + p2		//	it is transformed to p1.plus(p2) under the hood.

    println("sum = (${sum.x}, ${sum.y})")		//	O/p :	sum = (5, 1)
	
	var point3 = Point(3, -8)
    --point
	println("point = (${point.x}, ${point.y})")	//	O/P :	point = (2, -9)
	
	// overloading *(times) function
	operator infix fun Point.times(p:Point) : Point {
			return Point(x*p.x, y*p.y)
	}
	
	var point4 = Point()
	point4 = p1 * p2	//	it is transformed to p1.times(p2) under the hood.
	println("Multiply = (${point4.x}, ${point4.y})")		//	O/p :	Multiply = (6, -72)
}	 
		


