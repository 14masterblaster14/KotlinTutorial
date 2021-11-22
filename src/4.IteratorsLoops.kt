// Iterators <Loops>
// 1. For loop
// 2. While loop
// 3. Do while loop
// 4. Break, Continue and Return statement
// 5. Repeat statement

fun main(args: Array<String>) {

    //1. For loop
    for (i in 1..7) {
        println("i Numeber : $i")
    }

/* O/P :
        i Numeber : 1
        i Numeber : 2
        i Numeber : 3
        i Numeber : 4
        i Numeber : 5
        i Numeber : 6
        i Numeber : 7
*/

var planets = arrayOf("Earth", "Mars", "Venus", "Jupiter", "Saturn")
  
    for (i in planets.indices) {
        println(planets[i])
    }
    
/* O/P :   
        Earth
        Mars
        Venus
        Jupiter
        Saturn
*/
     
    var m = 1
    var n = 4
    for (i in m until n) {
        println(i)
    }

/* O/P :
        1
        2
        3
*/

    //2. While loop
    var j = 2
    while (j <= 4) {
        println("j Number : $j")
        j++
    }

/*O/P:
        j Number : 2
        j Number : 3
        j Number : 4
*/

    while (j <= 10) {
        if (j % 2 == 0) {
            println(j)
        }
        j++
    }

/*O/P:
        6
        8
        10
*/


//3. Do while loop
    var k: Int = 4
    do {
        println("Hello")
        println("k Number : $k")
        k++
    } while (k < 7)

/* O/P:
        Hello
        k Number : 4
        Hello
        k Number : 5
        Hello
        k Number : 6
*/

    var l: Int = 1
    do {
        if (l % 2 == 0) {
            println(l)
        }
        l++
    } while (l <= 4)

/* O/P:
        2
        4
*/


    //4. Break Statement
    myLoop@ for (m in 1..3) {
        for (n in 1..3) {
            println(" m: $m, n: $n")
            if (m == 2 && n == 2)
                break@myLoop
        }
    }

/*O/P:
         m: 1, n: 1
         m: 1, n: 2
         m: 1, n: 3
         m: 2, n: 1
         m: 2, n: 2
*/


    //5. Continue Statement
    outer@ for (p in 1..3) {
        for (q in 1..3) {
            println(" p: $p, q: $q")
            if (p == 2 && q == 2)
                continue@outer
        }
    }

/*O/P:
         p: 1, q: 1
         p: 1, q: 2
         p: 1, q: 3
         p: 2, q: 1
         p: 2, q: 2
         p: 3, q: 1
         p: 3, q: 2
         p: 3, q: 3
 */


    //6. Return Statement : It is return the control.

    for (p in 1..3) {
        if (p == 3) return
        for (q in 1..3) {
            println(" p: $p, q: $q")
        }
    }

/*O/P:
         p: 1, q: 1
         p: 1, q: 2
         p: 1, q: 3
         p: 2, q: 1
         p: 2, q: 2
         p: 2, q: 3
*/


    //7. Repeat Statement : It is used when a set of statements has to be executed N-number of times.

    repeat(4) {
        println("Hello World!")
    }

    /* O/P :
    Hello World!
    Hello World!
    Hello World!
    Hello World!
    */

    repeat(4) { i ->
        println("This line will be printed 4 times")
        println("Currently, we are on the ${i + 1} loop iteration")
    }

    /*O/P:-
    This line will be printed 4 times
    Currently, we are on the 1 loop iteration
    This line will be printed 4 times
    Currently, we are on the 2 loop iteration
    This line will be printed 4 times
    Currently, we are on the 3 loop iteration
    This line will be printed 4 times
    Currently, we are on the 4 loop iteration
    */
}
