/**
 *  Testing Coverage
 *
 *  Unit Test Coverage          : 70%
 *  Integration Test Coverage   : 20%
 *  UI Tests Coverage           : 10%
 *
 * Types of Tests:
 *  1) Local Test        -> use 'com(test)' set
 *  2) Instrumented Test -> use 'com(androidTest)' set as it need android device/emulator and uses Android Framework/Libraries
 *
 * Dependencies :
 * implementation               -> Available for Local Tests i.e. 'com(test)' set and Instrumented Tests i.e.'com(androidTest)' set
 * testImplementation           -> Available for Local Tests only i.e. 'com(test)'
 * androidTestImplementation    -> Available for Instrumented Tests only i.e. 'com(androidTest)' set
 *
 * Note : At the time of build only 'implementation' dependencies are included in apk.
 *
 * Test Case Format:  SubjectUnderTest_actionOrInput_resultState
 *
 * Test Doubles :
 *               - Fakes : It's a light weight implementation class of the interface,
 *                         usually we hand code fake classes.
 *                         It's functional substitution for the real unit.
						   A Fake is an object that has a concrete implementation that works similar to the actual implementation. 
						   It is a simplified version of production code. 
						   It does not affect the behaviour of the test but simplifies the implementation of the test by removing heavyweight dependencies.	
 *                         e.g. Roboelectric testing framework for roomtest -> MovieViewModel
 *               - Stubs : It's an object that provides predefined answers/return value to method calls.
						   A stub is an object that provides (canned) hardcoded values to method calls. 
						   It always returns the same output regardless of the input.
 *               - Mocks : Is is similar to stub, but they allows tester to set answers to method calls when writing the test cases.
							A mock is similar to a stub, but the behaviour of the mocked interface can be changed dynamically based on scenarios.
 *                         e.g. Mockito testing framework for CalculationsViewModel class
 *
 *  Mockito : Easily creates stubs and mocks
 *
 * Note :-	-	All Kotlin Classes are Final by default.
 *          -   Treat all arguments and return values as non-nullable unless annotated with @Nullable
 *          -   Don't use Singleton if you want to test it, as it will fail other cases in same class due to singleton constraints
 *              as all cases will be executed simultaneously by creating different instances.
 *          -   Avoid static functional calls as static methods are hidden dependencies that can't be substituted with test doubles
 
 *			 // Update the below mentioned latest Mockito dependencies to work with static and final classes
				// Mockito Framework
				//  testImplementation "org.mockito:mockito-core:2.28.2"
				// testImplementation 'org.mockito:mockito-inline:2.19.0'
 *
 *
 *          Object                              Vs              Data Structure
 *          ======                              ==              ==============
 *      -   Expose Behaviour                                  - Expose Data and should nnot have Behaviour
 *      -   Hide internal implementation details              - Can be instantiated by other objects and Data structures
 *      -   should be injected into another object            - Unit test for objects tests data structures implicitly
 *      -   Need to be unit tested explicitly                 - No need to substitute with test doubles
 *      -   Eligible to be substituted with test doubles
 *
 *
 *   AAA Test Strategy :  Arrange -> Act -> Assert
 *
 *
 *
 */




Testing Frameworks :
						-	JUnit / Truth
						-	Mockito
						-	Powermock
						-	Robolectric
						-	Espresso
						-	Hamcrest
						
