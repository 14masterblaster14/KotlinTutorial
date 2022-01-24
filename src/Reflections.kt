/********************* Reflection ************************/

Reflection is a set of language and library features that provides the feature of introspecting a given program at runtime. 
Kotlin reflection is used to utilize class and its members like properties, functions, constructors, etc. at runtime. 

Unknown Object -> Reflection API -> Modify behaviour of methods, classes, interfaces at runtime

Features:	
			It gives access to properties and nullable types
			Kotlin reflection has some additional features to Java reflection.
			kotlin reflection helps in accessing the JVM code, written by a language 

Class Reference :-
			To obtain, a class reference at runtime which is statically known, use the class reference operator.
			Also, the reference to a class can also be obtained from the instances of the class, such references are known as bounded class references. 
			Using instances, you obtain the reference to the exact type to which the object conforms to, in case of inheritance. 
			e.g.
				// A sample empty class
					class ReflectionDemo {
					}
					
				fun main()
				{
					// Reference obtained using class name
					val abc = ReflectionDemo::class
					println("This is a class reference $abc")			//	This is a class reference class kotlin1.com.programmingKotlin.chapter1.ReflectionDemo
				 
					// Reference obtained using object
					val obj = ReflectionDemo()
					println("This is a bounded class reference ${obj::class}")		//	This is a bounded class reference class kotlin1.com.programmingKotlin.chapter1.ReflectionDemo 
				}	
				
				
Function references :–				
			We can obtain a functional reference to every named function that is defined in Kotlin. This can be done by preceding the function name, with the :: operator. 
			
			e.g.
				fun isDivisibleBy3(a: Int): Boolean{
					return a%3 == 0
				}
				
				fun main(){
					// Function reference obtained using :: operator
					val ref1 = ::isDivisibleBy3
					val array = listOf<Int>(1,2,3,4,5,6,7,8,9)
					println(array.filter(ref1))			//		[3, 6, 9]
				  }
	
	
Property References :–
			We can obtain property reference in a similar fashion as that of function, using the :: operator. 
			If the property belongs to a class than the classname should also be specified with the :: operator. 
			These property references allow us to treat a property as an object that is, we can obtain there values using get function or modify it using set function.
	
			e.g.
				val x = 10;
			
				class Property(var a: Float){
				}
  
				fun main(){
					// Property Reference for a package level property
					val z = ::x
					println(z.get())		//	10
					println(z.name)			//	x	
				  
					// Property Reference for a class property
					val y = Property::a
					println(y.get(Property(5.899f)))	//	5.899
				}
