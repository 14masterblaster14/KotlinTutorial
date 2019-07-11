// Extension Functions

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
}

class Student {

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

fun Int.greaterValue(other: Int): Int {

    if (this > other)
        return this
    else
        return other
}

