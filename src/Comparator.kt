/********************* Comparator ************************/

In ordering instances two values/objects can be compared automatically.
But since the order of an object can vary according to various parameters, Kotlin provides a simple Comparator interface. 
This interface compares two objects of a type and arranges them in an order.

compare:	abstract fun compare(a: T, b: T): Int

			This function compares two instance of a type and returns 
				zero if both are equal, 
				a negative number if second instance is bigger 
				otherwise returns a positive number.
				
Extension Functions –

		1)	reversed:	
						This function takes a comparator as an argument and returns the comparator with the ordering reversed as that of the passed comparator.
						
						fun <T> Comparator<T>.reversed(): Comparator<T>
						
		2)	then: 
						This function combines two comparator, and the second one is used only when the values are equal according to the first comparator.			
				
						infix fun <T> Comparator<T>.then(
								comparator: Comparator<in T>
							): Comparator<T>
e.g.

				// A simple class to represent a name
				class Name(val firstName: String,val lastName: String){
					override fun toString(): String {
						return """$firstName $lastName"""
					}
				}
				   
				// A comparator to compare first names of Name
				class ComparatorOne: Comparator<Name>{
					override fun compare(o1: Name?, o2: Name?): Int {
						if(o1 == null || o2 == null){
							return 0;
						}
						return o1.firstName.compareTo(o2.firstName)
					}
				}
				   
				// A comparator to compare last names of Name
				class AnotherComparator: Comparator<Name>{
					override fun compare(o1: Name?, o2: Name?): Int {
						if(o1 == null || o2 == null)
							return 0
						return o1.lastName.compareTo(o2.lastName)
					}
				}				
				
				
				fun main(){
								val list = ArrayList<Name>()
								list.add(Name("Steve","Waugh"))
								list.add(Name("Steve","Smith"))
								list.add(Name("Virat","Kohli"))
								list.add(Name("Kane","Williamson"))
								list.add(Name("Joe","Root"))
							   
								println("The list is:")
								println(list)							//	[Steve Waugh, Steve Smith, Virat Kohli, Kane Williamson, Joe Root]
							   
								val comparatorOne = ComparatorOne()
								// Sorting list according to first names
								list.sortWith(comparatorOne)
								println("List sorted according to first name")
								println(list)							//	[Joe Root, Kane Williamson, Steve Waugh, Steve Smith, Virat Kohli]
							   
								val anotherComparator = AnotherComparator()
								val finalComparator = comparatorOne.then(anotherComparator)
								// Sorting list according to first name then by last name
								list.sortWith(finalComparator)
								println("List sorted according to first name and last name")
								println(list)							//	[Joe Root, Kane Williamson, Steve Smith, Steve Waugh, Virat Kohli]
							   
								val reverseComparator = finalComparator.reversed()
								// Reverse sorting the list
								list.sortWith(reverseComparator)
								println("List reverse sorted")
								println(list)							//	[Virat Kohli, Steve Waugh, Steve Smith, Kane Williamson, Joe Root]
							}
							
							
		3)	thenBy: 
					This function converts the type instances to an instance of type Comparable and then compares them using these instances.

					fun <T> Comparator<T>.thenBy(
						selector: (T) -> Comparable<*>?
					): Comparator<T>					
					
					
		4)	thenByDescending: 
					This function returns a descending comparator which converts a value into an instance of type Comparable and then compares the instances.

					inline fun <T> Comparator<T>.thenByDescending(
						crossinline selector: (T) -> Comparable<*>?
					): Comparator<T>	

		e.g.
		
			class Person(val height: Int,val weight: Int){
				override fun toString(): String {
					return "Height = ${height}, Weight = ${weight}"
				}
			}
			   
			fun main() {
				val comparator = compareBy<Person> { it.height }
				val list = listOf<Person>(
					Person(4, 10),
					Person(2, 10),
					Person(3, 45),
					Person(3, 25),
					Person(7, 95),
					Person(5, 50)
				)
			   
				println("Sorted first according to height then by weight")
				val anotherComparator = comparator.thenBy { it.weight }
				println(list.sortedWith(anotherComparator))				//	[Height = 2, Weight = 10, Height = 3, Weight = 25, Height = 3, Weight = 45, Height = 4, Weight = 10, Height = 5, Weight = 50, Height = 7, Weight = 95]
			   
				println("Sorted first according to weight then by descending order in height")
				val comparator2 = compareBy<Person> { it.weight }.thenByDescending { it.height }
				println(list.sortedWith(comparator2))					//	[Height = 4, Weight = 10, Height = 2, Weight = 10, Height = 3, Weight = 25, Height = 3, Weight = 45, Height = 5, Weight = 50, Height = 7, Weight = 95]

			}
					
					
		5)	thenComparator: 
					This function returns a Comparator which uses the primary Comparator along with a function to perform a comparison.

				fun <T> Comparator<T>.thenComparator(
					comparison: (a: T, b: T) -> Int
				): Comparator<T>
				 
		6)	thenDescending: 
						This function combines two comparator, and the second one is used only when the values are equal according to the first comparator, and sorts the elements in descending order.

				infix fun <T> Comparator<T>.thenDescending(
					comparator: Comparator<in T>
				): Comparator<T>			
				
				
		e.g.

			fun main(){
						val list = listOf<Pair<String,Int>>(
							Pair("A",3),
							Pair("B",1),
							Pair("G",345),
							Pair("E",20),
							Pair("A",0),
							Pair("J",0)
						)
					   
						val comparator = compareBy<Pair<String,Int>> { it.first }
							.thenComparator({a,b -> compareValues(a.second,b.second)})
					   
						println("Pairs sorted by String then by Integers")
						println(list.sortedWith(comparator))				//	[(A, 0), (A, 3), (B, 1), (E, 20), (G, 345), (J, 0)]
					   
						val anotherComparator = compareBy<Pair<String,Int>> { it.second }
						val anotherComparator2 = compareBy<Pair<String,Int>>{it.first}
						println("Pairs sorted by Integers then by Strings in Descending order")
						println(list.sortedWith(anotherComparator.thenDescending(anotherComparator2)))	//	[(J, 0), (A, 0), (B, 1), (A, 3), (E, 20), (G, 345)]
					}
