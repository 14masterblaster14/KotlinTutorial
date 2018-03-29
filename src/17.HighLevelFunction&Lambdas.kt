// high Level Functions :
//        - Can accept functions as a parameter
//        - Can return a function
//        - Or can do both
//
// Lambadas : Its a function with no name
//
// Closures :
//          In java 8, you can't mutate values of outside variable inside Lambadas.
//          But in Kotlin you can Change it.
//
// "it" : Implicit name of Single Parameter
//
// "with" , we can not access methods
//
// "apply" , returns the receiver to access methods

fun main(args: Array<String>) {


    val program = Program()
    program.addTwoNumbers(3, 4)

    program.addTwoNumbers(3, 4, object : MyInterface {
        override fun execute(sum: Int) {
            println(sum)
        }
    })

    val myLambada: (Int) -> Unit = { s: Int -> println(s) }    // Lambada Expression [Function]
    program.addTwoNumbers(3, 4, { s: Int -> println(s) })

    val myLambada1: (Int, Int) -> Int = { x, y -> x + y }
    program.addTwoNumbers(2, 7, myLambada1)       // OR
    program.addTwoNumbers(2, 7, { x, y -> x + y })     // OR
    program.addTwoNumbers(2, 7) { x, y -> x + y }      // OR

    // Closures:

    var result2 = 0
    val myLambada2: (Int, Int) -> Unit = { p, q -> result2 = p * q }
    program.multiplyTwoNumbers(5, 6, myLambada2)
    println(result2)

    // it

    //program.reverseAndDisplay("hello",{s -> s.reversed()})    // OR
    program.reverseAndDisplay("hello", { it.reversed() })

    // With and Apply

    var human = Human()
    human.name = "Master"
    human.age = 21

    println(human.name)
    println(human.age)

    with(human) {
        name = "Blaster"
        age = 31
        println(name)
        println(age)
    }

    human.apply {
        name = "MasterBlaster"
        age = 41
        println(name)
        println(age)
    }.startRun()

    // ---------------------------------------------------
    val (two, three) = nextTwo(1)
    println(" 1 $two $three")

    println("Sum = ${getSum(1, 2, 3, 4, 5)}")               //Sum = 15

    val multiply = { num1: Int, num2: Int -> num1 * num2 }
    println(" 5 * 3 = ${multiply(5, 3)}")                    // 5 * 3 = 15

    val multiply2 = { num1: Int -> num1 * 2 }
    val numList2 = arrayOf(1, 2, 3, 4, 5)
    mathOnList(numList2, multiply2)

    val numList3 = 1..20

    val listSum = numList3.reduce { x, y -> x + y }
    println("Reduced Sum : $listSum")           // 210

    val listSum1 = numList3.fold(5) { x, y -> x + y }
    println(" Fold Sum : $listSum1")            // 5+210 ==> 215


}


fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { n -> sum += n }
    return sum
}

fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
    for (num in numList) {
        println("MathOnList : ${myFunc(num)}")
    }
}

class Program {

    fun addTwoNumbers(a: Int, b: Int) {
        val sum = a + b
        println(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, action: MyInterface) {   // High level function with Lambda as a parameter

        val sum = a + b
        println(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, action: (Int) -> Unit) {   // High level function with Lambda as a parameter

        val sum = a + b
        println(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int) -> Int) {   // High level function with Lambda as a parameter

        val result = action(a, b) // x+y = a+b = 2+7 = 9
        println(result)
    }

    fun multiplyTwoNumbers(p: Int, q: Int, action1: (Int, Int) -> Unit) {   // High level function with Lambda as a parameter

        action1(p, q)
    }

    fun reverseAndDisplay(str: String, myFunc: (String) -> String) {

        var result3 = myFunc(str)       // str.reversed()= "hello".reversed = "olleh"
        println(result3)
    }

}

interface MyInterface {
    fun execute(sum: Int)
}


// With and Apply

class Human {

    var name: String = ""
    var age: Int = -1

    fun startRun() {
        println("Now, I am ready to run")
    }
}