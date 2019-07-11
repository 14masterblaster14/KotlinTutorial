// Functions

fun main(args: Array<String>) {

    var sum = add(2, 4)
    println("Sum is : $sum")        // Sum is : 6
    display(null)               // Unit is equivalent to Void

    var largeValue = max(4, 6)
    display("The greater number is $largeValue")    // 6 is greater
    //  The greater number is 6
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