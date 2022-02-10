import java.util.*

//  REPL --> Read ,Evaluate, Print, Loop
//  fun Kotlin.main (args : Array<String>)

//    let : 
//	    	To execute an action only when a reference holds a non-nullable value, we can use a let operator. 
//	    	The lambda expression present inside the let is executed only if the variable firstName is not null.

//   also() method chain with let() – 	
//	    	If we want to apply some additional operation like printing the non-nullable items of the list we can use an also() method and chain it with a let() or run().

//   run() method – 
//		It is used to execute some operation on a nullable reference. 
//		It seems to be very similar to let() but inside of a function body, the run() method operates only when we use this reference instead of a function parameter.
	
// Type Checking and Smart Casting :


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
    
    // Ranges:
    //	three ways for creating Range 
	//	Using (..) operator
	//	Using rangeTo() function
	//	Using downTo() function
	
	// step, one can provide step between values. 

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
    
     for (i in 3..10 step 2) 
        print("$i ") 			// 3 5 7 9 
    println()
    // print first value of the range
    println((11..20 step 2).first) 	// 11
    // print last value of the range
    println((11..20 step 4).last)  	// 19
    // print the step used in the range
    println((11..20 step 5).step) 	// 5
    
    // Some predefined function in range –
    val predefined = (15..20)
    println("The minimum value of range is: "+predefined.min())		// The minimum value of range is: 15
    println("The maximum value of range is: "+predefined.max())		// The maximum value of range is: 20
    println("The sum of all values of range is: "+predefined.sum())	// The sum of all values of range is: 105
    println("The average value of range is: "+predefined.average())	// The average value of range is: 17.5

    
    
    // String : 
    		// An array of characters is called a string.
		// Kotlin strings are also immutable in nature means we can not change elements and length of the String. 

    val ch = charArrayOf('H', 'e', 'l', 'l', 'o', 'w')
    val string = String(ch)
    println(string)     // Hello

    println(string.length)      //6
    println(string.lastIndexOf('l', 1, true))   //-1
    println(string.length)      //6


    var str1 = "A random string"
    var str2 = "a random string"
    var str3 = "a random string"

    println(str2 == str3)        // Structural Equality : translated into the call of equals() function // True
    println(str2 === str3)      // Referential Equality //true as both are pointing to the same StringPool

    println(" String Equal : ${str3.equals(str2)}")             // true
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
    
    
    // Null safe 
    
     private var stringName1 : String = "Sachin"
     private var stringName2 : String? = null
	
	//Safe Call operator(?.) –
	println(stringName1?.toUpperCase())	// SACHIN
	println(stringName1?.length)		// 6
	println(stringName2?.toUpperCase())	// null
	
    // We can use the safe call operator with let(), also() and run() if value is not null-
	
		
    var stringlist: List<String?> = listOf("Sachin","is", null, "Batsman")  // created a list contains names
    var newlist = listOf<String?>()		 // created new list
    
    // let : To execute an action only when a reference holds a non-nullable value, we can use a let operator. The lambda expression present inside the let is executed only if the variable firstName is not null.
    for (item in stringlist) {
        item?.let { newlist = newlist.plus(it) } // executes only for non-nullable values	
    }
    for(items in newlist){			 // to print the elements stored in newlist
        print(items)				 // Sachin is Batsman			
    }
    
    // also() method chain with let() – If we want to apply some additional operation like printing the non-nullable items of the list we can use an also() method and chain it with a let() or run().
    for (item in stringlist) {
        item?.let { newlist = newlist.plus(it) }	// executes only for non-nullable values
        item?.also{it -> print(it)}			// Sachin is Batsman	
    }
    
    // run() method – to execute some operation on a nullable reference. It seems to be very similar to let() but inside of a function body, the run() method operates only when we use this reference instead of a function parameter
    for (item in stringlist) {
        // executes only for non-nullable values
        item?.run { newlist = newlist.plus(this) } // this reference
        item?.also{it -> print(it)}		   // Sachin is Batsman	
    }
    
    // Elvis Operator(?:) –
    
     var str : String?  = "MasterBlaster"
    println(str?.length)	// 12
    str = null
    println(str?.length ?: "-1")	// -1
    
    // Not null assertion : !! Operator
    
    var str : String?  = "MasterBlaster"
    println(str!!.length)      // 12	
    str = null
    str!!.length	    // Exception in thread "main" kotlin.KotlinNullPointerException at FirstappKt.main(firstapp.kt:8)
	

	
	// Type Checking : we can check the type of certain variable using the is operator at runtime.
 	
    var name = "Praveen"
    var age = 24
    var salary = 5000.55
    var emp_id = 12345f
    val employeeDetails: List<Any> = listOf(name, age, salary, emp_id)
  
    for (attribute in employeeDetails) {
        when (attribute) {
            is String -> println("Name: $attribute ")
            is Int -> println("Age: $attribute")
            is Double -> println("Salary: $attribute")
            else -> println("Not an attribute")
        }
    }
    
    /*  O/P:-
	Name: Praveen 
	Age: 24
	Salary: 5000.55
	Not an attribute
    */		
	
    // Smart Casting : We use is or !is operator to check the type of variable, and compiler automatically casts the variable to the target type
	
    val str1: String? = "MasterBlaster"
    var str2: String? = null   // prints String is null
    if(str1 is String) {
         
        // No Explicit type Casting needed.
        println("length of String ${str1.length}")	//length of String 12
    }
    else {
        println("String is null")
    }
    
    if(str1 !is String) {
        println("String is null")
    }
    else {
        println("length of String ${str1.length}")	//length of String 12
    }
	
}

// Explicit Cast operator 'as'

  var man = man as Human

  var women : Human? = women as Human?  
  // The above explicit cast is unsafe as it can throw an exception if the cast is not possible. That's why as operator called as unsafe cast operator.
  // So we can use a safe cast operator as? where it assigns a null value if the cast is not possible without throwing an exception.
  var women : Human? = women as? Human	
	
	
	
