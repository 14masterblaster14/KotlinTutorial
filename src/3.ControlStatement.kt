// 1. if as expression
// 2. when as expression
// 3. Elvis operator

fun main(args: Array<String>) {

    val a = 1000
    val b = 999
    var max1 = if(a > b) a else b
    
    var p = 7
    var q = 2

    if (p < q) println("q is bigger")
    else println("p is bigger")


    if (p == 0)
        println("Zero argument : First")
    else if
                 (q == 0) println("Zero argument : Second")
    else if
                 (p < q) println(" q is bigger")
    else
        println("p is bigger")


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

    println(maxVal)     // O/P :        b is greater
    //              5

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

    // O/P : Go to grade : 2

    // when as a statement : else block is optional


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
    //  O/P : X is 0 ro 1

    // when as an expression : else block is mandatory

    val y = 100

    val str: String = when (y) {

        1 -> "y is 1"
        2 -> "y is 2"
        else -> {
            "y value is unknown"
        }
    }

    println(str)      // y value is unknown


    // Elvis operator

    var name = "MasterBlaster"
    var name1 = ""

    val name_length = name.length
    val name1_length = name1.length
    println(name_length)
    println(name1_length)

}
