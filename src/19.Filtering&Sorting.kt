/*
*   "filter"    : filter out desired elements from collections
*   "map"       : perform operations and modify elements
*
*   Predicates  : a condition that returns True or False
*                 "all"     - Do all elements satisfy the predicate/condition?
*                 "any"     - Do any elements satisfy the predicate/condition?
*                 "count"   - Total elements that satisfy the predicate/condition?
*                 "find"    - Return the first elements that satisfy the predicate/condition?
*
*   Fold        : It takes an initial value and uses it as the accumulated value on the first step.
*   Reduce      : The first step of reduce() uses the first and the second elements as operation arguments on the first step.
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
        println(num)                    // 2 3 4 6
    }

    val mySquaredNum = myNumbers.map { it * it }   //  { num -> num * num }

    for (num in mySquaredNum) {
        println(num)                    // 4 9 16 36 529 8100
    }

    val mySmallSquaredNums = myNumbers.filter { it < 10 }
            .map { it * it }

    for (num in mySmallSquaredNums) {
        println(num)                // 4 9 16 36
    }

    var people = listOf<Humans>(Humans(age = 10, name = "Master")
            , Humans("Blaster", 23), Humans("MasterBlaster", 17))

    var names = people.filter { it.name.startsWith("M") }
            .map { it.name }

    for (name in names) {
        println(name)                   // Master  MasterBlaster
    }


    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach({ n -> println(n) })           // 2 4 6 8 10 12 14 16 18 20


    //  Predicates

    val mynumbers = listOf(2, 3, 4, 6, 23, 90)
    val mywords = listOf("Sachin", "Saurav", "Virat", "Virender", "Yuvraj", "Mahendra")

    val myPredicate = { num: Int -> num > 10 }

    val check1 = myNumbers.all { it > 10 }      //OR
    val check_1 = myNumbers.all(myPredicate)
    println(check1)         // false

    val check2 = myNumbers.any { it > 10 }       //OR
    val check_2 = myNumbers.any(myPredicate)
    println(check2)     //  true


    val totalCount = myNumbers.count { it > 10 }         //OR
    val total_Count = myNumbers.count(myPredicate)
    println(totalCount)         // 2

    val num = myNumbers.find { it > 10 }  // returns the first element that matches the predicate  //OR
    val num1 = myNumbers.find(myPredicate)
    println(num)        // 23

    myNumbers.forEach { println(it) }           // 2 3 4 6 23 90

    myNumbers.forEachIndexed { index, i -> println("position $index contains a $i") }
    /* position 0 contains a 2
       position 1 contains a 3
       position 2 contains a 4
       position 3 contains a 6
       position 4 contains a 23
       position 5 contains a 90 */

    val maxVal = myNumbers.max()
    println(maxVal)         // 90

    val maxByValue = myNumbers.maxBy { -it }
    println(maxByValue)     // 2

    val maxByLength = mywords.maxBy { it.length }
    println(maxByLength)    // Virender

    val minVal = myNumbers.min()
    println(minVal)         // 2

    val minByValue = myNumbers.minBy { -it }
    println(minByValue)     // 90

    val minByLength = mywords.minBy { it.length }
    println(minByLength)    // Virat

    val _none = myNumbers.none { it % 7 == 0 }                // No elements are divisible by 7
    println(_none)      // true

    val _sumBy = myNumbers.sumBy { it % 2 }
    println(_sumBy)     // 2

    val _contains = myNumbers.contains(7)
    println(_contains)  // false

    val _elementAt = myNumbers.elementAt(4)
    println(_elementAt) // 23

    val _elementAtOrElse = myNumbers.elementAtOrElse(9, { 2 * it })
    println(_elementAtOrElse)       // 18

    val _elementAtOrNull = myNumbers.elementAtOrNull(9)
    println(_elementAtOrNull)       // null

    val _first = myNumbers.first { it % 2 == 0 }
    println(_first)         // 2

    val _firstOrNull = myNumbers.firstOrNull { it % 7 == 0 }
    println(_firstOrNull)  // null


    val _indexOf = myNumbers.indexOf(6)
    println(_indexOf)   // 3

    val _indexOfFirst = myNumbers.indexOfFirst { it % 2 == 0 }      //Returns index of the first element matching the given predicate,
    // or -1 if the collection does not contain such element.
    println(_indexOfFirst)  // 0

    val _indexOfLast = myNumbers.indexOfLast { it % 2 == 0 }        //Returns index of the Last element matching the given predicate,
    // or -1 if the collection does not contain such element.
    println(_indexOfLast)  // 5

    val _last = myNumbers.last { it % 2 == 0 }
    println(_last)              //90

    val mynumbersRepeated = listOf(2, 3, 4, 6, 23, 4, 90)

    val _lastIndexOf = mynumbersRepeated.lastIndexOf(4)
    println(_lastIndexOf)       //5

    val _lastOrNull = mynumbersRepeated.lastOrNull { it % 2 == 0 }
    println(_lastOrNull)        //90

    val _single = mynumbersRepeated.single { it % 5 == 0 }
    println(_single)        // 90

    val _singleOrNull = mynumbersRepeated.singleOrNull { it % 7 == 0 }
    println(_singleOrNull)  // null


    val list1 = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf(7, 8, 9, 10, 11, 12, 13, 14)

    var pair = list1.partition { it % 2 == 0 }
    println(pair)           // ([2, 4, 6], [1, 3, 5])
    println(pair.first)     // [2, 4, 6]
    println(pair.second)    // [1, 3, 5]

    val _plus = list1 + list2
    _plus.forEach { println(it) }          // 1 2 3 4 5 6 7 8 9 10 11 12 13 14

    val _zip = list1.zip(list2)
    _zip.forEach { println(it) }            //  (1, 7) (2, 8) (3, 9) (4, 10) (5, 11) (6, 12)


    val list3 = listOf(1, 12, 3, 41, 15, 65, 7)

    val _reverse = list3.reversed()
    _reverse.forEach { println(it) }      // 7 65 15 41 3 12 1

    val _sort = list3.sorted()
    _sort.forEach { println(it) }         // 1 3 7 12 15 41 65

    val _sortBy = list3.sortedBy { it % 3 }
    _sortBy.forEach { println(it) }       // 12 3 15 1 7 41 65

    val _sortDescending1 = list3.sortedDescending()
    _sortDescending1.forEach { print(it) }      // 65 41 15 12 7 3 1

    val _sortDescending2 = list3.sortedByDescending { it % 3 }
    _sortDescending2.forEach { println(it) }      // 41 65 1 7 12 3 15


    // fold & Reduce

    val _fold = myNumbers.fold(4) { total, next -> total + next }      //Initial value + summation from left to right (first to last element)
    println(_fold)  // 132 (4+128)

    val _foldRight = myNumbers.foldRight(7) { total, next -> total + next }  //Initial value + summation from right to left (last to first element)
    println(_foldRight)    // 135 (128+7)

    val _reduce = myNumbers.reduce { total, next -> total + next }     // summing from first to last element
    println(_reduce)        //128

    val _reduceRight = myNumbers.reduceRight { total, next -> total + next }  // summing from  last to first element
    println(_reduceRight)   //128


    // flatmap()

    val customerMap = mapOf(
            Pair(Customer("Jack", 25), Address("NANTERRE CT", "77471")),
            Pair(Customer("Mary", 37), Address("W NORMA ST", "77009")),
            Pair(Customer("Peter", 18), Address("S NUGENT AVE", "77571")),
            Pair(Customer("Amos", 23), Address("E NAVAHO TRL", "77449")),
            Pair(Customer("Craig", 45), Address("AVE N", "77587")))

    val customerList = customerMap.flatMap { (customer, _) -> listOf(customer) }
    customerList.forEach { println(it) }
