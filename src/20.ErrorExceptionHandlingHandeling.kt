/*
two types of Exceptions –

Checked Exception – Exceptions that are typically set on methods and checked at the compile time, for example IOException, FileNotFoundException etc
UnChecked Exception – Exceptions that are generally due to logical errors and checked at the run time, for example NullPointerException, ArrayIndexOutOfBoundException etc

NullPointerException: It is thrown when we try to invoke a property or method on null object.
Arithmetic Exception: It is thrown when invalid arithmetic operations are performed on numbers. eg – divide by zero.
SecurityException: It is thrown to indicate security violation.
ArrayIndexOutOfBoundException: It is thrown when we try to access invalid index value of an array.

Kotlin finally block –
        finally block is always executes irrespective of whether an exception is handled or not by the catch block. So it is used to execute important code statement.
        We can also use finally block with try block and skip the catch block from there.
        
Kotlin throw keyword –        
        we use throw keyword to throw an explicit exception. It can also be used to throw a custom exception.
*/



fun main(args: Array<String>) {

    val divisor = 0

    try {
        if (divisor == 0) {
            throw IllegalArgumentException("Can't divide by zero")
        } else {
            println("5 / $divisor = ${5 / divisor}")
        }
    } catch (e: IllegalArgumentException) {
        println("${e.message}")                     // Can't divide by zero
    }

    // O/P : Can't divide by zero

    
    // finally block –
    try{
        var ar = arrayOf(1,2,3,4,5)
        var int = ar[6]
        println(int)
    }
  finally {
        println("This block always executes")
    }

    // O/P :    This block always executes
    //          Exception in thread “main” java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
    
    try {  
        var int = 10 / 0  
        println(int)  
    } catch (e: ArithmeticException) {  
        println(e)  
    } finally {  
        println("This block always executes")  
    }  
    
    //O/P :     java.lang.ArithmeticException: / by zero
    //          This block always executes
    
    //* throw keyword
    test("abcd")
    println("executes after the validation")
    //O/P : Exception in thread "main" java.lang.ArithmeticException: Password is too short
 
  
    //  multiple catch block

    try {
        val a = IntArray(5)
        a[5] = 10 / 0
    } catch (e: ArithmeticException) {
        println("arithmetic exception catch")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("array index outofbounds exception")
    } catch (e: Exception) {
        println("parent exception class")
    }
    println("code after try catch...")

    /*
    O/P :
    arithmetic exception catch
    code after try catch...
    */
}

 //* throw keyword
    fun test(password: String) {
    // calculate length of the entered password and compare
    if (password.length < 6)
        throw ArithmeticException("Password is too short")
    else
        println("Strong password")
}


