fun main(args: Array<String>) {

    var myButton = MyButton()
    myButton.onTouch()
    myButton.onClick()

}

interface MyInterfaceListener {   // You cannot create instance of interface

    var name: String            // properties in interface are abstract by default

    fun onTouch()               // methods in interface are abstract by default

    fun onClick() {              // Normal methods are public and open by default, NOT FINAL

        println("MyInterfaceListener : onClick called")
    }
}

interface MySecondInterface {

    fun onTouch() {
        println("MySecondInterface : onTouch called")
    }

    fun onClick() {
        println("MySecondInterface : onClick called")
    }
}

class MyButton : MyInterfaceListener, MySecondInterface {

    override var name: String = "dummy_name"

    override fun onTouch() {
        super.onTouch()
        println("Button was touched")
    }

    override fun onClick() {        // Optional to override
        super<MyInterfaceListener>.onClick()
        super<MySecondInterface>.onClick()
        println("Button was clicked")
    }
}