/*
*
*   Array : Mutable , but fixed size
*   --------------------------------
*
*   ************************ Collections **************************
*
*   Immutable Collections < read only operations >
*   ----------------------------------------------
*   Immutable List : listOf
*   Immutable Map  : mapOf
*   Immutable Set  : setOf
*
*   Mutable Collections  < read and write operations >
*   --------------------------------------------------
*   Mutable List   : ArrayList, arrayListOf, mutableListOf
*   Mutable Map    : HashMap,   hashMapOf,   mutableMapOf
*   Mutable Set    : mutableSetOf,  hashSetOf
*
*/

fun main(args: Array<String>) {

    //  ********  Array  ********
    //  Mutable , but fixed size

    // Element  :   32  0   0   54  0
    // Index    :   0   1   2   3   4


    var myArray = Array<Int>(5) { 0 }       // Mutable, Fixed Size
    // Arrasize = 5, default value = 0
    for (element in myArray) {
        println(element)
    }

    // O/P :- 0 0 0 0 0

    myArray[0] = 32
    myArray[3] = 54
    myArray[1] = 11

    for (element in myArray) {
        println(element)
    }

    // O/P :- 32 11 0 54 0

    for (index in 0..myArray.size - 1) {
        println(myArray[index])
    }
    // O/P :- 32 11 0 54 0

    println("Array length : ${myArray.size}")       //Array length : 5
    println("32 in Array : ${myArray.contains(32)}")    //32 in Array : true


    var partMyArray = myArray.copyOfRange(0, 1)
    println("partMyArray : ")

    for (element in partMyArray) {
        println(element)
    }
    //O/P : 32

    println("First : ${myArray.first()}")   // First : 32
    println("54 index : ${myArray.indexOf(54)}")    //54 index : 3


    var myArray1 = arrayOf(1, 10, 4, 6, 15)
    var myArray2 = arrayOf<Int>(1, 10, 4, 6, 15)
    val myArray3 = arrayOf<String>("Ajay", "Prakesh", "Michel", "John", "Sumit")
    var myArray4 = arrayOf(1, 10, 4, "Ajay", "Prakesh")
    var myArray5: IntArray = intArrayOf(5, 10, 20, 12, 15)


    //  ********  List  ********

    var list = listOf<String>("Yogi", "Manmohan", "Vajpayee")     // Immutable, Fixed Size, READ only

    for (element in list) {
        println(element)
    }
    //O/P :- Yogi   Manmohan  Vajpayee

    for (index in 0..list.size - 1) {
        println(list[index])   // list.get(index)
    }
    //O/P :- Yogi   Manmohan  Vajpayee

    for ((index, value) in list.withIndex()) {
        println("The element at $index is $value")
    }
    /*O/P :-
    The element at 0 is Yogi
    The element at 1 is Manmohan
    The element at 2 is Vajpayee
    */

    var anyList = listOf<Any>(1, 2, 3, "a", "b", "c")
    for (element in anyList) {
        println(element)
    }
    // O/P - 1 2 3 a b c

    var list1 = mutableListOf<String>()       // Mutable, No Fixed size, Can Add/Remove elements
    var list2 = arrayListOf<String>()           // Mutable, No Fixed size, Can Add/Remove elements
    var list3 = ArrayList<String>()                           // Mutable, No Fixed size, Can Add/Remove elements

    list3.add("Yogi")       //0
    list3.add("Manmohan")   //1
    list3.add("Vajpayee")   //2
    list3.add("Modi")   //3
    list3.add("Vajpayee")   //4


    //list3.remove("Manmohan")
    //list3.add("Modi")
    list3[1] = "Modi"

    for (element in list3) {
        println(element)
    }
    // O/P :-   Yogi Modi Vajpayee Modi Vajpayee

    var list4 = listOf<String>("Vajpayee", "Modi")

    println("First : ${list3.first()}")     //First : Yogi
    println("Last : ${list3.last()}")       //Last : Vajpayee
    println("Sublist : ${list3.subList(0, 1)}") //Sublist : [Yogi]
    println(list3.get(0))   //Yogi
    println(list3.indexOf("Vajpayee")) // 2
    println(list3.lastIndexOf("Vajpayee"))  // 4
    println(list3.size) //5
    println(list3.contains("Modi")) // true
    println(list3.containsAll(list4))   //true
    println(list3.subList(2, 4))     // [Vajpayee, Modi]
    println(list3.isEmpty())    // false
    println(list3.drop(1))  // [Modi, Vajpayee, Modi, Vajpayee]
    println(list3.dropLast(2))  // [Yogi, Modi, Vajpayee]

    for (element in list3) {
        println(element)
    }
    // O/P : Yogi Modi Vajpayee Modi Vajpayee

    list1.add(0, "India")
    list1.add("America")
    list1.add(1, "Japan")
    list2.add("Maharashtra")

    for (element in list1) {
        println(element)
    }
    // O/P : India Japan America


    //  ********  Map  ********
    //  Key - Value Pair

    var myMap = mapOf<Int, String>(4 to "Yogi", 43 to "Manmohan", 7 to "Vajpayee")  // Immutable, Fixed Size, READ only

    for (key in myMap.keys) {
        println("Element at Key : $key = ${myMap[key]}")    // myMap.get(key)
    }

    var myMap1 = mutableMapOf<Int, String>()    // Mutable, No Fixed size, Can Add/Remove elements
    var myMap2 = hashMapOf<Int, String>()         // Mutable, No Fixed size, Can Add/Remove elements
    var myMap3 = HashMap<Int, String>()                            // Mutable, No Fixed size, Can Add/Remove elements

    myMap3.put(4, "yogi")
    myMap3.put(43, "Manmohan")
    myMap3.put(7, "Vajpayee")

    myMap3.put(43, "Modi")

    for (key in myMap3.keys) {
        println("Element at Key : $key = ${myMap3[key]}")    // myMap3.get(key)
    }

    val myMap4 = mutableMapOf<Int, Any?>()
    myMap4[1] = "Master"
    myMap4[2] = 14
    for (key in myMap4.keys) {
        println("Element at Key : $key = ${myMap4[key]}")    // myMap4.get(key)
    }

    myMap1.put(14, "MasterBlaster")
    myMap2.put(21, "Dada")


    //  ********  Set  ********
    //  "Set" contains Unique element
    //  "HashSet" also contains unique element but sequence is not guaranteed in output

    var mySet = setOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)      // Immutable, Fixed Size, READ only

    for (element in mySet) {
        println(element)
    }

    var mySet1 = mutableSetOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)  // Mutable, No Fixed size, Can Add/Remove elements
    var mySet2 = hashSetOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)       // Mutable, No Fixed size, Can Add/Remove elements

    mySet2.remove(54)
    mySet2.add(100)

    for (element in mySet2) {
        println(element)
    }

    mySet1.add(7)
    mySet1.remove(8)
}