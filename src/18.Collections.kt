import java.util.HashMap
import kotlin.collections.ArrayList
import kotlin.collections.set

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
    println(myArray.average())      // 19.4


    var partMyArray = myArray.copyOfRange(0, 1)
    println("partMyArray : ")

    for (element in partMyArray) {
        println(element)
    }
    //O/P : 32

    println("First : ${myArray.first()}")   // First : 32
    println("54 index : ${myArray.indexOf(54)}")    //54 index : 3

    var myNullArray = arrayOfNulls<Int>(4)  // Uninitialized array : [null,null,null,null]
    var myArray0 = Array(4) { i -> i * 2 }  // Array using closure : [0,2,4,8]
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

    for (element in list1) {
        println(element)
    }
    // O/P : India Japan America

    list2.add("Maharashtra")
    list2.add("MP")
    list2.add("Andhra")
    list2.add("Gujarat")
    for (element in list2) {
        println(element)
    }
    // Maharashtra MP Andhra Gujarat

    var list5 = arrayListOf<String>("Delhi", "Kashmir")
    var list6 = arrayListOf<String>("Karnataka", "Kerala")
    var list7 = arrayListOf<String>("Maharashtra", "Kerala", "Rajastan")

    list2.addAll(1, list5)
    for (element in list2) {
        println(element)
    }
    // Maharashtra Delhi Kashmir MP Andhra Gujarat

    list2.addAll(list6)
    for (element in list2) {
        println(element)
    }
    // Maharashtra Delhi Kashmir MP Andhra Gujarat Karnataka Kerala

    list2.remove("Karnataka")
    for (element in list2) {
        println(element)
    }
    // Maharashtra Delhi Kashmir MP Andhra Gujarat Kerala

    list2.removeAt(3)
    for (element in list2) {
        println(element)
    }
    // Maharashtra Delhi Kashmir Andhra Gujarat Kerala

    list2.removeAll(list5)
    for (element in list2) {
        println(element)
    }
    // Maharashtra Andhra Gujarat Kerala

    list2.set(2, "Rajastan")
    for (element in list2) {
        println(element)
    }
    // Maharashtra Andhra Rajastan Kerala

    list2.retainAll(list7)
    for (element in list2) {
        println(element)
    }
    // Maharashtra Rajastan Kerala

    list5.clear()
    for (element in list5) {
        println(element)
    }

    println(list2.subList(0, 1)) // [Maharashtra]
    for (element in list2) {
        println(element)
    }
    // Maharashtra Rajastan Kerala


    //  ********  Map  ********
    //  Key - Value Pair

    var myMap = mapOf<Int, String>(4 to "Yogi", 43 to "Manmohan", 7 to "Vajpayee")  // Immutable, Fixed Size, READ only

    for (key in myMap.keys) {
        println("Element at Key : $key = ${myMap[key]}")    // myMap.get(key)
    }

    /*
    O/P:
            Element at Key : 4 = Yogi
            Element at Key : 43 = Manmohan
            Element at Key : 7 = Vajpayee
    */

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

    /* O/P :
            Element at Key : 4 = yogi
            Element at Key : 7 = Vajpayee
            Element at Key : 43 = Modi
    */

    myMap1.put(14, "MasterBlaster")
    myMap2.put(21, "Dada")

    val myMap4 = mutableMapOf<Int, Any?>()
    myMap4[1] = "Master"
    myMap4[2] = 14
    for (key in myMap4.keys) {
        println("Element at Key : $key = ${myMap4[key]}")    // myMap4.get(key)
    }
    /* O/P :
            Element at Key : 1 = Master
            Element at Key : 2 = 14
    */

    println(myMap4.get(2))              //14
    println(myMap4.getOrDefault(3, "Default Value"))     //Default Value
    println(myMap4.contains(2))         //true      // It doesn't return result
    println(myMap4.contains(14))        //false
    println(myMap4.containsKey(2))      //true      // It returns the result
    println(myMap4.containsKey(14))     //false
    println(myMap4.containsValue(2))    //false
    println(myMap4.containsValue(14))   //true

    for (element in myMap4.asIterable()) {
        //It creates an instance of Iterable interface which wraps the original map returning its entries when being iterated.
        println("key = ${element.key} value = ${element.value}")
    }
    /*  O/P :
            key = 1 value = Master
            key = 2 value = 14
     */

    for (element in myMap4.iterator()) {
        //It returns an Iterator over the entries in the Map.
        println("key = ${element.key} value = ${element.value}")
    }
    /*  O/P :
            key = 1 value = Master
            key = 2 value = 14
     */

    for (element in myMap4.minus(2)) {            //  skip the element
        println(myMap4[element.key])
    }
    // Master


    for (element in myMap4.plus(pair = Pair(4, "blaster"))) {     // Adds the element
        println("Element at key ${element.key} = ${element.value}")
    }
    /*  O/P :
            Element at key 1 = Master
            Element at key 2 = 14
            Element at key 4 = blaster
     */

    println(myMap4)     // {1=Master, 2=14}

    myMap4.replace(2, "Mumbai")
    println(myMap4)     // {1=Master, 2=Mumbai}

    myMap4.put(2, "Delhi")
    println(myMap4)     // {1=Master, 2=Delhi}

    myMap4.set(5, "Pune")  // myMap4[5] = "Pune"
    println(myMap4)     // {1=Master, 2=Delhi, 5=Pune}

    println(myMap4.getOrDefault(0, 0))   //0

    println(myMap4.count())     //3

    println(myMap4.size)    //3

    println(myMap4.containsKey(2))      // true
    println(myMap4.containsValue("Delhi"))  // true

    myMap4.remove(1)
    println(myMap4)     // {2=Delhi, 5=Pune}

    myMap4.remove(2, "Delhi")
    println(myMap4)     // {5=Pune}

    myMap4.clear()
    println(myMap4)     // {}


    //  ********  Set  ********
    //  "Set" contains Unique element
    //  "HashSet" also contains unique element but sequence is not guaranteed in output

    var mySet = setOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)      // Immutable, Fixed Size, READ only

    for (element in mySet) {
        println(element)
    }
    // 2 54 3 1 0 9 8

    var anySet = setOf<Any>(1, 2, 4, 5, 54, 3, 1, 0, 9, 9, 9, 8, "A", "B", "C")

    var mySet1 = mutableSetOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)  // Mutable, No Fixed size, Can Add/Remove elements
    var mySet2 = hashSetOf<Int>(2, 54, 3, 1, 0, 9, 9, 9, 8)       // Mutable, No Fixed size, Can Add/Remove elements

    mySet2.remove(54)
    println(mySet2) // [0, 1, 2, 3, 8, 9]

    mySet2.add(100)
    println(mySet2) // [0, 1, 2, 3, 100, 8, 9]

    println(mySet2.contains(100))   // true

    mySet2.addAll(mySet1)
    println(mySet2) // [0, 1, 2, 3, 100, 54, 8, 9]

    println(mySet2.containsAll(mySet1)) // true

    mySet2.remove(100)
    println(mySet2)     // [0, 1, 2, 3, 54, 8, 9]

    mySet2.removeAll(mySet1)
    println(mySet2)     // []

    println(mySet2.isEmpty())    // true

    println(mySet2.isNotEmpty()) // false

    println(mySet2.any())   // false
    println(anySet.any())   // true

    println(anySet.contains("B"))       // true
    println(anySet.containsAll(mySet1))  // true

    println(anySet.isEmpty())   // false
    println(anySet.isNotEmpty())    // true

    println(anySet)     //  [1, 2, 4, 5, 54, 3, 0, 9, 8, A, B, C]
    var remainingSet = anySet.drop(5)
    println(remainingSet)   // [3, 0, 9, 8, A, B, C]
    println(anySet)     // [1, 2, 4, 5, 54, 3, 0, 9, 8, A, B, C]

    println(anySet.elementAt(3))    // 5
    //println(anySet.elementAt(12))   // java.lang.IndexOutOfBoundsException

    println(anySet.elementAtOrNull(5))  // 3
    println(anySet.elementAtOrNull(12)) // null

    println(anySet)     // [1, 2, 4, 5, 54, 3, 0, 9, 8, A, B, C]

    println(anySet.first()) //1

    println(anySet.indexOf(54)) //4

    println(anySet.drop(4)) //  [54, 3, 0, 9, 8, A, B, C]

    println(anySet) // [1, 2, 4, 5, 54, 3, 0, 9, 8, A, B, C]
}