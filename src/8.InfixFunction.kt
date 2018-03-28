// It can be member function or extension function
// They have a just a single parameter
// They have prefix of "infix"
// All infix functions are Extension functions but all extension functions are not Infix.

fun main(args: Array<String>) {

    val x = 6
    val y = 10
    //val greaterValue = x.greaterValue1(y) //  extension function
    val greaterValue = x greaterValue1 y // infix function
    println(greaterValue)
}

infix fun Int.greaterValue1(other: Int): Int {

    if (this > other)
        return this
    else
        return other
}