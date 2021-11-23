/*

    Refer : https://stackoverflow.com/questions/49169086/sealed-class-vs-enum-when-using-associated-type
    Enum Class Vs Sealed Class 
    
    
    * Properties :
                In enum classes, each enum value cannot have its own unique property. You are forced to have the same property for each enum value.
                In case of sealed classes, we can have different properties for each subtype.
    
    * Functions :
                Enums can have abstract functions as well as regular functions. But like properties, each enum value also has to have the same function.
                In sealed classes we can have different functions for different subtypes.
    
    * Inheritance:
                Since enum values are objects, they cannot be extended.
                Since sealed class' subtypes are types, they can be extended.
                
    * Number of Instances:
                Since enum values are objects and not types, we cannot create multiple instances of them.
                Subtypes of sealed classes are types, so we can create multiple instances of these types. We can also make a type to have only a single instance using an object declaration
    
    * Serializable and Comparable:
                Every enum class in Kotlin is implicitly extended by the abstract class java.lang.Enum. So, all the enum values automatically have the implementations for equals(), toString(), hashCode(), Serializable and Comparable. We don't have to define them.
                For sealed classes we need to define them manually or use data class for the automatic equals(), toString() and hashcode() and then implement Serializable and Comparable manually.

    * Performance
                Enums don't get garbage collected, they stay in memory for the lifespan of your app. This can be an upside or a downside.
                Sealed classes are just regular classes with the only exception that they need to be extended in the same package and the same compilation unit. So, their performance is equivalent to regular classes.


*** Detailed Explaination ***

Properties
Enum

In enum classes, each enum value cannot have its own unique property. You are forced to have the same property for each enum value:

enum class DeliveryStatus(val trackingId: String?) {
    PREPARING(null),
    DISPATCHED("27211"),
    DELIVERED("27211"),
}
Here we need the trackingId only for the DISPATCHED and DELIVERED, the PREPARING is forced to have a null value.

Sealed Class

In case of sealed classes, we can have different properties for each subtype:

sealed class DeliveryStatus
class Preparing() : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
class Delivered(val trackingId: String, val receiversName: String) : DeliveryStatus()
Here we have different properties for each subtype. Preparing doesn't need properties for our use case, so we have the flexibility to not specify any property unlike forced null values in enums. Dispatched has one property while the Delivered has two properties.

Considering the example Color(val value: Int) in the question, you have a common value: Int property for all constants and since you don't need different properties for different constants, you should use enums in this case.

Functions
Enum

Enums can have abstract functions as well as regular functions. But like properties, each enum value also has to have the same function:

enum class DeliveryStatus {
    PREPARING {
        override fun cancelOrder() = println("Cancelled successfully")
    },
    DISPATCHED {
        override fun cancelOrder() = println("Delivery rejected")
    },
    DELIVERED {
        override fun cancelOrder() = println("Return initiated")
    };

    abstract fun cancelOrder()
}
In this example, we have an abstract function cancelOrder() that we have to override in each enum value. That means, we can't have different functions for different enum values.

Usage:

class DeliveryManager {
    fun cancelOrder(status: DeliveryStatus) {
        status.cancelOrder()
    }
}
Sealed Class

In sealed classes we can have different functions for different subtypes:

sealed class DeliveryStatus

class Preparing : DeliveryStatus() {
    fun cancelOrder() = println("Cancelled successfully")
}

class Dispatched : DeliveryStatus() {
    fun rejectDelivery() = println("Delivery rejected")
}

class Delivered : DeliveryStatus() {
    fun returnItem() = println("Return initiated")
}
Here we have different functions: cancelOrder() for Preparing, rejectDelivery() for Dispatched and returnItem() for Delivered. This makes the intent clearer and makes the code more readable, also we have the option of not having the function, in case we don't want to.

Usage:

class DeliveryManager {
    fun cancelOrder(status: DeliveryStatus) = when(status) {
        is Preparing -> status.cancelOrder()
        is Dispatched -> status.rejectDelivery()
        is Delivered -> status.returnItem()
    }
}
If we want a common function for all subtypes like in the enum example, we can have that in sealed class by defining it in the sealed class itself and then overriding it in the subtypes:

sealed class DeliveryStatus {
    abstract fun cancelOrder()
}
The advantage of having a common function for all types is that we don't have to type check using the is operator. We can simply use polymorphism as shown in the DeliveryManager class of enum example.

Inheritance
Enum

Since enum values are objects, they cannot be extended:

class LocallyDispatched : DeliveryStatus.DISPATCHED { }    // Error
The enum class is implicitly final, so it cannot be extended by other classes:

class FoodDeliveryStatus : DeliveryStatus() { }            // Error
Enum classes cannot extend other classes, they can only extend interfaces:

open class OrderStatus { }
interface Cancellable { }

enum class DeliveryStatus : OrderStatus() { }              // Error
enum class DeliveryStatus : Cancellable { }                // OK
Sealed Class

Since sealed class' subtypes are types, they can be extended:

class LocallyDispatched : Dispatched() { }                 // OK
The sealed class itself can be extended, of course!:

class PaymentReceived : DeliveryStatus()                   // OK
Sealed classes can extend other classes as well as interfaces:

open class OrderStatus { }
interface Cancellable { }

sealed class DeliveryStatus : OrderStatus() { }           // OK
sealed class DeliveryStatus : Cancellable { }             // OK
Number of Instances
Enum

Since enum values are objects and not types, we cannot create multiple instances of them:

enum class DeliveryStatus(val trackingId: String?) {
    PREPARING(null),
    DISPATCHED("27211"),
    DELIVERED("27211"),
}
In this example, DISPATCHED is an object and not a type, so it can exist only as a single instance, we can't create more instances from it:

// Single instance
val dispatched1 = DeliveryStatus.DISPATCHED               // OK

// Another instance
val dispatched2 = DeliveryStatus.DISPATCHED("45234")      // Error
Sealed Class

Subtypes of sealed classes are types, so we can create multiple instances of these types. We can also make a type to have only a single instance using an object declaration:

sealed class DeliveryStatus
object Preparing : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
data class Delivered(val receiversName: String) : DeliveryStatus()
In this example, we can create multiple instances of Dispatched and Delivered. Notice that we have utilised the ability of the subtypes of the sealed class to be as a singleton object, a regular class or a data class. Preparing can can have only a single object, just like an enum value:

// Multiple Instances
val dispatched1 = Dispatched("27211")                     // OK
val dispatched2 = Dispatched("45234")                     // OK

// Single Instance
val preparing1 = Preparing                                // OK
val preparing2 = Preparing()                              // Error
Notice also that in the code above, each instance of Dispatched can have a different value for the trackingId property.

Serializable and Comparable
Enum

Every enum class in Kotlin is implicitly extended by the abstract class java.lang.Enum. So, all the enum values automatically have the implementations for equals(), toString(), hashCode(), Serializable and Comparable. We don't have to define them.

Sealed Class

For sealed classes we need to define them manually or use data class for the automatic equals(), toString() and hashcode() and then implement Serializable and Comparable manually.

Performance
Enum

Enums don't get garbage collected, they stay in memory for the lifespan of your app. This can be an upside or a downside.

Garbage collection process is expensive. The same is true for object creation, we don't want to create the same objects again and again. So, with enums, you save the cost of garbage collection as well as object creation. This is the upside.

The downside is that the enums stay in memory even when they are not in use, this can keep the memory occupied all the time.

You don't need to worry about all this, if you have 100 to 200 enums in your app. But when you have more than that, you have a decision to make whether you should go for enums depending on the facts such as the number of enums, whether they will be in use all the time and the amount of memory allocated to your JVM.

The comparison of enum values is faster in the when expression because under the hood, it uses tableswitch to compare the objects. So, for the example given in the question, enums should be preferred as they will be faster in this case.

In Android, when the optimization is enabled, the Proguard converts the enums that don't have functions and properties to integers, so you get the type-safety of the enums at compile-time and the performance of the ints at runtime!

Sealed Class

Sealed classes are just regular classes with the only exception that they need to be extended in the same package and the same compilation unit. So, their performance is equivalent to regular classes.

Objects of the subtypes of the sealed classes get garbage collected like the objects of regular classes. So, you have to bear the cost of garbage collection as well as object creation.

When you have the low memory constraints, you may consider using sealed classes instead of enums, if you need thousands of objects. Because the garbage collector can free up the memory when the objects are not in use.

If you use object declaration for extending the sealed class, the objects act as singletons and they won't be garbage collected, just like enums.

The comparison of sealed class' types is slower in when expression because under the hood it uses instanceof to compare the types. The speed difference between enums and sealed classes, in this case, is very little though. It matters only when you are comparing thousands of constants in a loop.


*/
