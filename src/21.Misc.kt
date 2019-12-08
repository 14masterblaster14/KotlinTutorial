//  let
//  run
//  also
// "apply" , returns the receiver to access methods
// "with" , we can not access methods
// Refer let_run_also_apply_with.png

fun main(args: Array<String>) {

    // let

    var str = "Hello World"
    str.let { println("$it !!!") }          // Hello World !!!
    println(str)                            // Hello World


    var strlen = str.let { str.length }
    println("String length : ${strlen}")        // String length : 11
    strlen = str.let { "$it updated".length }
    println("Updated string length : ${strlen}") //Updated string length : 19

    var a = 3
    var b = 5
    a = a.let { it + 2 }.let {
        val i = it + b
        i
    }
    println(a)          // 5


    // run : executes the block to return the result

    var name = "I am MasterBlaster"
    println(name)       // I am MasterBlaster

    name = run {
        val name = "I am Dada"
        name
    }
    println(name)       // I am Dada


    // let and run

    var firstName: String? = null
    firstName?.let { println("First name is $firstName ") } ?: run {
        println("firstname was null, setting the default value")
        firstName = "Master"
    }

    println(firstName)          // Master


    // also
    val course1 = Course(1, "MasterBlaster", "Electronics")
    var x = course1.also { it }  // Course@5e2de80c
    var y = course1.also { println("Hi") }      // Hi

    course1.also {
        it.id += 2
        it.branch = "Computer"
    }

    // apply : to change the values

    val course2 = Course(2, "Dadaa", "Mechanical")
    println(course2)                // Course(id=2, name=Dadaa, branch=Mechanical)
    course2.apply {
        id = 3
        name = "Bengal Tiger"
        branch = "Mechatronics"
    }
    println(course2)                // Course(id=3, name=Dadaa, branch=Mechatronics)

    // with (not preferred way)
    var course3 = Course(4, "Mumbai Indians", "IPL")

    var z = with(course3) {
        id = 5
        name = "Chennai SuperKings"
        branch = "One Day"
    }                            // Course(id=4, name=Mumbai Indians, branch=One Day)

    println(course3)             // Course(id=4, name=Mumbai Indians, branch=One Day)


    // With and Apply

    var human = Human()
    human.name = "Master"
    human.age = 21

    println(human.name)         // Master
    println(human.age)          // 21

    with(human) {
        name = "Blaster"
        age = 31
        println(name)           // Blaster
        println(age)            // 31
    }

    human.apply {
        name = "MasterBlaster"
        age = 41
        println(name)           // MasterBlaster
        println(age)            // 41
    }.startRun()                // Now, I am ready to run


}

data class Course(var id: Int, var name: String, var branch: String) {

    init {
        require(name.length > 4) { "Name length should be more than 4 chars" }
        require(branch.length > 2) { "Name length should be more than 2 chars" }
    }
}


// With and Apply

class Human {

    var name: String = ""
    var age: Int = -1

    fun startRun() {
        println("Now, I am ready to run")
    }
}


/* e.g:

// Normal approach
fun createInstance(args: Bundle) : MyFragment {
    val fragment = MyFragment()
    fragment.arguments = args
    return fragment
}

// Improved approach
fun createInstance(args: Bundle)
        = MyFragment().apply { arguments = args }


/ Normal approach
fun createIntent(intentData: String, intentAction: String): Intent {
    val intent = Intent()
    intent.action = intentAction
    intent.data=Uri.parse(intentData)
    return intent
}

// Improved approach, chaining
fun createIntent(intentData: String, intentAction: String) =
        Intent().apply { action = intentAction }
                .apply { data = Uri.parse(intentData) }

*/