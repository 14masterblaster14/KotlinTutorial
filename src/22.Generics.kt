fun main(args: Array<String>) {

    var x = A("")
    x.display()

    var y = A(7)
    y.display()

    var z = A(14.14)
    z.display()
}

class A<T>(argument: T) {
    var result = argument

    fun display() {
        println(result)
    }
}