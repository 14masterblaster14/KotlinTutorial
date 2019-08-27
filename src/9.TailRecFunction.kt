import java.math.BigInteger

// TailRec Functions ::
//          - They are also called as recursive functions
//          - Optimize the memory usage
//          - Prevent Stack Overflow Exception
//          - Prefix : "tailrec"
//  Tail recursion is a recursion which performs the calculation first,
//  then makes the recursive call. The result of current step is passed into the next recursive call.
//  Tail recursion follows one rule for implementation. This rule is as follow:
//  The recursive call must be the last call of the method.
//  To declare a recursion as tail recursion we need to use tailrec modifier before the recursive function.

fun main(args: Array<String>) {

    println(getFabonacciNumber(10000, BigInteger("1"), BigInteger("0")))  //o/p : if n=4 --> 3

    println("5! = ${fact(5)}")              // 5! = 120


    // Recursion

    val number = 5
    val result: Long
    result = factorial(number)
    println("Factorial of $number = $result")       // Factorial of 5 = 120

}

tailrec fun getFabonacciNumber(n: Int, a: BigInteger, b: BigInteger): BigInteger {

    if (n == 0)
        return b
    else
        return getFabonacciNumber(n - 1, a + b, a)
}

fun fact(x: Int): Int {

    tailrec fun factTail(y: Int, z: Int): Int {
        if (y == 0) return z
        else return factTail(y - 1, y * z)
    }

    return factTail(x, 1)
}

/// Recursion Function

fun factorial(n: Int): Long {
    return if (n == 1) {
        n.toLong()
    } else {
        n * factorial(n - 1)
    }
}