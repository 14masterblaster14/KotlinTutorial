/*
   RegEx :
          -   Regular Expression, is a sequence of characters that forms a search pattern.
          -   RegEx can be used to check if a string contains the specified search pattern.
          -   Python has a built-in package called re, which can be used to work with
              Regular Expressions.
   Functions :

              Function	        Description

              findall	        Returns a list containing all matches
              search	        Returns a Match object if there is a match anywhere in the string
              split	            Returns a list where the string has been split at each match
              sub	            Replaces one or many matches with a string

   Metacharacters :
             Character	    Description	                                    Example

             []	            A set of characters	                            "[a-m]"
             \	            Signals a special sequence
                           (can also be used to escape special characters)	"\d"
             .	            Any character (except newline character)	    "he..o"
             ^	            Starts with	                                    "^hello"
             $	            Ends with	                                    "world$"
             *	            Zero or more occurrences	                    "aix*"
             +	            One or more occurrences	                        "aix+"
             {}	            Exactly the specified number of occurrences	    "al{2}"
             |	            Either or	                                    "falls|stays"
             ()	            Capture and group


  Special Sequences :  A special sequence is a \ followed by one of the characters in the list below,
                       and has a special meaning.

  Character    Description	                                                                    Example

  \A	        Returns a match if the specified characters are at the beginning of the string	"\AThe"
  \b	        Returns a match where the specified characters are at the beginning
               or at the end of a word	    r"\bain"
                                                                                                r"ain\b"
  \B	        Returns a match where the specified characters are present,
                but NOT at the beginning (or at the end) of a word	                            r"\Bain"
                                                                                                r"ain\B"
  \d	        Returns a match where the string contains digits (numbers from 0-9)	            "\d"
  \D	        Returns a match where the string DOES NOT contain digits	                    "\D"
  \s	        Returns a match where the string contains a white space character	            "\s"
  \S	        Returns a match where the string DOES NOT contain a white space character	    "\S"
  \w	        Returns a match where the string contains any word characters
                (characters from a to Z,digits from 0-9, and the underscore _ character)	    "\w"
  \W	        Returns a match where the string DOES NOT contain any word characters	        "\W"
  \Z	        Returns a match if the specified characters are at the end of the string	    "Spain\Z"


   Sets : A set is a set of characters inside a pair of square brackets [] with a special meaning:

            Set	         Description
           [arn]	     Returns a match where one of the specified characters (a, r, or n) are present
           [a-n]	     Returns a match for any lower case character, alphabetically between a and n
           [^arn]	     Returns a match for any character EXCEPT a, r, and n
           [0123]	     Returns a match where any of the specified digits (0, 1, 2, or 3) are present
           [0-9]	     Returns a match for any digit between 0 and 9
           [0-5][0-9]	 Returns a match for any two-digit numbers from 00 and 59
           [a-zA-Z]	     Returns a match for any character alphabetically between a and z,
                         lower case OR upper case
           [+]	         In sets, +, *, ., |, (), $,{} has no special meaning,
                         so [+] means: return a match for any + character in the string


    //      Symbols
    //  Symbol      Meaning
        ^expr       Matches expr at beginning of the line
        expr$       Matches expr at end of line
        .           Matches any single character (exception the newline character)
        [xyz]       Matches either x, y, or z
        [p-z]       Specifies a range. Matches any character from p to z
        [p-z1-9]    Matches either any character from p to z or any digit from 1 to 9
        [^p-z]      '^' as the first character negates the pattern.
                    This will match anything outside of the range p-z
        xy          Matches x followed by y
        x|y         Matches either x or y

    //      Meta Symbols
    //  Symbol      Meaning
        \d          Matches digits ([0-9])
        \D          Matches non-digits
        \w          Matches word characters
        \W          Matches non-word characters
        \s          Matches whitespaces [\t\r\f\n]
        \S          Matches non-whitespaces
        \b          Matches word boundary when outside of a bracket.
                    Matches backslash when placed in a bracket
        \B          Matches non-word boundary
        \A          Matches beginning of string
        \Z          Matches end of String

    //      Quantifiers
    //  Quantifier  Meaning
        expr?       Matches 0 or 1 occurrence of expr (expr{0,1})
        expr*       Matches 0 or more occurrences of expr (expr{0,})
        expr+       Matches 1 or more occurrences of expr (expr{1,})
        expr{x, y}  Matches between x and y occurrences of expr
        expr{x, }   Matches x or more occurrences of expr

*/

