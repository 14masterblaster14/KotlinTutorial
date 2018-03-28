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