/*
	Customer(name=Jack, age=25)
	Customer(name=Mary, age=37)
	Customer(name=Peter, age=18)
	Customer(name=Amos, age=23)
	Customer(name=Craig, age=45)
*/

    val addressList = customerMap.flatMap { (_, address) -> listOf(address) }
    addressList.forEach { println(it) }
/*
	Address(street=NANTERRE CT, postcode=77471)
	Address(street=W NORMA ST, postcode=77009)
	Address(street=S NUGENT AVE, postcode=77571)
	Address(street=E NAVAHO TRL, postcode=77449)
	Address(street=AVE N, postcode=77587)
*/

    val customerInfos = customerMap.flatMap { (customer, address) -> listOf("${customer.name} lives at ${address.street}") }
    customerInfos.forEach { println(it) }
/*
	Jack lives at NANTERRE CT
	Mary lives at W NORMA ST
	Peter lives at S NUGENT AVE
	Amos lives at E NAVAHO TRL
	Craig lives at AVE N
*/

    //flatMapTo()

    var newCustomerList = mutableListOf(Customer("Kelly", 37))

    customerMap.flatMapTo(newCustomerList, { (customer, _) -> listOf(customer) })
    newCustomerList.forEach { println(it) }
/*
	Customer(name=Kelly, age=37)
	Customer(name=Jack, age=25)
	Customer(name=Mary, age=37)
	Customer(name=Peter, age=18)
	Customer(name=Amos, age=23)
	Customer(name=Craig, age=45)
*/


    // Distinct

    val a = arrayOf("a", "a", "b", "c", "c")
    val b = a.distinct()
    println(b)      // ["a", "b", "c"]

    val c = listOf("a", "b", "ab", "ba", "abc")
    val d = c.distinctBy { it.length }
    println(d)      // ["a", "ab", "abc"]


    var list4 = listOf<Int>(1, 2, 4, 5, 8, 9, 3, 45, 65, 1, 2, 4, 5, 8, 9, 3, 45, 65)
    val e = list4.distinct()
    println(e)      // [1, 2, 4, 5, 8, 9, 3, 45, 65]
}

class Humans(var name: String, var age: Int)

data class Address(val street: String, val postcode: String)

data class Customer(val name: String, val age: Int
)
