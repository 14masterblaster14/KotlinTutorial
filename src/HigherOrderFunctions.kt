

Higher-order functions :
						A higher-order function is a function that takes functions as parameters or returns a function.
						Instead of Integer, String or Array as a parameter to function, we will pass anonymous function or lambdas. 
						Frequently, lambdas are passed as parameter in Kotlin functions for the convenience. 

	Passing lambda expression as a parameter to Higher-Order Function –	
						There are two types of lambda expression which can be passed- 
								- Lambda expression which return Unit
								- Lambda expression which return any of the value integer,string etc
								
		Lambda expression which return Unit:
				
				 // lambda expression
					var lambda = {println("Sachin is the best Batsman in the World") }
				// higher-order function
					fun higherfunc( lmbd: () -> Unit ) {     // accepting lambda as parameter
						lmbd()                               //invokes lambda expression
					}
					fun main(args: Array<String>) {
						 //invoke higher-order function
						higherfunc(lambda)                 // passing lambda as parameter
					}										// Sachin is the best Batsman in the World
					
		Lambda expression which returns Integer value:			
				// lambda expression
					var lambda = {a: Int , b: Int -> a + b }
				// higher order function
					fun higherfunc( lmbd: (Int, Int) -> Int) {      // accepting lambda as parameter
							 
						var result = lmbd(2,4)    // invokes the lambda expression by passing parameters                   
						println("The sum of two numbers is: $result")
					}
					 
					fun main(args: Array<String>) {
						higherfunc(lambda)           // passing lambda as parameter 
					}								 // The sum of two numbers is: 6
					
					
					
	Passing function as a parameter to Higher-Order function –
						There are two types of functions which can be passed- 
								- function which return Unit
								- function which return any of the value integer, string etc	
								
		Lambda function which returns Unit:-  		

					// regular function definition
				fun printMe(s:String): Unit{
					println(s)
				}
				   // higher-order function definition
				fun higherfunc( str : String, myfunc: (String) -> Unit){
				   // invoke regular function using local name
					myfunc(str)
				}
				fun main(args: Array<String>) {
					// invoke higher-order function
					higherfunc("Sachin is the best Batsman in the World",::printMe)		// Sachin is the best Batsman in the World
				}		
				
				
				
		Lambda function which returns integer value:-		
		
						 // regular function definition
				fun add(a: Int, b: Int): Int{
					var sum = a + b
					return sum
				}
					// higher-order function definition
				fun higherfunc(addfunc:(Int,Int)-> Int){
					// invoke regular function using local name
					var result = addfunc(3,6)
					print("The sum of two numbers is: $result")
				}
				fun main(args: Array<String>) {
					// invoke higher-order function
					higherfunc(::add)				//	The sum of two numbers is: 9
				}
				
				
				
				
				
	Returning a function from Higher-Order function:


				// function declaration
			fun mul(a: Int, b: Int): Int{
				return a*b
			}
				//higher-order function declaration
			fun higherfunc() : ((Int,Int)-> Int){
				return ::mul
			}
			fun main(args: Array<String>) {
				 // invoke function and store the returned function into a variable
				val multiply = higherfunc() 
				// invokes the mul() function by passing arguments
				val result = multiply(2,4)  
				println("The multiplication of two numbers is: $result")		// The multiplication of two numbers is: 8
			}
			
			
			

Inline Function : 

				higher-order functions or lambda expressions, all stored as an object so memory allocation, for both function objects and classes, and virtual calls might introduce runtime overhead. 
				Sometimes we can eliminate the memory overhead by inlining the lambda expression. 
				In order to reduce the memory overhead of such higher-order functions or lambda expressions, we can use the inline keyword which ultimately requests the compiler to not allocate memory and simply copy the inlined code of that function at the calling place.
				
				Note: Do not inline for bigger functions as it degrades the performance.
					  So basically inline can be used when we wish to reduce memory overhead. 
					  But inline also increases the resulting bytecode. 
					  Which is why, inline usage should be avoided with large functions or accessors with large code logic.
				
			fun higherfunc( str : String, mycall :(String)-> Unit) {
				// inovkes the print() by passing the string str
				mycall(str)
			}
			 
			// main function
			fun main(args: Array<String>) {
				print("GeeskforGeeks: ")
				higherfunc("A Computer Science portal for Geeks",::print)
			}	
				
				
