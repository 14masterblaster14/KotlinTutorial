// Default Classes are public and final
// "open"
// Super Class "Any" contains functions :
//              equals() : Boolean
//              hashCode(): Int
//              toString(): String
// Primary Constructor can have properties
// Secondary Constructor cannot have the properties


fun main(args: Array<String>) {

    // Case 1.

    var animal = Animal()
    animal.color = "white"
    animal.eat()

    var dog = Dog()
    dog.breed = "labra"
    dog.color = "black"
    dog.bark()
    dog.eat()

    var cat = Cat()
    cat.age = 7
    cat.color = "brown"
    cat.meow()
    cat.eat()

    // case 2
    var dog1 = Dog1("Dog_Black", "Pug")

    // case 3
    var dog2 = Dog2("Black", "Pug")
}

//-------------- Case 1

open class Animal {
    //var color = ""
    open var color = "Animal_White"

    init {
        println(" From Animal Init block : $color")
    }

    open fun eat() {
        println("Animal is Eating")
    }
}

class Dog : Animal() {
    var breed = ""
    override var color = "Dog_Black"

    init {
        println("From Dog Init block : $color and $breed")
    }

    override fun eat() {
        super.eat()    // Specify super class name if multiple base classes have same function
        println("Dog is Eating")
    }

    fun bark() {
        println("Bark")
    }
}

class Cat : Animal() {
    var age = -1

    fun meow() {
        super.eat()
        println("Meow")
    }
}


//-------------- Case 2

open class Animal1(var color1: String) {
    // var color1 = ""
    //open var color1 = "Animal_White"

    init {
        println(" From Animal1 Init block : $color1")
    }
}

class Dog1(color1: String, var breed1: String) : Animal1(color1) {  // Referencing the super primary constructor
    init {
        println("From Dog1 Init block : $color1 and $breed1")
    }
}


//-------------- Case 3 Secondary Constructor

open class Animal2 {
    var color2 = ""

    constructor(color2: String) {
        this.color2 = color2
        println(" From Animal2 constructor block : $color2")
    }
}

class Dog2 : Animal2 {
    var breed2 = ""

    constructor(color2: String, breed2: String) : super(color2) {  // Referencing the super secondary constructor
        this.breed2 = breed2
        println("From Dog2 constructor block : $color2 and $breed2")
    }
}

//-------------- Case 4

open class Animal3() {
    var color3 = ""

    constructor(color3: String) : this() {  // referencing the primary constructor
        this.color3 = color3
        println(" From Animal3 constructor block : $color3")
    }
}


