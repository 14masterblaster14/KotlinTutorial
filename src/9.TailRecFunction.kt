import java.math.BigInteger

// They are also called as recursive functions
// Optimize the memory usage
// Prevent Stack Overflow Exception
// Prefix : "tailrec"

fun main(args: Array<String>) {

    println(getFabonacciNumber(10000, BigInteger("1"), BigInteger("0")))
}

tailrec fun getFabonacciNumber(n: Int, a: BigInteger, b: BigInteger): BigInteger {

    if (n == 0)
        return b
    else
        return getFabonacciNumber(n - 1, a + b, a)
}

//o/p : if n=4 --> 3