//  Java Recap :    Object class is the parent class for all Java objects. 
//                  The equals() and hashcode() are the two important methods provided by the Object class for comparing objects. 
//                  equals() :  
//                             -The java equals() is a method of lang.Object class, and it is used to compare two objects.
//                             -To compare two objects that whether they are the same, it compares the values of both the object's attributes.
//                             -By default, two objects will be the same only if stored in the same memory location.
//                  hashcode():
//                              -A hashcode is an integer value associated with every object in Java, facilitating the hashing in hash tables.
//                              -To get this hashcode value for an object, we can use the hashcode() method in Java. It is the means hashcode() method that returns the integer hashcode value of the given object.
//                              -Since this method is defined in the Object class, hence it is inherited by user-defined classes also.
//                              -The hashcode() method returns the same hash value when called on two objects, which are equal according to the equals() method. And if the objects are unequal, it usually returns different hash values.

// If two objects are the same as per the equals(Object) method, then if we call the hashCode() method on each of the two objects, it must provide the same integer result.
// Note: As per the Java documentation, both the methods should be overridden to get the complete equality mechanism; using equals() alone is not sufficient. It means, if we override the equals(), we must override the hashcode() method.
//**********************************************************************************************************************************************

// KOTLIN

// By default Classes are public and final
// "open"
// Super Class "Any" contains functions :
//              equals()  : Boolean
//              hashCode(): Int
//              toString(): String
// Primary Constructor can have properties
// Secondary Constructor cannot have the properties
// Member & Method overriding


fun main(args: Array<String>) {

    // Case 1.

    var animal = Animal()   // From Animal Init block : Animal_White
    animal.color = "white"
    animal.eat()        //  Animal is Eating

    var dog = Dog()     //  From Animal Init block : null
    //  From Dog Init block : Dog_Black and
    dog.breed = "labra"
    dog.color = "black"
    dog.bark()          //  Bark
    dog.eat()           //  Animal is Eating
    //  Dog is Eating

    var cat = Cat()     //  From Animal Init block : Animal_White
    cat.age = 7
    cat.color = "brown"
    cat.meow()          //  Animal is Eating
    //  Meow
    cat.eat()           //  Animal is Eating

    // case 2
    var dog1 = Dog1("Dog_Black", "Pug") //  From Animal1 Init block : Dog_Black
    //  From Dog1 Init block : Dog_Black and Pug

    // case 3
    var dog2 = Dog2("Black", "Pug")     //  From Animal2 constructor block : Black
    //  From Dog2 constructor block : Black and Pug
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


