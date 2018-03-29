// Abstarct Methods have no body when declared
// Abstract Property cannot be initialize when declared
//  Need to override the Abstract methods,properties inside derived classes

fun main(args: Array<String>) {
    var indians = Indians()
    println(indians.name)
    println(indians.eat())
    println(indians.getHeight())
    println(indians.goToSchool())
}

abstract class Persons {         // You cannot create instance of abstract class

    abstract var name: String

    abstract fun eat()          // abstract properties are "open" by default

    open fun getHeight() {      // A "open" function ready to be overridden
        println("Persons : getHeight")
    }

    fun goToSchool() {}          // A normal function : public and final by default
}

class Indians : Persons() {

    override var name: String = "dummy_indian_name"

    override fun eat() {
        //Body
    }

    override fun getHeight() {
        //super.getHeight()
        println("Indians : getHeight")

    }

}