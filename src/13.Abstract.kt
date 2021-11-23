// Abstract class and methods will be open by default
// Abstract Methods have no body when declared
// Abstract Property cannot be initialize when declared
// Need to override the Abstract methods,properties inside derived classes
// You cannot create instance of abstract class
// If any property or method is abstract then class needs to define abstract.

fun main(args: Array<String>) {
    var indians = Indians()
    println(indians.name)           //  dummy_indian_name
    println(indians.eat())          //  Indian Eating
    println(indians.getHeight())    //  Indians : getHeight
    println(indians.goToSchool())   //  Go to the School
}

abstract class Persons {         // You cannot create instance of abstract class

    abstract var name: String

    abstract fun eat()          // abstract properties are "open" by default

    open fun getHeight() {      // A "open" function ready to be overridden
        println("Persons : getHeight")
    }

    fun goToSchool() {          // A normal function : public and final by default
        println("Go to the School")
    }
}

class Indians : Persons() {

    override var name: String = "dummy_indian_name"

    override fun eat() {
        //Body
        println("Indian Eating")
    }

    override fun getHeight() {
        //super.getHeight()
        println("Indians : getHeight")

    }
}
