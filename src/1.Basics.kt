//  REPL --> Read ,Evaluate, Print, Loop
//  fun Kotlin.main (args : Array<String>)

fun main(args: Array<String>) {

    // Data types ::
    //              Immutable : val
    //              Mutable :  var
    /*
     *        Data Type	    Size
     *        Double	    64
     *        Float	        32
     *        Long	        64
     *        Int	        32
     *        Short	        16
     *        Byte	        8
     *
     */

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE

    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE

    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE

    var bigShort: Short = Short.MAX_VALUE
    var smallShort: Short = Short.MIN_VALUE

    var bigByte: Byte = Byte.MAX_VALUE
    var smallByte: Byte = Byte.MIN_VALUE

    println("Biggest Int : $bigInt")            // 2147483647
    println("Smallest Int : $smallInt")         // -2147483648
    println("Biggest Long : $bigLong")          // 9223372036854775807
    println("Smallest Long : $smallLong")       // -9223372036854775808
    println("Biggest Double : $bigDouble")      // 1.7976931348623157E308
    println("Smallest Double : $smallDouble")   // 4.9E-324
    println("Biggest Float : $bigFloat")        // 3.4028235E38
    println("Smallest Float : $smallFloat")     // 1.4E-45
    println("Biggest Short : $bigShort")        // 32767
    println("Smallest Short : $smallShort")     // -32768
    println("Biggest Byte : $bigByte")          // 127
    println("Smallest Byte : $smallByte")       // -128

    var char: Char = 'A'
    println(" A is Char :  ${char is Char} ")   // true

    if (true is Boolean) {

        println("true is Boolean")                      // true is Boolean
    }

    println("3.14 to Int : ${3.14.toInt()}")            // 3
    println("A to Int : ${'A'.toInt()}")                // 65
    println("65 to Char : ${65.toChar()}")              // A

    var str1 = "A random string"
    var str2 = "a random string"
    println(" String Equal : ${str1.equals(str2)}")             // false

    println("Compare A to B : ${"A".compareTo("B")}")           // -1

    println(" 2nd Index : ${str1[2]}")                          // r

    println(" Index 2 - 7 : ${str1.subSequence(2, 8)}")          //random

    println("Contains random : ${str1.contains("random")}")     //true

    // Ranges

    val r1 = 1..5                   // 1,2,3,4,5

    val r2 = 5 downTo 1             // 5,4,3,2,1

    val r3 = 5 downTo 1 step 2      // 5,3,1

    var r4 = 'a'..'z'              // "a","b","c",...."z"

    var isPresent = 'd' in r4           // true

    var countDown = 10.downTo(1)    //10,9,8...1

    var moveUp = 1.rangeTo(10)      // 1,2,3,...10

    println(r1)         //  1..5
    println(r2)         //  5 downTo 1 step 1
    println(r3)         //  5 downTo 1 step 2
    println(r4)         //  a..z
    println(isPresent)  // true
    println(countDown)  // 10 downTo 1 step 1
    println(moveUp)     // 1..10
}