fun main(args: Array<String>) {

    /*
    //  Constructors :–

    <init>(pattern: String):
            This constructor creates a regular expression based on the pattern string.

    <init>(pattern: String, option: RegexOption):
            This constructor creates a regular expression based on the specified pattern and the option.
            The option is a constant of RegexOption enum class.

    <init>(pattern: String, options: Set<RegexOption>):
            This constructor creates a regular expression on the basis of the specified string pattern
            and the set of options specified in the set.

    //  Properties :–

    val options: Set<RegexOption> :
            It contains the set of options which are to be used at the time of regex creation.

    val pattern: String :
            It contains the string describing the pattern.
 */

    //Regex Functions :–

    // containsMatchIn() :–
    //              fun containsMatchIn(input: CharSequence): Boolean
    //      This function returns a boolean indicating whether there exists any match of our pattern in the input.

    //val pattern = Regex("^a")   // Regex to match any string starting with 'a'
    //          OR
    val pattern = """^a""".toRegex()   // Regex to match any string starting with 'a'
    println(pattern.containsMatchIn("abc"))     // true
    println(pattern.containsMatchIn("bac"))     // false

    //  find() :-
    //              fun find(input: CharSequence, startIndex: Int): MatchResult?
    //      This function returns the first matched substring pertaining to our pattern in the input,
    //      from the specified starting index.

    val pattern1 = Regex("ll")  // Regex to match "ll" in a string
    val ans: MatchResult? = pattern1.find("HelloHello", 5)
    println(ans?.value)    // 11

    //  findAll() –
    //                fun findAll(
    //                input: CharSequence,
    //                startIndex: Int
    //                ): Sequence
    //      This function returns all the matchings of the specified pattern in the input,
    //      searching from the given start index.

    val pattern2 = Regex("ab.") // Regex to match a 3 letter pattern beginning with ab
    val ans1: Sequence<MatchResult> = pattern2.findAll("abcfffgdbabs", 0)
    ans1.forEach {        // forEach loop used to display all the matches
        matchResult ->
        println(matchResult.value)
    }
    println()         // abc abs


    //  matches() –
    //                  infix fun matches(input: CharSequence): Boolean
    //      This function returns a boolean indicating whether the input string completely matches the pattern or not.


    val pattern3 = Regex("g([ee]+)ks?")   // Tests demonstrating entire string match
    println(pattern3.matches("geeks"))           // true
    println(pattern3.matches("geeeeeeeeeeks"))   // true
    println(pattern3.matches("geeksforgeeks"))   // false

    //  matchEntire() –
    //                  fun matchEntire(input: CharSequence): MatchResult?
    //      This function tries to match the entire input to the specified pattern string, returning the string if it matches.
    //      If does not match the string, return null.


    var pattern4 = Regex("geeks?")   // // Tests demonstrating entire string match
    println(pattern4.matchEntire("geeks")?.value)       //geeks
    println(pattern4.matchEntire("geeeeeeeks")?.value)  //null
    pattern4 = Regex("""\D+""")
    println(pattern4.matchEntire("geeks")?.value)       //geeks
    println(pattern4.matchEntire("geeks12345")?.value)  //null

    //  replace() –
    //                  fun replace(input: CharSequence, replacement: String): String
    //      This function replaces all the occurrences of the pattern in the input string with the specified replacement string.


    //  replaceFirst() –
    //                  fun replaceFirst(
    //                  input: CharSequence,
    //                  replacement: String
    //                  ): String
    //      This function replaces the first match of the regular expression in the input with the replacement string.

    val pattern5 = Regex("xyz")     // Tests demonstrating replacement functions
    println(pattern5.replace("xyzxyzzzzzzzzz", "abc"))      // replace all xyz with abc in the string
    //abcabczzzzzzzz
    println(pattern5.replaceFirst("xyzddddddxyz", "abc"))   // replace only first xyz with abc not all
    //abcddddddxyz
    println()

    //  split() –
    //                  fun split(input: CharSequence, limit: Int): List
    //      This function breaks the input string into tokens according to the specified parameter.

    val pattern6 = Regex("\\s+")  // separate for white-spaces
    val answer: List<String> = pattern6.split("This is a sentence")
    answer.forEach { word -> println(word) }

    /*O/P :
        This
        is
        a
        sentence
    */

}