1> JUnit / Truth:	< import com.google.common.truth.Truth.assertThat >

			// When a class is annotated with @RunWith or extends a class annotated with @RunWith, 
			//	JUnit will invoke the class it references to run the tests in that class instead of the runner built into JUnit. 
			@RunWith(AndroidJUnit4::class)

			@BeforeClass in JUnit4	- Run once before any of the test methods in the class.
			@BeforeAll in JUnit5	- =,,=
			
			@AfterClass 			— Run once after all the tests in the class have been run.
			@AfterAll in JUnit5		- =,,=
			
			@Before in JUnit4		— Run before @Test
			@BeforeEach in JUnit5	- =,,=
			
			@After in JUnit4		— Run after @Test
			@AfterEach in JUnit5	- =,,=
			
			@Test — This is the test method to run		
			
			// As we are testing live data, we need to add InstantTaskExecutorRule.
			// It will run architecture related background jobs in the same thread so that the test results happens synchronously
			@get:Rule
			var instantTaskExecutorRule = InstantTaskExecutorRule()
			
			
			
			JUnit assertions : 
									assertEquals(b, a);
									assertTrue(c);
									assertTrue(d.contains(a));
									assertTrue(d.contains(a) && d.contains(b));
									assertTrue(d.contains(a) || d.contains(b) || d.contains(c));
									
									assertEquals(string1,string2);					
									assertSame(string3, string4);					
									assertNotSame(string1, string3);					
									assertNotNull(string1);			
									assertNull(string5);			
									assertTrue(variable1<variable2);					
									assertArrayEquals(airethematicArrary1, airethematicArrary2);
								 
			Truth equivalents...					 
			
									 assertThat(a).isEqualTo(b);
									 assertThat(c).isTrue();
									 assertThat(d).contains(a);
									 assertThat(d).containsAtLeast(a, b);
									 assertThat(d).containsAnyOf(a, b, c);
								 
			e.g.  
					assertThat(result).isFalse()	
					assertThat(result).isTrue()	
			
			
2> Mockito :
				-	Using the @Mock annotation, we can mock any class in Mockito. 

	Note:	As all classes in Kotlin are final, Mockito can't directly test the final/static and private classes.
			We need to set up mockito-extensions in order to run tests on final classes.
			or We need to use Powermock.

			 // *--  Solution 1  --* <Easy and prefered way>
			Update the below mentioned latest Mockito dependencies and it will work
			//Mockito Framework
				//  testImplementation "org.mockito:mockito-core:2.28.2"

				// testImplementation 'org.mockito:mockito-inline:2.19.0'

			// *--  Solution 2  --* <Old way>
			//	create a text file under app/src/test/resources/mockito-extensions called org.mockito.plugins.MockMaker with the following content
			//	(it may be easier to switch to the Project view in the Project pane in order to add the new directory and text file):
			// 	It won't run with Objects
					
	e.g.  
		calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calculationsViewModel = CalculationsViewModel(calculations)

	// As we are testing live data, we need to add InstantTaskExecutorRule.
    // It will run architecture related background jobs in the same thread so that the test results happens synchronously
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()




3> Espresso	:	UI Testing Framework.
			
			Steps: 
					-	Match a View: Find a View
					-	Perform an action : Perform a click or other action that triggers an event with the View.
					-	Inspect the result/Assert and verify the result: Check the state of the View to see if it reflects the expected state or behavior defined by the assertion.

			Espresso consists of mainly three components:
					-	ViewMatchers 	– It is used for finding a view using different attributes like withId(), withText(), withTagKey(), etc.
					-	ViewActions 	– It is used for performing the actions on the view defined in ViewMatchers like click(), longClick(), scrollTo(), etc.
					-	ViewAssertions 	– It is used to assert that the view found using ViewMatchers and expected views are the same using match(), doesNotExist(), etc.
					
					onView(ViewMatcher)       // onView takes a viewMatcher like R.id.button
					 .perform(ViewAction)     // perform takes a viewAction like pressing the button 
					   .check(ViewAssertion); // check inspects if the output result is same as the expected result. 
					   
					   
						ViewMatchers contains methods that Espresso uses to find the view on your screen with which it needs to interact.
						ViewActions contains methods that tell Espresso how to automate your UI. For example, it contains methods like click() that you can use to tell Espresso to click on a button.
						ViewAssertions contains methods used to check if a view matches a certain set of conditions.
						
	e.g.: 

			ActivityScenario.launch(MainActivity::class.java)

			// Success Scenario
			onView(withId(R.id.editText_main)).perform(typeText("This is input text."))
			onView(withId(R.id.button_name)).perform(click())
			onView(withId(R.id.text_message)).check(matches(withText("This is input text.")))

			onView(withId(R.id.editText_second)).perform(typeText("This is output text."))
			// ViewActions.closeSoftKeyboard()
			onView(withId(R.id.button_second)).perform(click())
			onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
			onView(withId(R.id.text_message_reply)).check(matches(withText("This is output text.")))
						
					
4>	Global Coverage Report in Android Development using JaCoCo Plugin:
						Refer :	<https://www.geeksforgeeks.org/how-to-generate-global-coverage-report-in-android-development-using-jacoco-plugin/>
			
