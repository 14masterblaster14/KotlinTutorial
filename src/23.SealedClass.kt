/*
*
*   Sealed classes are abstract
*   --------------------------------
*   Sealed Classes can be termed as Enum classes on steroids.
*/


fun main(args: Array<String>) {

    var circle = Shape.Circle(4.5f)
    var square = Shape.Square(4)
    var rectangle = Shape.Rectangle(4, 5)

    eval(circle)        //  Circle area is 63.585
    eval(square)        //  Square area is 16
    eval(rectangle)     //  Rectagle area is 20


}

sealed class Festival(var name: String) {

    class Diwali(var month: String) : Festival("diwali") {
        class Bhaiduj : Festival("bhaiduj")
    }

    class Holi(var date: Long) : Festival("holi")

    object Padwa : Festival("padwa") {
        fun display() {
            println("It's a padwa :")
        }
    }

    data class sweets(var sweetName: String, var quantity: Int) : Festival("sweets")
}

class Navaratri : Festival("navratri")


// Practical Usage

sealed class Post {
    class Status(var text: String) : Post()
    class Image(var url: String, var caption: String) : Post()
    class Video(var url: String, var timeDuration: Int, var encoding: String) : Post()
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