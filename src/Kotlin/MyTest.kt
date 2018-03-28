@file:JvmName("MyCustomKotlinFileName")

package Kotlin

import Java.MyJava


fun main(args: Array<String>) {

    var area = MyJava.getArea(5, 6)
    println(" Printing Area from kotlin file : " + area)

    var volumeResult = findVolume(2, 3)                  // 2*3*10
    print(volumeResult)                                                  // 60

    var volumeResult1 = findVolume(2, 3, 20)       // 2*3*20
    print(volumeResult1)                                                 // 120


    //Named Parameters < Strictly available in Kotlin but not in Java >
    var volumeResult2 = findVolume(breadth = 3, length = 2)
    print(volumeResult2)                                                  // 2*3*10

    var volumeResult3 = findVolume(height = 20, breadth = 3, length = 2)
    print(volumeResult3)                                                  // 2*3*20

}

fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

// Default Argument Functions < Available in Kotlin but not in Java >

@JvmOverloads  //for interportability
fun findVolume(length: Int, breadth: Int, height: Int = 10): Int {

    return length * breadth * height
}

