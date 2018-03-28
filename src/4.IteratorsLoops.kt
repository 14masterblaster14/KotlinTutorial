// Iterators <Loops>
// 1. For loop
// 2. While loop
// 3. Do while loop
// 4. Break, Continue and Return statement

fun main(args: Array<String>) {

    //1. For loop
    for (i in 1..7) {
        println("i Numeber : $i")
    }

    //2. While loop
    var j = 2
    while (j <= 4) {
        println("j Number : $j")
        j++
    }

    while (j <= 10) {
        if (j % 2 == 0) {
            println(j)
        }
        j++
    }


    //3. Do while loop
    var k: Int = 4
    do {
        println("Hello")
        println("k Number : $k")
        k++
    } while (k < 7)

    var l: Int = 1
    do {
        if (l % 2 == 0) {
            println(l)
        }
        l++
    } while (l <= 4)


    //4. Break Statement
    myLoop@ for (m in 1..3) {
        for (n in 1..3) {
            println(" m: $m, n: $n")
            if (m == 2 && n == 2)
                break@myLoop
        }
    }

    //5. Continue Statement
    outer@ for (p in 1..3) {
        for (q in 1..3) {
            println(" p: $p, q: $q")
            if (p == 2 && q == 2)
                continue@outer
        }
    }
}
