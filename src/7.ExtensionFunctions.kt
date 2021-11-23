// Extension Functions :
//    We can add more functionality to the existing classes, by without inheriting them and without modifying the actual class.
// Companion Object Extensions 

fun main(args: Array<String>) {

    var student = Student()
    println("Pass Status " + student.hasPassed(60))         //  Pass Status true
    println("Scholarship Status " + student.isScholar(95))  //  Scholarship Status true

    //We can also create the extension function for standard/ predefined classes as well
    val string1 = "Hello"
    val string2 = "World!"
    var string3 = "Hey,"

    println(string3.add(string1, string2))  // Hey,HelloWorld!

    val x = 6
    val y = 10
    val greaterValue = x.greaterValue(y)
    println(greaterValue)           // 10

    val list1 = mutableListOf(5, 10, 15)
    println("before swapping the list :$list1")     // before swapping the list :[5, 10, 15]
    val result1 = list1.swap(0, 2)
    println("after swapping the list :$result1")    // after swapping the list :[15, 10, 5]

    val list2 = null
    println("before swapping the list :$list2")     //  before swapping the list :null
    val result2 = list2.swap(0, 2)
    println("after swapping the list :$result2")    // after swapping the list :null
    
    // Companion Object Extensions 
    val ob = MyClass.display("Function declared in companion object")
    println(ob)                                     //Function declared in companion object
    // invoking the extension function 
    val ob2 = MyClass.abc()                         //Extension function of companion object
}

class Student {

    var grade: String? = null
    fun hasPassed(marks: Int): Boolean {
        return marks > 40
    }
}

// Extension function of Student class which will act like a static method

fun Student.isScholar(marks: Int): Boolean {
    return marks >= 95
}


// Extension to standard/ predefined String class, Int class

fun String.add(s1: String, s2: String): String {

    return this + s1 + s2
}

// Nullable receiver
fun Int?.greaterValue(other: Int): Int {
    if(this == null){
            println("Null")
       }else{
                if (this > other)
                    return this
                else
                    return other
            }
}

fun MutableList<Int>.swap(index1: Int, index2: Int): MutableList<Int> {

    val tmp = this[index1] // 'this' represents to the list
    this[index1] = this[index2]
    this[index2] = tmp
    return this
}

//  Extension Function as Nullable Receiver
fun MutableList<Int>?.swap(index1: Int, index2: Int): Any {
    if (this == null) return "null"
    else {
        val tmp = this[index1] // 'this' represents to the list
        this[index1] = this[index2]
        this[index2] = tmp
        return this
    }
}

// Companion Object Extensions 

class MyClass {
    companion object {
        // member function of companion object
        fun display(str :String) : String{
            return str
        }
    }
} 
    // extension function of companion object
fun MyClass.Companion.abc(){
    println("Extension function of companion object")
}
