// Super Class "Any" contains functions :
//              equals() : Boolean
//              hashCode(): Int
//              toString(): String
// Data class has all these with "copy" as well

//Data classes have to fulfill the following requirements to ensure the consistency:
    // The primary constructor needs to have at least one parameter.
    // All primary constructor parameters need to be marked as val or var.
    // Data classes cannot be abstract, open, sealed or inner.
    // Data classes may only implement interfaces.



fun main(args: Array<String>) {

    var user1 = User("Master", 7)
    var user2 = User("Master", 7)

    if (user1 == user2) {
        println("objects are equal")    // objects are equal
    } else {
        println("objects are not equal")
    }

    println(user1.toString())   //  User(name=Master, id=7)

    var user3 = user1.copy("Blaster")   // user1.copy(name = "Blaster")
    println(user3)                                 //  User(name=Blaster, id=7)

    var user4 = user1.copy(id = 10)    // user1.copy(10)
    println(user4)                          //  User(name=Master, id=10)

}

data class User(var name: String, var id: Int) {

    init {
        require(name.length > 4) { "Name length should be more than 4 chars" }
        require(id > 0) { "Id number should be greater than zero" }
    }
}
