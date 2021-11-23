/*     **-- Generics --**  

Variance is of two types-

Declaration-site variance(using in and out)
Use-site variance: Type projection

*/




fun main(args: Array<String>) {

    var x = A("")
    x.display()         // 

    var y = A(7)
    y.display()        // 7

    var z = A(14.14)
    z.display()         // 14.14
}

class A<T>(argument: T) {
    var result = argument

    fun display() {
        println(result)
    }
}

// In (contravariance type),  Out (covariant type) and Invariant Type

//  Out (covariant type) :
//          If your generic class only use the generic type as output of it’s function/s, then out is used.

interface Production<out T> {
    fun produce(): T
}

//  In (contravariance type) :
//          If your generic class only use the generic type as input of it’s function/s, then in is used.

interface Consumer<in T> {
    fun consume(item: T)
}

//  Invariant Type  :
//          In the event one generic class uses the generic type as input and output to it’s function,
//          then no in or out is used. It is invariant.

interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}

// e.g.

open class Food
open class FastFood : Food()
class Burger : FastFood()

class FoodStore : Production<Food> {
    override fun produce(): Food {
        println("Produce Food")
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun produce(): FastFood {
        println("Produce FastFood")
        return FastFood()
    }
}

class InOutBurger : Production<Burger> {
    override fun produce(): Burger {
        println("Produce Burger")
        return Burger()
    }
}

val production1: Production<Food> = FoodStore()
val production2: Production<Food> = FastFoodStore()
val production3: Production<Food> = InOutBurger()

//val production4 : Production<Burger> = FoodStore()  // Error
//val production5 : Production<Burger> = FastFoodStore()  // Error
val production6: Production<Burger> = InOutBurger()


class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println("Eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat fast food")
    }
}

class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        println("Eat burger")
    }
}

val consumer1: Consumer<Burger> = Everybody()
val consumer2: Consumer<Burger> = ModernPeople()
val consumer3: Consumer<Burger> = American()

val consumer4: Consumer<Food> = Everybody()
//val consumer5 : Consumer<Food> = ModernPeople()  // Error
//val consumer6 : Consumer<Food> = American()  // Error

class X : ProductionConsumer<Food> {
    override fun produce(): Food {
        println("Produce Food")
        return Food()
    }

    override fun consume(item: Food) {
        println("Eat food")
    }
}

class Y : ProductionConsumer<FastFood> {
    override fun produce(): FastFood {
        println("Produce FastFood")
        return FastFood()
    }

    override fun consume(item: FastFood) {
        println("Eat fastFood")
    }
}

class Z : ProductionConsumer<Burger> {
    override fun produce(): Burger {
        println("Produce Burger")
        return Burger()
    }

    override fun consume(item: Burger) {
        println("Eat Burger")
    }
}

val productionConsumer1: ProductionConsumer<Food> = X()
//val productionConsumer2 : ProductionConsumer<Food> = Y()
//val productionConsumer3 : ProductionConsumer<Food> = Z()

//val productionConsumer4 : ProductionConsumer<FastFood> = X()
val productionConsumer5: ProductionConsumer<FastFood> = Y()
//val productionConsumer6 : ProductionConsumer<FastFood> = Z()

//val productionConsumer7 : ProductionConsumer<Burger> = X()
//val productionConsumer8 : ProductionConsumer<Burger> = Y()
val productionConsumer9: ProductionConsumer<Burger> = Z()
