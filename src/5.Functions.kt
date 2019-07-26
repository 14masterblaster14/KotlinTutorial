// Functions

fun main(args: Array<String>) {

    var sum = add(2, 4)
    println("Sum is : $sum")        // Sum is : 6
    display(null)               // Unit is equivalent to Void

    var largeValue = max(4, 6)
    display("The greater number is $largeValue")    // 6 is greater
    //  The greater number is 6

    println("Sum = ${getSum(1, 2, 3, 4, 5, 6, 7)}")   // Sum = 28

    println("Average = ${getFloatAverage(4.0F, 1F, 2F, 3F, 4F, 5F, 6F, 7F)}")  // Average = 4.0

    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    println("Average = ${getSum(4, *nums, 7)}")   // Equals to getSum(4,1,2,3,4,5,6,7,7)
    // Average = 39
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun display(msg: String?): Unit {
    if (msg == null) {
        println("Unit is equivalent to Void")
    } else {
        println(msg)
    }
}


// Functions as Expressions

fun max(a: Int, b: Int): Int = if (a > b) {
    println("$a is greater")
    a
} else {
    println("$b is greater")
    b
}


// varArg : The vararg parameters must be the last parameter in the parameter list

//          Arrays can be passed into vararg functions using the Spread Operator, *
//          The spread operator can also be used in the middle of the parameters which will be part of last vararg.

fun getSum(vararg numbers: Int): Int {
    var sum = 0
    numbers.forEach { n -> sum += n }
    return sum
}

fun getFloatAverage(param: Float, vararg numList: Float): Float {
    var sum = param
    numList.forEach { n -> sum += n }
    return (sum / (numList.size + 1))
}



