Pair and Triple :
		Function return only one value at a time.
		If there is need to return more than one value of different data type, then we can create a class and declare all the variables that we want to return from the function and after that create an object of the class and easily collect all the returned values in a list.
	
		Pair :- 
				A simple datatype to store two values in a single instance. 
				This can be done using a data class known as Pair. 
				It is a simple generic class that can store two values of same or different data types, and there can or can not be a relationship between the two values. 
				The comparison between two Pair objects is done on the basis of values, i.e. two Pair objects are equal if their values are equal.
				
				Pair(first: A, second: B)
				
				e.g.
					// Retrieve the values of Pair 
					
						// values of pair in a single variable
						val (x, y) = Pair(1, "MasterBlaster")
						println(x)  //	1
						println(y)	//	MasterBlaster
						
						// using first and second properties 
						var pair = Pair("Hello World", "This is Kotlin tutorial")
						println(pair.first)		// Hello World
						println(pair.second)	// This is Kotlin tutorial
						
						println(pair.component1())
						println(pair.component2())
						
				   // toString(): This function returns the string equivalent of the Pair.

						val obj = Pair(5,5)
						println("String representation is "+obj.toString())				// String representation is (5, 5)
						val pair = Pair("Geeks", listOf("Praveen", "Gaurav", "Abhi"))
						print("Another string representation is "+pair.toString())		// Another string representation is (Geeks, [Praveen, Gaurav, Abhi])
						
				  // toList() : This is an extension function returns the List equivalent of the given Pair.
						
						var obj = Pair(1,2)
						val list1: List<Any> = obj.toList()
						println(list1)							//	[1, 2]
						// second pair
						var obj2 = Pair("Hello","Geeks")
						val list2: List<Any> = obj2.toList()
						println(list2)							// [Hello, Geeks]
						
				// Copy	

						val pair = Pair("I am a String", listOf(1,2,3))
						print(pair)
							
						val anotherPair = pair.copy(first = "I am new String")
						print(anotherPair)
						
		Triple :- 
				A simple datatype to store three values in a single instance. 
				This can be done using a data class known as Triple. 
				It is a simple generic class that stores any three values, there is no valuable meaning of the relationship between the three values. 
				The comparison between two Triple objects is done on the basis of values, i.e. two Triples are equal only if all three components are equal.
				
				Triple(first: A, second: B, third: C)
				
				e.g.
					// Retrieve the values of Pair 
						// declare triple
						var triple = Triple("Hello Geeks", "This is Kotlin tutorial", listOf(10, 20, 30))
						println(triple.first)	//	Hello Geeks
						println(triple.second)	// 	This is Kotlin tutorial
						println(triple.third)	// [10, 20, 30]
						
						println(triple.component1())	//	Hello Geeks
						println(triple.component2())	// 	This is Kotlin tutorial
						println(triple.component3())	// [10, 20, 30]
						
					// toString(): This function returns the string equivalent of the Triple.	
					
						// first triple
						val triple = Triple(5, 5, 5)
						println("String representation is "+triple.toString())		// String representation is (5, 5, 5)
						 
						  // second triple
						val triple2 = Triple("Geeks", listOf("Praveen", "Gaurav", "Abhi"), 12345)
						print("Another string representation is "+ triple2.toString())	// Another string representation is (Geeks, [Praveen, Gaurav, Abhi], 12345)
						
					// toList() : This is an extension function returns the List equivalent of the given Triple.

						// first triple
						var obj = Triple(1, 2, 3)
						val list1: List<Any> = obj.toList()
						println(list1)		// [1, 2, 3]
						 
						  // second triple
						var obj2 = Triple("Hello", 2.0000 ,listOf(10, 20, 30))
						val list2: List<Any> = obj2.toList()
						println(list2)		// [Hello, 2.0, [10, 20, 30]]
						
						
					// Copy	

						var triple1 = Triple("Hello", 2.0000 ,listOf(10, 20, 30))
						print(triple1)
							
						val triple2 = triple1.copy(first = "I am new String")
						print(triple2)	
