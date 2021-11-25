Equality :	<<https://agrawalsuneet.github.io/blogs/equality-in-kotlin/>>>

			Structural Equality (‘==’):
							== operator is used to compare the data of two variables.
							Please don’t misunderstand this equality operator with the Java == operator as both are different.
							== operator in Kotlin only compares the data or variables, whereas in Java or other languages == is generally used to compare the references.
							The negated counterpart of == in Kotlin is != which is used to compare if both the values are not equal to each other.

			Referential equality (‘===’):
							=== operator is used to compare the reference of two variable or object. 
							It will only be true if both the objects or variables pointing to the same object. 
							The negated counterpart of === in Kotlin is !== which is used to compare if both the values are not equal to each other. 
							For values which are represented as primitive types at runtime (for example, Int), the === equality check is equivalent to the == check.
							
			.equals method :
							equals(other: Any?) method is implemented in Any class and can be overridden in any extending class. 
							.equals method also compares the content of the variables or objects just like == operator but it behaves differently in case of Float and Double comparison.
							
							
			=> two primitive type Int variables by all the equal checks. 

							val int1 = 10
							val int2 = 10

							println(int1 == int2)        // true
							println(int1.equals(int2))   // true
							println(int1 === int2)       // true
							
							primitive datatype only checks the value in case of === also which will be equal
							
			=>  wrapper class instead of Primitive datatype and compare all three equal checks.
							val first = Integer(10)
							val second = Integer(10)

							println(first == second)       //true
							println(first.equals(second))  //true
							println(first === second)      //false
							
							the == and .equals prints true because they compare only values whereas === compares the references of the objects which were different so it prints false

							
			=> custom class object and compared with all three checks.
														
							class Employee (val name: String)
							val emp1 = Employee(“Suneet”)
							val emp2 = Employee(“Suneet”)

							println(emp1 == emp2)      //false
							println(emp1.equals(emp2)) //false
							println(emp1 === emp2)     //false

							println(emp1.name == emp2.name)       //true
							println(emp1.name.equals(emp2.name))  //true
							println(emp1.name === emp2.name)      //true
							
							As Empoyee is not a primitive datatype or wrapper class, all three compared the references, which returns false for all three checks. 
							But in the case of string comparison, if only checks the contents of the string which were equal so it returns true for every case.
							
							Wait, but you said == and .equals only compares the contents of the object which were equal in our case.
							Exactly. But the content comparison only works if its a data class. 
							If it’s a normal class the compiler consider both the objects as the different objects even if the content is same but if its a data class, the compiler compares the data and return true if the content is same.
							
							data class Employee (val name: String)
							val emp1 = Employee("Suneet")
							val emp2 = Employee("Suneet")

							println(emp1 == emp2)         //true
							println(emp1.equals(emp2))    //true
							println(emp1 === emp2)        //false

							println(emp1.name == emp2.name)      //true
							println(emp1.name.equals(emp2.name)) //true
							println(emp1.name === emp2.name)     //true
