@file:JvmName("MyCustomKotlinFileName")

package Kotlin

import Java.MyJava


fun main(args: Array<String>) {

    var area = MyJava.getArea(5, 6)
    println(" Printing Area from kotlin file : " + area)
}

fun addNumbers(a: Int, b: Int): Int {
    return a + b
}