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

// hashCode() and equals() :
    // hashCode() function returns a hash code value for the object.
    // equals() method return true if two objects have same contents and it works similar to “==”, but works different for Float and Double values.

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
    
    val hash1=user1.hashCode();
    val hash2=user2.hashCode();
    val hash3=user3.hashCode();
    val hash4=user4.hashCode();
    
    println(hash1)      //835510190
    println(hash2)      //835510190
    println(hash3)      //-938448478
    println(hash4)      //76322111
    println("hash1 == hash 2 ${hash1.equals(hash2)}")   // true  user1 and user2 have same object contents, so they are equal, thus they have same hash code values.
    println("hash2 == hash 3 ${hash2.equals(hash3)}")   // false
    println("hash1 == hash 3 ${hash1.equals(hash3)}")   // false

}

data class User(var name: String, var id: Int) {

    init {
        require(name.length > 4) { "Name length should be more than 4 chars" }
        require(id > 0) { "Id number should be greater than zero" }
    }
}
