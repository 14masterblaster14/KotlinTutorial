
/**
Lambda Expression – A function without name is called anonymous function. 
					For lambda expression we can say that it is anonymous function.
					
		Syntax of Lambda expression – 

					val lambda_name : Data_type = { argument_List -> code_body }
**/				
		e.g.
					// with type annotation in lambda expression
					val sum1 = {a: Int , b: Int -> a + b}
					
					// without type annotation in lambda expression
					val sum2:(Int,Int) -> Int = { a, b -> a + b}
					
					fun main(args: Array<String>) {
							val result1 = sum1(2,3)
							val result2 = sum2(3,4)
							println("The sum of two numbers is: $result1")		// The sum of two numbers is: 5
							println("The sum of two numbers is: $result2")		// The sum of two numbers is: 7
						 
							// directly print the return value of lambda
							// without storing in a variable.
							println(sum1(5,7))					// 12
						}
						
						
/*						
		Type declaration in lambdas –
							We must explicitly declare the type of our lambda expression. If lambda returns no value then we can use: Unit 
							Pattern: (Input) -> Output
*/							
				e.g.	
							val lambda1: (Int) -> Int = (a -> a * a)
							val lambda2: (String,String) -> String = { a , b -> a + b }
							val lambda3: (Int)-> Unit = {print(Int)}			
							
		//Lambdas can be used as class extension:  	
		
							val lambda4: String.(Int) -> String = {this + it} //  this keyword is used for the string and it keyword is used for the Int parameter passed in the lambda
							
							val result = "Geeks".lambda4(50)
							print(result)		// Geeks50
							
							
		//it: implicit name of a single parameter –

							val numbers = arrayOf(1,-2,3,-4,5)
							// shorthand form of lambda function –
							println(numbers.filter {  it > 0 })				//[1, 3, 5] 
							//  longhand form of lambda function –
							println(numbers.filter {item -> item > 0 })		//[1, 3, 5] 
							
		//Returning a value from lambda expression –		

					
							val find =fun(num: Int): String{
							if(num % 2==0 && num < 0) {
								return "Number is even and negative"
							   }
								else if (num %2 ==0 && num >0){
								return "Number is even and positive"
								}
								else if(num %2 !=0 && num < 0){
								return "Number is odd and negative"
								}
								else {
								return "Number is odd and positive"
								}
							}
					
							val result = find(112)
							println(result)		// Number is even and positive
							
							
					
					
/*					
Anonymous Function : 		
						An anonymous function is very similar to regular function except for the name of the function which is omitted from the declaration. 
						The body of the anonymous function can be either an expression or block.
								
								Function body as an expression : 
								
									fun(a: Int, b: Int) : Int = a * b
*/									
								//Function body as a block :
								
									fun(a: Int, b: Int): Int {
											val mul = a * b
											return mul
										}		
							
							
						e.g.

							// anonymous function with body as an expression
								val anonymous1 = fun(x: Int, y: Int): Int = x + y
								 
							// anonymous function with body as a block
								val anonymous2 = fun(a: Int, b: Int): Int {
											val mul = a * b
											return mul
											}

							//invoking functions
							val sum = anonymous1(3,5)
							val mul = anonymous2(3,5)
							println("The sum of two numbers is: $sum")			//	The sum of two numbers is: 8
							println("The multiply of two numbers is: $mul")		//	The multiply of two numbers is: 15
/*							
			Return type and parameters- 

						The return type and parameters are also specified in same way as for regular function but we can omit the parameters if they can be inferred from the context.
						The return type of the function can be inferred automatically from the function if it is an expression and has to be specified explicitly for the anonymous function if it is body block.
								
								
	
Difference between lambda expressions and anonymous functions :-	
						The only difference is the behavior of non-local returns. 
						A return statement without a label always returns from the function declared with the fun keyword. 
						This means that a return inside a lambda expression will return from the enclosing function, 
						whereas a return inside an anonymous function will return from the anonymous function itself.
						
						//Refer : https://stackoverflow.com/questions/48112081/why-does-kotlin-have-two-syntaxes-for-lambdas-anonymous-functions
*/						
						//The key reason is the support for returns from lambdas. The rule for returns is that the return keyword returns from the nearest function declared with the fun keyword. In some scenarios, you want a return in a block of code to return from the enclosing function, so you use a lambda:

						fun processElements(list: List<Element>): Boolean {
							 list.forEach { element ->
								  if (!element.process()) return false   // returns from processElements()
							 }
							 return true
						}
						
          //In other scenarios, you want to return from the block but not from the enclosing function. When using a lambda, returning from the block requires the return@label syntax, which is somewhat clunky:

						fun processElements(list: List<Element>) {
							 list.forEach { element ->
								  if (!needToProcessElement(element)) return@forEach // returns from block
								  element.process()
							 }
						}
						//To avoid the clunkiness, we've provided an alternative syntax - anonymous functions - which allows you to use return directly to return from the block:

						fun processElements(list: List<Element>) {
							list.forEach(fun(element) { 
								if (!needToProcessElement(element)) return // returns from block
								element.process()
							})
						}
						//A secondary reason is that it's indeed impossible to fit the return type declaration into the syntax of a lambda, but this is very rarely needed in practice, so it's not particularly important.
	
