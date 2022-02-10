// Infix Function ::
//      - It can be member function or extension function
//      - They have a just a single parameter
//      - The parameter must not accept variable number of arguments and must have no default value
//      - They have prefix of "infix"
//      - All infix functions are Extension functions but all extension functions are not Infix.
//      - Infix function provides more readability to the functions similar to other operators like in,is,as in kotlin.

//  Standard library infix function notation : e.g Bitwise operator e.g and , ++ , -- etc
//  User defined infix function notation

fun main(args: Array<String>) {

    val x = 6
    val y = 10
    //val greaterValue = x.greaterValue1(y) //  extension function
    // val greaterValue = 6 greaterValue1 10 // infix function
    val greaterValue = x greaterValue1 y // infix function
    println(greaterValue)               // 10
    
    val m = math()
    // call using infix notation
    val result = m square 3     // infix function
    print("The square of a number is: "+result) // The square of a number is: 9
    
}

// user defined infix member function

infix fun Int.greaterValue1(other: Int): Int {

    if (this > other)
        return this
    else
        return other
}

class math {
    // user defined infix member function
    infix fun square(n : Int): Int{
        val num = n * n
        return num
    }
}
