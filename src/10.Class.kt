// Class ::

// Primary Constructors:
//      init Block
//      Primary Constructor with Property (field variables)
//      Primary Constructor with just Parameters

fun main(args: Array<String>) {

    var employee = Employee("Master")
    println("Employee : ${employee.name}")

    var employee1 = Employee1("Blaster")
    println("Employee1 : ${employee1.name1} ")


    var employee2 = Employee2("MasterBlaster", 7)
    println("Employee2 Id : ${employee2.id}")


    val bowser = Animals("Bowser", 20.0, 13.5)
    bowser.getInfo()

    val doggy = Dogs("Spot", 20.0, 14.5, "Master_Blaster")

    println(OuterNested.InnerNested().innerName)
    println(OuterNested.InnerNested().getInnerName())

    println(OuterClass().InnerClass().innerName)
    println(OuterClass().InnerClass().getInnerName())


}

// Primary Constructors

class Employee(_name: String) {
    var name: String = "Dummy                   "

    init {
        this.name = _name
        println("Employee name is $name")
    }
}

class Employee1(var name1: String)

// Secondary Constructors

class Employee2(var name2: String) {

    var id = 0

    //Primary Constructor
    init {
        println("Employee2 has Name as $name2 and Id as $id")
    }

    //Secondary Constructor
    constructor(name22: String, _id: Int) : this(name22) {
        // Body of the secondary constructor is called after the init block
        this.id = _id
    }
}

open class Animals(val name: String, var height: Double, var weight: Double) {

    init {
        val regex = Regex(".*\\d+.*")

        require(!name.matches(regex)) { "Animal name can't contain Null" }
        require(height > 0) { "Height must be greater than zero" }
        require(weight > 0) { "Weight must be greater than zero" }
    }

    open fun getInfo(): Unit {
        println("$name is $height tall and weighs $weight")
    }
}

class Dogs(name: String, height: Double, weight: Double, var owner: String) : Animals(name, height, weight) {
    /* OR
        class Dogs : Animals {
            constructor(name: String, height: Double, weight: Double, owner: String) : super(name, height, weight){

            }
    */
    override fun getInfo(): Unit {
        super.getInfo()
        println("$name is $height tall and weighs $weight and is owner $owner")

    }
}


// Nested Class :
//                  Its a class within class, which will be static by Default.
//                  So its function and properties can be accessed w/o creating object
//                  But it can't access outer class function and properties

class OuterNested {

    var outerName = "Master"
    fun getOuterName() {
        println("Calling Outer class , $ outerName")
    }

    class InnerNested {

        var innerName = "Blaster"
        fun getInnerName() {
            println("Calling Inner class , $innerName")
            //println("Calling  class , $outerName")  // Throws error as its not allowed
        }
    }
}

// Inner Class :
//                  Its a nested class marked as Inner
//                  We can access member of outer class even it is private
//                  Inner class keeps a reference to an object of outer class.

class OuterClass {

    private var outerName = "Master"
    fun getOuterName() {
        println("Calling Outer class , $outerName")
    }

    inner class InnerClass {

        var innerName = "Blaster"
        fun getInnerName() {
            println("Calling Inner class , $innerName")
            println("Calling  class , $outerName")

        }
    }
}