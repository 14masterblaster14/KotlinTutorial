import java.util.*

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

    //Type Conversion (Type casting)  
	//Java supports implicit type conversion from smaller to larger data type. An integer value can be assigned to long data type.
	//But, Kotlin does not support implicit type conversion. An integer value can not be assigned to long data type. 
	// Helper function can be used to explicitly convert one data type to another to another data type.
	// toByte(),toShort(),toInt(),toLong(),toFLoat(),toDouble(),toChar()
	// Note: There is No helper function available to convert into boolean type.
    
    println("3.14 to Int : ${3.14.toInt()}")            // 3
    println("A to Int : ${'A'.toInt()}")                // 65
    println("65 to Char : ${65.toChar()}")              // A
    
    // Assignment Operators 
    
+=	a = a + b	
-=	a = a – b	
*=	a = a * b	
/=	a = a / b	
%=	a = a % b	
	
    var a = 10
    var b = 5
    a+=b         
    println(a)  // 15
    a-=b
    println(a)   //10
    a*=b
    println(a)	 //50
    a/=b
    println(a)   //10
    a%=b
    println(a)   //0


    // Unary Operators – 
    	++	++a or a++	
	—	–a or a–
	
    var e=10
    println("First print then increment: "+ e++)  	//First print then increment: 10
    println("First increment then print: "+ ++e)	//First increment then print: 12
    println("First print then decrement: "+ e--)	//First print then decrement: 12
    println("First decrement then print: "+ --e)	//First decrement then print: 10
    
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

    val range = 1.0..5.0
    println("3.14 in range is ${3.14 in range}")   // 3.14 in range is true

    val chars = ('a'..'e')
    val it = chars.iterator()
    while (it.hasNext()) {
        val x = it.next()
        print("$x ")
    }
    // O/P : a b c d e

    for (element in chars.reversed()) {
        print("$element")
    }
    // O/P : e  d  c  b  a

    // String

    val ch = charArrayOf('H', 'e', 'l', 'l', 'o', 'w')
    val string = String(ch)
    println(string)     // Hello

    println(string.length)      //6
    println(string.lastIndexOf('l', 1, true))   //-1
    println(string.length)      //6


    var str1 = "A random string"
    var str2 = "a random string"
    var str3 = "a random string"

    println(str2 == str3)        // Equality // True
    println(str2 === str3)      // Referential Equality //true

    println(" String Equal : ${str1.equals(str2)}")             // false

    println("Compare A to B : ${"A".compareTo("B")}")           // -1
    // 0  -> Two strings are equal
    // -1 -> String is less than other string
    // 1  -> String is greater than other string

    println(" 2nd Index : ${str1[2]}")                          // r

    println(" Index 2 - 7 : ${str1.subSequence(2, 8)}")          //random
    println(" Index 2 - 9 : ${str1.subSequence(2, 10)}")          //random s

    println("Contains random : ${str1.contains("random")}")     //true

    var str = "Chandrayan1 has been launched"
    var updated_str = str.replace("Chandrayan1", "Chandrayan2")
    println(updated_str)        //  Chandrayan2 has been launched
    var updated_str1 = str.replace("CHANDRAYAN1", "CHANDRAYAN-2", true)
    println(updated_str1)        //  CHANDRAYAN-2 has been launched
    var updated_str2 = str.replace("CHANDRAYAN1", "CHANDRAYAN-2", false)
    println(updated_str2)        //  Chandrayan1 has been launched

    println("Substring is \"${str.subSequence(4, 7)}\"")     // Substring is "dra"

    /*  Escaped characters
    \t - Inserts tab
    \b - Inserts backspace
    \n - Inserts newline
    \r - Inserts carriage return ( It is a control character or mechanism used to reset a device's position
                                   to the beginning of a line of text. Here, if anything comes in front of
                                   this character then it will erase it all and write the text after the character)
    \' - Inserts single quote character
    \" - Inserts double quote character
    \\ - Inserts backslash
    \$ - Inserts dollar character
    */
    val escaped_string = "Hello Friend,\n\t As discussed,z\b my name is Sachin.\n\tI am an \"Indian\".\r\t I speaks \'Marathi\',Hindi and English.\\\$."
    print(escaped_string)

    /*OP:
    Hello Friend,
	 As discussed, my name is Sachin.
	 I speaks 'Marathi',Hindi and English.\$.
    */

    val a = 10
    val b = 5
    val myString = """value $a
        |is greater than value $b
        """
    println("${myString}")
    /*
    O/P : value 10
                |is greater than value 5
    */

    val myString1 = """value $a
        |is greater than value $b               // Default margin prefix is pipe character |
        """.trimMargin()
    //or
    println(myString1.trimMargin())

    /*
   O/P : value 10
         is greater than value 5
   */


    /// Inputs

    println("Enter your name:")
    val name = readLine()
    println("Enter your age :")
    val age: Int = Integer.valueOf(readLine())
    println("Your name is $name and your age is $age")  // Your name is sachin and your age is 24

    println("Enter your correct age:")
    var age2 = Scanner(System.`in`).nextInt()
    println("Correct Age : $age2")              // Correct Age : 34
    println("Enter your correct age:")
    var age3 = Scanner(System.`in`).nextFloat()
    println("Correct Age : $age3")          // Correct Age : 34.0
    println("Enter your correct age:")
    var age4 = Scanner(System.`in`).nextDouble()
    println("Correct Age : $age4")          // Correct Age : 34.0
    println("Enter your correct age:")
    var age5 = Scanner(System.`in`).nextLong()
    println("Correct Age : $age5")          // Correct Age : 34

    println("Are you adult")
    var isAdult = Scanner(System.`in`).nextBoolean()
    println("Is Adult: $isAdult")           // Is Adult: true
}
