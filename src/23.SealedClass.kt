/*
*   A sealed class defines a set of subclasses within it. 
    It is used when it is known in advance that a type will conform to one of the subclass types.
*
*   Sealed classes are abstract
*   Sealed Classes can be termed as Enum classes on steroids.
*   Sealed classes are open by default

*   Note:   All the subclasses of the sealed class must be defined within the same Kotlin file. 
            However, it not necessary to define them within the sealed class, they can be defined in any scope where the sealed class is visible.
            
// A sealed class with a single subclass defined inside
sealed class ABC {
 class X: ABC(){...}
}

// Another subclass of the sealed class defined
class Y: ABC() {
  class Z: ABC()   // This will cause an error. Sealed class is not visible here
  
}
*/


fun main(args: Array<String>) {
    
    val obj = Demo.B()
    obj.display()       //  Subclass B of sealed class Demo
  
    val obj1 = Demo.A()
    obj1.display()      //  Subclass A of sealed class Demo

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
    
    //Sealed class with when –
    // Objects of different subclasses created
    val obj = Fruit.Apple()
    val obj1 = Fruit.Mango()
    val obj2 = Pomegranate()
  
    // Function called with different objects
    display(obj)        // Apple is good for iron
    display(obj1)       // Mango is delicious
    display(obj2)       // Pomegranate is good for vitamin d    

}

sealed class Demo {
    class A : Demo() {
        fun display()
        {
            println("Subclass A of sealed class Demo")
        }
    }
    class B : Demo() {
        fun display()
        {
            println("Subclass B of sealed class Demo")
        }
    }
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

// Sealed class with when –

// A sealed class with a string property
sealed class Fruit
    (val x: String)
{
    // Two subclasses of sealed class defined within
    class Apple : Fruit("Apple")
    class Mango : Fruit("Mango")
}
  
// A subclass defined outside the sealed class
class Pomegranate: Fruit("Pomegranate")
  
// A function to take in an object of type Fruit
// And to display an appropriate message depending on the type of Fruit
fun display(fruit: Fruit){
    when(fruit)
    {
        is Fruit.Apple -> println("${fruit.x} is good for iron")
        is Fruit.Mango -> println("${fruit.x} is delicious")
        is Pomegranate -> println("${fruit.x} is good for vitamin d")
    }
}


