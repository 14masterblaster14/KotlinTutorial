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

    // Element  :   32  0   0   54  0
    // Index    :   0   1   2   3   4

    var myArray = Array<Int>(5) { 0 }       // Mutable, Fixed Size
    myArray[0] = 32
    myArray[3] = 54
    myArray[1] = 11

    for (element in myArray) {
        println(element)
    }

    for (index in 0..myArray.size - 1) {
        println(myArray[index])
    }

    println("Array length : ${myArray.size}")
    println("32 in Array : ${myArray.contains(32)}")

    var partMyArray = myArray.copyOfRange(0, 1)
    println("partMyArray : ")

    for (element in partMyArray) {
        println(element)
    }

    println("First : ${myArray.first()}")
    println("54 index : ${myArray.indexOf(54)}")



    //  ********  List  ********

    var list = listOf<String>("Yogi", "Manmohan", "Vajpayee")     // Immutable, Fixed Size, READ only

    for (element in list) {
        println(element)
    }

    for (index in 0..list.size - 1) {
        println(list[index])   // list.get(index)
    }

    var list1 = mutableListOf<String>()       // Mutable, No Fixed size, Can Add/Remove elements
    var list2 = arrayListOf<String>()           // Mutable, No Fixed size, Can Add/Remove elements
    var list3 = ArrayList<String>()                           // Mutable, No Fixed size, Can Add/Remove elements

    list3.add("Yogi")       //0
    list3.add("Manmohan")   //1
    list3.add("Vajpayee")   //2

    //list3.remove("Manmohan")
    //list3.add("Modi")
    list3[1] = "Modi"

    for (element in list3) {
        println(element)
    }

    println("First : ${list3.first()}")
    println("Last : ${list3.last()}")
    println("Sublist : ${list3.subList(0, 1)}")

    list1.add(0, "India")
    list1.add(2, "America")
    list2.add(1, "Japan")

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