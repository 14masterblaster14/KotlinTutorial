// TailRec Functions ::
//          - They are also called as recursive functions
//          - Optimize the memory usage
//          - Prevent Stack Overflow Exception
//          - Prefix : "tailrec"

fun main(args: Array<String>) {

    println(getFabonacciNumber(10000, BigInteger("1"), BigInteger("0")))  //o/p : if n=4 --> 3

    println("5! = ${fact(5)}")              // 5! = 120
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

