// Interfaces are  open by default
// You cannot create instance of interface
// properties in interface are abstract by default
// methods in interface are Abstract by default
// Normal methods are public and open by default, NOT FINAL.


fun main(args: Array<String>) {

    var myButton = MyButton()
    myButton.onTouch()      //  MySecondInterface : onTouch called
    //  Button was touched
    myButton.onClick()      //  MyInterfaceListener : onClick called
    //  MySecondInterface : onClick called
    //  Button was clicked
    myButton.onSelect()     //  onSelect selected

    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)         //  Tweety flies 10.0 miles
}

interface MyInterfaceListener {     // You cannot create instance of interface

    var name: String                // properties in interface are abstract by default
    // i.e. it can't be initialized

    fun onTouch()                   // methods in interface are Abstract by default
    // i.e It can't have body. It has to implement .

    fun onClick() {                 // Normal methods are public and open by default, NOT FINAL.
        // It has body and We may/may not implement it
        println("MyInterfaceListener : onClick called")
    }

    fun onSelect()
}

interface MySecondInterface {

    fun onTouch() {                  // Normal methods
        println("MySecondInterface : onTouch called")
    }

    fun onClick() {                  // Normal methods
        println("MySecondInterface : onClick called")
    }
}

class MyButton : MyInterfaceListener, MySecondInterface {

    override var name: String = "dummy_name"

    override fun onTouch() {
        super.onTouch()     // it will call MySecondInterface OnTouch
        println("Button was touched")
    }

    override fun onClick() {        // Optional to override, but if you have two normal methods of same name
        // then you need to override it.
        super<MyInterfaceListener>.onClick()
        super<MySecondInterface>.onClick()
        println("Button was clicked")
    }

    override fun onSelect() {
        println("onSelect selected")
    }
}

interface Flyable {
    val flies: Boolean
    fun fly(distMile: Double): Unit
}

class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable {
    override fun fly(distMile: Double): Unit {
        if (flies) {
            println("$name flies $distMile miles")
        }
    }
}
