// Functions

// standard library functions
/*
    sqrt() – Used to calculate the square root of a number.
    print() – Used to print a message to standard output.
    rem() – To find the remainder of one number when divided by another.
    toInt() – To convert a number to integer value.
    readline() – Used for standard input.
    compareTo() – To compare two numbers and return boolean value.
*/

// VarArgs

fun main(args: Array<String>) {

    var sum = add(2, 4)
    println("Sum is : $sum")        // Sum is : 6
    display(null)               // Unit is equivalent to Void


    run(3, 'a')     // parameter in function definition 3 and a
    run(3)              // parameter in function definition 3 and x
    //run('b')              // Error: Kotlin: The character literal does not conform to the expected type Int
    run(latter = 'b')         // parameter in function definition 5 and b


    var largeValue = max(4, 6)
    display("The greater number is $largeValue")    // 6 is greater
    //  The greater number is 6

    // VarArgs
    
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

// Default Argument

fun run(num: Int = 5, latter: Char = 'x') {
    print("parameter in function definition $num and $latter")
}

// Functions as Expressions

fun max(a: Int, b: Int): Int = if (a > b) {
    println("$a is greater")
    a
} else {
    println("$b is greater")
    b
}


// varArg : 
//            Sometimes we need a function where we can pass n number of parameters, and the value of n can be decided at runtime. 
//            We can do it by defining a parameter of a function as vararg

//          The vararg parameters must be the last parameter in the parameter list

//          Arrays can be passed into vararg functions using the Spread Operator, *
//          The spread operator can also be used in the middle of the parameters which will be part of last vararg.

fun getSum(vararg numbers: Int): Int {      // fun getSum(numbersList: List): Int
    var sum = 0
    numbers.forEach { n -> sum += n }
    return sum
}

fun getFloatAverage(param: Float, vararg numList: Float): Float {
    var sum = param
    numList.forEach { n -> sum += n }
    return (sum / (numList.size + 1))
}



