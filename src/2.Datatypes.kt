class Basics

fun main(args: Array<String>) {

    // Immutable : val
    // Mutable :  var

    // Ranges

    val r1 = 1..5                   // 1,2,3,4,5

    val r2 = 5 downTo 1             // 5,4,3,2,1

    val r3 = 5 downTo 1 step 2      // 5,3,1

    var r4 = 'a'..'z'              // "a","b","c",...."z"

    var isPresent = 'd' in r4

    var countDown = 10.downTo(1)    //10,9,8...1

    var moveUp = 1.rangeTo(10)      // 1,2,3,...10

    println(r1)
    println(r2)
    println(r3)
    println(r4)
    println(isPresent)
    println(countDown)
    println(moveUp)
}
