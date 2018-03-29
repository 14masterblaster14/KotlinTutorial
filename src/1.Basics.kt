fun main(args: Array<String>) {

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE
    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE
    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE
    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE

    println("Biggest Int : $bigInt")
    println("Smallest Int : $smallInt")
    println("Biggest Long : $bigLong")
    println("Smallest Long : $smallLong")
    println("Biggest Double : $bigDouble")
    println("Smallest Double : $smallDouble")
    println("Biggest Float : $bigFloat")
    println("Smallest Float : $smallFloat")


    var char: Char = 'A'
    println(" A is Char :  ${char is Char} ")

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

    println(" 2nd Index : ${str1[2]}")          // r

    println(" Index 2 - 7 : ${str1.subSequence(2, 8)}")          //random

    println("Contains random : ${str1.contains("random")}")     //true
}