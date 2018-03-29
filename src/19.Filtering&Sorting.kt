/*
*   "filter"    : filter out desired elements from collectons
*   "map"       : perform operations and modify elements
*
*   Predicates  : a condition that returns True or False
*                 "all"     - Do all elements satisfy the predicate/condition?
*                 "any"     - Do any elements satisfy the predicate/condition?
*                 "count"   - Total elements that satisfy the predicate/condition?
*                 "find"    - Return the first elements that satisfy the predicate/condition?
*
*   "flatmap"   : Filter elements from collection of collection
*
*   "distinct"  : Returns the unique results
* */

fun main(args: Array<String>) {

    //  Filters and Map

    val myNumbers: List<Int> = listOf(2, 3, 4, 6, 23, 90)

    val mySmallNums = myNumbers.filter { it < 10 }  // { v -> v < 10 }

    for (num in mySmallNums) {
        println(num)
    }

    val mySquaredNum = myNumbers.map { it * it }   //  { num -> num * num }

    for (num in mySquaredNum) {
        println(num)
    }

    val mySmallSquaredNums = myNumbers.filter { it < 10 }
            .map { it * it }

    for (num in mySmallSquaredNums) {
        println(num)
    }

    var people = listOf<Humans>(Humans(age = 10, name = "Master")
            , Humans("Blaster", 23), Humans("MasterBlaster", 17))

    var names = people.filter { it.name.startsWith("M") }
            .map { it.name }

    for (name in names) {
        println(name)
    }


    //  Predicates

    val mynumbers = listOf(2, 3, 4, 6, 23, 90)

    val myPredicate = { num: Int -> num > 10 }

    val check1 = myNumbers.all { it > 10 }      //OR
    val check_1 = myNumbers.all(myPredicate)
    println(check1)

    val check2 = myNumbers.any { it > 10 }       //OR
    val check_2 = myNumbers.any(myPredicate)
    println(check2)

    val totalCount = myNumbers.count { it > 10 }         //OR
    val total_Count = myNumbers.count(myPredicate)
    println(totalCount)

    val num = myNumbers.find { it > 10 }  // returns the first element that matches the predicate  //OR
    val num1 = myNumbers.find(myPredicate)
    println(num)

}

class Humans(var name: String, var age: Int)