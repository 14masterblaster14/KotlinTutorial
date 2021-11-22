// Kotlin Supports :
//                  public
//                  protected   (accessible by derived class,
//                               that to inside the derived class and not from outside)
//                  internal    (within module)
//                  private

// Constructor Visibility
   // By default constructors are public, but we can also change the visibility of a constructor by using the modifiers. 
   // e.g.
             //   class A private constructor (name : String) {
            // other code
            //     }


fun main(Args: Array<String>) {


    // person.a , person.b are not visible
    // person.c , person.d are visible


    var person = Person()
    // println(person.a)        // Cannot Access a as it's a private
    // println(person.b)        // Cannot Access B as it's a protected
    println(person.c)           //   3
    println(person.d)           //   4

    var indian = Indian()
    // println(indian.a)        // Cannot Access a as it's a private
    // println(indian.b)        // Cannot Access B from outside as it's a protected,
    // but can be access from inside
    println(indian.c)           // 3
    println(indian.d)           // 4

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
        // println(a)    // Cannot Access a as it's a private
        println(b)
        println(c)
        println(d)
    }
}
