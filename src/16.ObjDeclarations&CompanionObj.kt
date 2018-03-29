// In Java we have Singleton class by defining Static variable and methods
// But in Kotlin we don't have Static variable and methods

// In Kotlin, we have "objects" to create Singleton object
// Objects can have:
//                  Initializers
//                  Methods
//                  Properties
//
// Objects can't have Constructors, as we cant create instance /object manually
//
// Companion Objects are same as Objects but declared within a class


fun main(args: Array<String>) {

    // Objects

    CustomerData.count = 98
    println(CustomerData.count)

    CustomerData.typeOfCustomer()
    println(CustomerData.typeOfCustomer())

    CustomerData.myMethod("Hello")

    // Companion Objects

    println(MySuperClass.headCount)

    println(MySuperClass.typeOfCustomers())
}

open class MySuperClass {

    companion object {
        var headCount: Int = 7        // Behaves like static variable

        @JvmStatic
        fun typeOfCustomers(): String {    // Behaves like a static method
            return "Indians"
        }
    }

    open fun myMethod(str: String) {
        println("MySuperClass")
    }
}

object CustomerData : MySuperClass() {    //Can't have constructors

    init {
        // Your code..
    }

    var count: Int = -1                // Behaves like static variable

    fun typeOfCustomer(): String {    // Behaves like a static method
        return "Indian"
    }

    override fun myMethod(str: String) {    // Currently, behaves like a static method
        super.myMethod(str)
        println("Object Customer Data : $str")
    }


}