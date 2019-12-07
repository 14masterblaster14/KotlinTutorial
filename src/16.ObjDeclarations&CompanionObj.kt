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

    customerDB.write_customerDB("Name", "Sachin")    //  Accessing Customer DB
    //  Writing Customer DB
    println(customerDB.read_customerDB_value("Name"))   //  Reading Customer DB
    //  Sachin

    CustomerData.count = 98
    println(CustomerData.count)     // 98

    CustomerData.typeOfCustomer()
    println(CustomerData.typeOfCustomer())  //  Indian

    CustomerData.myMethod("Hello")       //  MySuperClass , Hello
    //  Object Customer Data : Hello

    // Companion Objects
    println(MySuperClass.headCount)     //  7

    println(MySuperClass.typeOfCustomers()) //  Indians

    //Companion Object extension
    MySuperClass.helloWorld()   //extension function declared upon the companion object
    //  executing extension of companion object
}


// Simple Object

object customerDB {

    var db: HashMap<String, String> = HashMap()

    init {
        println("Accessing Customer DB")

        var db = hashMapOf<String, Int>()

    }

    fun write_customerDB(key: String, value: String) {
        println("Writing Customer DB")
        db.put(key, value)
    }

    fun read_customerDB_value(key: String): String? {
        println("Reading Customer DB")
        return db[key]
    }
}

// Companoin Object

open class MySuperClass {

    companion object {
        var headCount: Int = 7        // Behaves like static variable

        @JvmStatic
        fun typeOfCustomers(): String {    // Behaves like a static method
            return "Indians"
        }
    }

    open fun myMethod(str: String) {
        println("MySuperClass , $str")
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

// Companion object extensions

fun MySuperClass.Companion.helloWorld() {
    println("executing extension of companion object")
}

