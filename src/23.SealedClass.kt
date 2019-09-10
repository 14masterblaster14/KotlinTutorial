/*
*
*   Sealed classes are abstract
*   Sealed Classes can be termed as Enum classes on steroids.
*   Selaed classes are open by default
*
*/


fun main(args: Array<String>) {

    var circle = Shape.Circle(4.5f)
    var square = Shape.Square(4)
    var rectangle = Shape.Rectangle(4, 5)

    eval(circle)        //  Circle area is 63.585
    eval(square)        //  Square area is 16
    eval(rectangle)     //  Rectagle area is 20

    var operation = Add(3, 4)
    var result = execute(operation)
    println("Result : $result")

    val mobile1: Mobile = Mobile("IPhone", MobileColor.GOLD)
    val mobile2: Mobile = Mobile("SONY", MobileColor.BLACK)
    println("The color of my ${mobile1.name} is ${mobile1.color}")

}



sealed class Shape {
    class Circle(var radius: Float) : Shape()
    class Square(var length: Int) : Shape()
    class Rectangle(var length: Int, var breadth: Int) : Shape()
}

fun eval(e: Shape) =
        when (e) {
            is Shape.Circle -> println("Circle area is ${3.14 * e.radius * e.radius}")
            is Shape.Square -> println("Square area is ${e.length * e.length}")
            is Shape.Rectangle -> println("Rectagle area is ${e.length * e.breadth}")
        }

sealed class Post {
    class Status(var text: String) : Post()
    class Image(var url: String, var caption: String) : Post()
    class Video(var url: String, var timeDuration: Int, var encoding: String) : Post()
}

sealed class ArithmaticOperations

class Add(var a: Int, var b: Int) : ArithmaticOperations()
class Subtract(var a: Int, var b: Int) : ArithmaticOperations()
class Multiply(var a: Int, var b: Int) : ArithmaticOperations()
class Divide(var a: Int, var b: Int) : ArithmaticOperations()

fun execute(ops: ArithmaticOperations) = when (ops) {

    is Add -> ops.a + ops.b
    is Subtract -> ops.a - ops.b
    is Multiply -> ops.a * ops.b
    is Divide -> ops.a / ops.b

}

data class Mobile(val name: String, val color: MobileColor)

// Enum Classes

enum class MobileColor(val value: Int) {
    GOLD(0xffd323),
    SILVER(0xeaeaea),
    WHITE(0xffffff),
    BLACK(0x000000),
    RED(0xFF0000)
}