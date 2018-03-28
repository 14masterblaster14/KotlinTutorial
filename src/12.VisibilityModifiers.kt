// Kotlin Supports :
//                  public
//                  protected
//                  internal    (within module)
//                  private


class TestClass {

    // person.a , person.b are not visible
    // person.c , person.d are visible

    fun testing() {

        var person = Person()
        //println(person.a)
        //println(person.a)
        println(person.c)
        println(person.d)
    }
}

open class Person {

    private val a = 1
    protected val b = 2
    internal val c = 3
    val d = 4           // public by default
}

class Indian : Person() {

    // a is not visible
    // b,c,d are visible

    fun test() {
        //println(a)
        println(b)
        println(c)
        println(d)
    }
}