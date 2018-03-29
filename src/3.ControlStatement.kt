// 1. if as expression
// 2. when as expression

fun main(args: Array<String>) {

    // if as an expression

    val a = 2
    val b = 5

    var maxVal: Int = if (a > b) {
        println("a is greater")
        a
    } else {
        println("b is greater")
        b
    }

    println(maxVal)

    val age = 8

    if (age < 6) {
        println(" Go to Preschool")
    } else if (age == 6) {
        println(" Go to Kindergarten")
    } else if ((age > 6) && (age <= 18)) {
        val grade = age - 6
        println("Go to grade : $grade")
    } else {
        println("Go to College")
    }


    // when


    val x = 0
    when (x) {
        0, 1 -> println(" X is 0 ro 1")
        2 -> {
            println("X is 2")
        }
        in 3..6 -> println("X is in between 3 & 6")
        else -> {
            println("X value is unknown")
            println("I don't know what is X")
        }
    }

    // when as an expression

    val y = 100

    val str: String = when (y) {

        1 -> "y is 1"
        2 -> "y is 2"
        else -> {
            "y value is unknown"
        }
    }

    println(str)

}
