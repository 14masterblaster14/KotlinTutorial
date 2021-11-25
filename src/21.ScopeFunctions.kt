//  let
//  run
//  also
// "apply" , returns the receiver to access methods
// "with" , we can not access methods
//
// Refer let_run_also_apply_with.png

**************************************************************************

Scope Functions :	functions which define to the scope of the calling object.
						There are five types of scope functions:

						- let
						- run
						- with
						- apply
						- also
						
						
								Function 		Object Reference		Return Value
								let				it 						Lambda result
								run				this					Lambda result
								with			this					Lambda result
								apply			this					Context object
								also			it						Context object
						
						Note : Lambda result = some result
						
						Summary :
								Scope functions make code more readable, clear and concise.
								Object reference – ‘this’ and ‘it’.
								Return value – context object and lambda result.
								let : working with nullable objects to avoid NullPointerException.
								apply : changing object configuration.
								run: operate on nullable object, executing lambda expressions.
								also : adding additional operations.
								with : operating on non-null objects.
						
						1) let :-	
									let uses the context as it or we can use a named parameter.
									let return the last expression of the lambda passed which can also be void.

						
								null safety : let function used with ?. ensures the execution only if the expression is non-null.
								
								class Employee {
												var firstName: String? = null
												var age: Int = 0
												}
												
								val emp = Employee()
									emp.firstName = "Sachin"
									emp.age = 10	
									
								emp?.let{
											println(it.age)
										}	
								
								emp?.let{ person->
											person.firstName?.let { name ->
												println(name)
											}
										}	
								
								// If the let lambda contains only a single expression, we can even use method reference (::) instead of lambda
								employee?.firstName?.let (::println)	
								
								// Chain Operations
								var list = mutableListOf(6, 1, 5, 2, 4, 3)
								list.filter { it % 2 == 0 }.sortedBy { it }.let {
									println("Sorted even numbers are : $it")			// Sorted even numbers are : [2, 4, 6]
								}
								
								//If we want to return that object from let function, return without marking any return statement.
								
								var list = mutableListOf(6, 1, 5, 2, 4, 3)
								var sortedEvenList = list.filter { it % 2 == 0 }
														 .sortedBy { it }.let {
															println("Sorted even numbers are : $it")	// Sorted even numbers are : [2, 4, 6]
															it
														}
														
														
						2) run - 	run which is an extension to Template class is similar to let but the only difference is in let we get a reference as it whereas in run, the reference is this.
									
									run uses the context as this and we can not use a named parameter instead of this.
									run return the last expression of the lambda passed which can also be void.	
									
							null safety : run function used with ?. ensures the execution only if the expression is non-null.
							
							employee?.run {
							println(age)
						}
						
						employee?.run {
							println(this.age)
						}
						
						
						
						3) with - 
									with is used to call the function on the context object without providing the lambda result.
									This means with can't be chained or we can't pass any lambda result to with function. 
									with will always be the starting point of any expression.
									
									with uses the context as this and we can not use a named parameter instead of this.
									with return the last expression of the lambda passed which can also be void.		
									
									with(emp){
											firstName = "Suneet"
											age = 27
											println(firstName)
										}
										
								
								
								We can even chain the with function:
								
								val list = listOf(1, 2, 3, 4, 5)
									with(list){
										list.filter { it % 2 == 0 }
									}
									.forEach { 
										println(it) 
									}
									
									
						4) also :	
									also uses the context as it or we can use a named parameter.
									also returns the calling object itself.	

									 // initialized
									val list = mutableListOf<Int>(1, 2, 3)
								  
									// later if we want to perform multiple operations on this list
									list.also {
										it.add(4)
										it.remove(2)
									}
									println(list)
									

						5) apply:
									apply uses the context as this and we can not use a named parameter instead of this.
									apply returns the calling object itself.

									
									val emp = Employee().apply{
									firstName = "Suneet Agrawal"
									age = 27
								}
								
							println("name:${emp.firstName} age:${emp.age}" )

















****************************************************************************
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


    // also ( we need to access the object with its reference)

    val course1 = Course(1, "MasterBlaster", "Electronics")
    var x = course1.also { it }  // Course@5e2de80c
    var y = course1.also { println("Hi") }      // Hi

    course1.also {
        it.id += 2
        it.branch = "Computer"
    }

    println(course1)    //  Course(id=3, name=MasterBlaster, branch=Computer)

    // apply : to change the values without reference

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
    println(course3)            // Course(id=4, name=Mumbai Indians, branch=One Day)

    var z = with(course3) {
        id = 5
        name = "Chennai SuperKings"
        branch = "One Day"
    }

    println(course3)    //  Course(id=5, name=Chennai SuperKings, branch=One Day)


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
