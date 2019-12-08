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


