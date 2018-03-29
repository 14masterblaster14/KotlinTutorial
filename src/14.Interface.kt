fun main(args: Array<String>) {

    var myButton = MyButton()
    myButton.onTouch()
    myButton.onClick()

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
        super.onTouch() // it will call MySecondInterface OnTouch
        println("Button was touched")
    }

    override fun onClick() {        // Optional to override, but if you have two normal methods of same name
        // then you need to override it.
        super<MyInterfaceListener>.onClick()
        super<MySecondInterface>.onClick()
        println("Button was clicked")
    }

}