
/*
*   Unlike Java enums, Kotlin enums are classes.
*   Enum constants aren’t just mere collections of constants- these have properties, methods etc
*   Each of the enum constants acts as separate instances of the class and separated by commas.
*   Enums increases readability of your code by assigning pre-defined names to constants.
*   An instance of enum class cannot be created using constructors.
*
*   Inbuilt properties and functions/methods –
      Properties –
            ordinal: This property stores the ordinal value of the constant, which is usually a zero-based index.
            name: This property stores the name of the constant.
      Methods –
            values: This method returns a list of all the constants defined within the enum class.
            valueOf: This methods returns the enum constant defined in enum, matching the input string. If the constant, is not present in the enum, then an IllegalArgumentException is thrown.
*/

fun main(args: Array<String>) {

  //We can easily access the color of a card using –
  val color = Cards.Diamond.color
  
  // A simple demonstration of properties and methods
    for (day in DAYS.values()) {
        println("${day.ordinal} = ${day.name}")
    }
    println("${DAYS.valueOf(" WEDNESDAY ")}")
    
/* O/P:-
      0 = SUNDAY
      1 = MONDAY
      2 = TUESDAY
      3 = WEDNESDAY
      4 = THURSDAY
      5 = FRIDAY
      6 = SATURDAY
      WEDNESDAY
*/

// A simple demonstration of properties and methods
    for(day in DAYS.values()) {
        println("${day.ordinal} = ${day.name} and is weekend ${day.isWeekend}")
    }
    val today = DAYS.MONDAY;
    println("Is today a weekend ${DAYS.today(today)}")

/* O/P:-
0 = SUNDAY and is weekend true
1 = MONDAY and is weekend false
2 = TUESDAY and is weekend false
3 = WEDNESDAY and is weekend false
4 = THURSDAY and is weekend false
5 = FRIDAY and is weekend false
6 = SATURDAY and is weekend true
Is today a weekend false
*/

// Usage of when expression with enum class –

when(DAYS.SUNDAY){
        DAYS.SUNDAY -> println("Today is Sunday")
        DAYS.MONDAY -> println("Today is Monday")
        DAYS.TUESDAY -> println("Today is Tuesday")
        DAYS.WEDNESDAY -> println("Today is Wednesday")
        DAYS.THURSDAY -> println("Today is Thursday")
        DAYS.FRIDAY -> println("Today is Friday")
        DAYS.SATURDAY -> println("Today is Saturday")
        // Adding an else clause will generate a warning
    }
// Today is Sunday

// Enums as Anonymous Classes –
// calling foo() function override be Summer constant
    Seasons.Summer.foo()  // Hot days of a year
}

enum class DAYS{
  SUNDAY,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}

// Enum Initialization

enum class Cards(val color: String) {
    Diamond("black"),
    Heart("red"),
}

// Enums properties and methods –

// A property with default value provided
enum class DAYS(val isWeekend: Boolean = false){
    SUNDAY(true),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    // Default value overridden
    SATURDAY(true);
   
    companion object{
        fun today(obj: DAYS): Boolean {
            return obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
        }
    }
}

// Enums as Anonymous Classes

// defining enum class
enum class Seasons(var weather: String) {
    Summer("hot"){
        // compile time error if not override the function foo()
        override fun foo() {              
            println("Hot days of a year")
        }
    },
    Winter("cold"){
        override fun foo() {
            println("Cold days of a year")
        }
    },
    Rainy("moderate"){
        override fun foo() {
            println("Rainy days of a year")
        }
    };
    abstract fun foo()
}

// Enum Classes

enum class MobileColor(val value: Int) {
    GOLD(0xffd323),
    SILVER(0xeaeaea),
    WHITE(0xffffff),
    BLACK(0x000000),
    RED(0xFF0000)
}
