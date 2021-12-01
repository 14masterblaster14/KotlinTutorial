
/**

Interview Prep


1> Clean Architecture:
===================

SOLID PINCIPLES: <Refer : https://medium.com/android-news/android-development-the-solid-principles-3b5779b105d2>
===============
		- 	Single Responsibility 	: One class should have only one responsibility. If two reasons to change then split it into two classes.
										e.g. 
										adapter of Recyclerview should be responsible for taking the data from the data set and adapts it to a view.
										If adapter’s onBindViewHolder method is not only mapping object to the view, but if is also performing data formatting as well. 
										Then this violates the Single Responsibility Principle. 
										The adapter should only be responsible for adapting an order object to its view representation. 
										The onBindViewHolder is performing extra duties that it should not be. 
		
		-	Open-closed				: Components ( i.e. Software entities like classes, modules, functions, etc…) should be open for extension, but closed for modification
										e.g.
											Extention Functions, Sealed Classes etc.
											
		-	Liskov substitution		: Low level classes can be substituted without affecting higher levels i.e. Child classes should never break the parent class’ type definitions.
									  It can be achieved by using abstract classes and Interfaces.
										e.g.
											Inheritace, overriding
											In Repository pattern we define the Repository interface which we implement in Reository.
											
		-	Interface Segregation	: Many specific interfaces are better than one generic interface. 
									  Interface should only expose the methods that dependent class need and not more than that.
									  e.g.
										  If Clicklistener Interface has onclick, onLongClick, onTouch, onSwipe etc. methods then it will force to implement all methods irresptive of you use it or not.
										  So we should break this interface into 4 indivudual interfaces.
		
		-	Dependency Inversion	: High-level modules should not depend on low-level modules. Both should depend on abstractions.
									  Abstractions should not depend upon details. Details should depend upon abstractions.
									  Concrete classes depends on abstract classes and not the other way around.
									  e.g. Domain layer use cases are not depending upon VM.


2> MVP Vs MVVM : <Refre Image MVP_Vs_MVVM.jpg>

3> Design Patterns in Android: 

		a)	Creational patterns: How you create objects. “When I need a particularly complex object, how do I get an instance of it?” 
									- Builder				: It simplifies the creation of objects and lets you specify required components step-by-step e.g AlertDialog.Builder , Retrofit.Builder
									- Dependency Injection 	: It will make the required Object available e.g. dagger, hilt
									- Singleton 			: The Singleton pattern specifies that only a single instance of a class should exist with a global access point. e.g. SharedPref, RoomDB etc
									- Factory 				: It takes care of all the object creational logic. In this pattern, a factory class controls which object to instantiate. e.g. ViewModelProvider.Factory
			
		b)	Structural patterns: How you compose objects. So, when I open this class, how will I remember what’s it doing and how it’s put together?” 
									- Adapter 	: 	It allows two incompatible classes work together by converting a class’s interface into the interface the client expects. e.g. Recyclerview.Adapter
									- Facade 	: 	It provides a higher-level interface that makes a set of other interfaces easier to use. e.g. Retrofit creats interface to provide API data to client class
									- Decorator : 	The Decorator pattern dynamically attaches additional responsibilities to an object to extended its functionality at runtime.
									- Composite : 	When you want to represent a tree-like structure consisting of uniform objects. 
													A Composite pattern can have two types of objects: composite and leaf. 
													A composite object can have further objects, whereas a leaf object is the last object.
									
		c)	Behavioral patterns: How you coordinate object interactions. “So… how do I tell which class is responsible for what?” 	
									- Command 	:	An Event is a command-style object that’s triggered by user input, server data or pretty much anything else in your app.
									- Observer 	: 	The Observer pattern defines a one-to-many dependency between objects. When one object changes state, its dependents get a notification and updates automatically.
													e.g : 	It was originally popularized by the RxAndroid framework, also known as Reactive Android. 
															In short, you define Observable objects that will emit values. These values can emit all at once, as a continuous stream or at any rate and duration.
															Subscriber objects will listen for these values and react to them as they arrive. For example, you can open a subscription when you make an API call, listen to the server’s response and react accordingly.
															More recently Android also introduced a native way to implement this pattern through LiveData.
									- Strategy	: 	You use a Strategy pattern when you have multiple objects of the same nature with different functionalities. 
									- State		:	In the State pattern, the state of an object alters its behavior accordingly when the internal state of the object changes. 



		Types of App Architectures :	The App Architectures used to create solid and maintainable codebases.	
				
									-	MVC
									-	MVP
									-	MVVM + Clean Architecture
									
		Note : 4 2 2 3 	
		
		
4>  Android Security :		
						As Android is designed to be open and designed for developers and Users.
						
				
						Penetration Testing
						
						
						Platform Security : 
											1)	Protect app and user data
											2) 	Protect system resources (including the network)
											3) 	Provide app isolation from the system, other apps, and from the user

						Android provides these key security features:
											Robust security at the OS level through the Linux kernel
											Mandatory app sandbox for all apps
											Secure interprocess communication
											App signing
											App-defined and user-granted permissions
											
											
											
						Best Practices:
							
							1) App Locking - Biometric / Pin pattern or password
							2) OAuth Implementation 
							3) Lock Screen settings
							
							4) Manifest File :
												- Use minimum and only required App Permissions (Internet, Camera, GPS, Location)
												- Use Content provider
												- android:allowBackup="false"
												- set the android:exported attribute to false in the component's manifest element, such as for the <service> element
												- Use Intents : For activities and broadcast receivers, intents are the preferred mechanism for asynchronous IPC in Android. sendBroadcast(), sendOrderedBroadcast(), or an explicit intent to a specific application component. 
												  For security purposes, explicit intents are preferred.
												- Use services
															A Service is often used to supply functionality for other applications to use. Each service class must have a corresponding <service> declaration in its manifest file.
															By default, services are not exported and cannot be invoked by any other application. However, if you add any intent filters to the service declaration, it is exported by default. 
															It's best if you explicitly declare the android:exported attribute to be sure it behaves as you'd like. Services can also be protected using the android:permission attribute. 
															By doing so, other applications need to declare a corresponding <uses-permission> element in their own manifest to be able to start, stop, or bind to the service.
												- Use broadcast receivers:
															By default, receivers are exported and can be invoked by any other application. 
															If your BroadcastReceiver is intended for use by other applications, you may want to apply security permissions to receivers using the <receiver> element within the application manifest. 
															This prevents applications without appropriate permissions from sending an intent to the BroadcastReceiver.
							
							5) Build.gradle :	Apply Proguard ( minifyEnabled false )
												
												Proguard Vs Dexguard :
												
													ProGuard is an open source tool.
													DexGuard is a commercial, enterprise-grade product.
												
													ProGuard is a generic optimizer for Java bytecode.
													DexGuard is a specialized tool for the protection of Android applications.
													
													ProGuard offers basic protection against static analysis.
													DexGuard protects applications against static and dynamic analysis.
													
													ProGuard provides minimal obfuscation.
													DexGuard applies multiple layers of encryption and obfuscation.
													
													ProGuard focuses on the bytecode. (ProGuard’s action is restricted to the bytecode of Java applications)
													DexGuard processes all the components of an application.(Besides the Dalvik bytecode, it optimizes, obfuscates and encrypts manifest files, native libraries, resources, resource files and asset files.)
							
													
							
							6) Network Transactions - 
												- The key consideration is making sure that appropriate protocols are used for sensitive data, such as HttpsURLConnection for secure web traffic.
												- Authenticated, encrypted socket-level communication can be easily implemented using the SSLSocket class.
												- Use GCM/FCM for data message than SMS protocol was primarily designed for user-to-user communication and is not well-suited for apps that want to transfer data. 
												- Input validations
												
												- writing to on-device logs. In Android, logs are a shared resource and are available to an application with the READ_LOGS permission. Even though the phone log data is temporary and erased on reboot, inappropriate logging of user information could inadvertently leak user data to other applications.
												
												- Webview :
													WebView consumes web content that can include HTML and JavaScript, improper use can introduce common web security issues such as cross-site-scripting (JavaScript injection).
													If your application doesn't directly use JavaScript within a WebView, do not call setJavaScriptEnabled().
													Use addJavaScriptInterface() with particular care because it allows JavaScript to invoke operations that are normally reserved for Android applications. If you use it, expose addJavaScriptInterface() only to web pages from which all input is trustworthy. 
													we recommend exposing addJavaScriptInterface() only to JavaScript that is contained within your application APK.
													If your application accesses sensitive data with a WebView, you may want to use the clearCache() method to delete any files stored locally. You can also use server-side headers such as no-cache to indicate that an application should not cache particular content.
												
												- don't store user names and passwords on the device, if needs to store then use keystore. 
													Android offers a hardware-backed Keystore that provides key generation, import and export of asymmetric keys, 
													import of raw symmetric keys, asymmetric encryption and decryption with appropriate padding modes, and more.
												
												- Handling Credentials with oAuth implementation.
												
												-
												
												- SSL (Secure Socket Layer) Pinning : Securing listening sockets
												
														- 	SSL certificate creates a foundation of trust by establishing a secure connection.
														- 	This connection ensures that all data passed between the web server and browsers remain private and integral. 
														-	SSL certificates have a key pair, which is a Public and Private key.
														-	The certificate also contains “Subject“ which is the identity of the certificate/website owner.
														-	SSL Certificate Pinning, or pinning for short, is the process of associating a host with its certificate or public key. Once you know a host’s certificate or public key, you pin it to that host.
														-	A certificate is a file that encapsulates information about the server that owns the certificate issued by A Certificate Authority(CA) .
																Subject			: Provides the name of the entity (computer, user, network device, etc.) that the CA issued the certificate to.
																Serial Number	: Provides a unique identifier for each certificate that a CA issues.
																Issuer			: Provides a unique name for the CA that issued the certificate.
																Valid From		: Provides the date and time when the certificate becomes valid.
																Valid To		: Provides the date and time when the certificate is no longer considered valid.
																Public Key		: Contains the public key of the key pair that goes with the certificate.
																Algorithm Identifier: Indicates the algorithm used to sign the certificate.
																Digital Signature: A bit string used to verify the authenticity of the certificate.
																Version			: Version number of certificate
																TimeStamp		: This shows the time when certificate was created
															File Extention - .PEM(PEM(Privacy Enhanced Mail), PKCS(Public-key cryptography standards ), .cer, .der and .crt.
															
														How SSL works? :

																-	Client machine sends a connection request to server, server listens the request.
																-	Server gives response including public key and certificate.
																-	Client checks the certificate and sends a encrypted key to server.
																-	Server decrypt the key and sends encrypted data back to the client machine.
																-	Client receives and decrypt the encrypted data.
																
														Types of SSL Pinning(What to Pin)?
																Pin the certificate	: You can download the server’s certificate and put this in your app bundle. At runtime, the app compares the server’s certificate to the one you’ve embedded.
																					  There is a downside to pinning a certificate. Each time our server rotates it certificate, we need to update our application. So if the server rotates its certificate on a frequent basis, then our application would need to be updated frequently as well.
																Pin the public key	: You can retrieve the certificate’s public key and include it in your code as a string. At runtime, the app compares the certificate’s public key to the one hard-coded hash string in your code.
																					  By using public key pinning, we can avoid frequent application updates as the public key can remain same for longer periods. However, there are two downsides to public key pinning. 
																					  First, it’s harder to work with keys since it involves the process of extracting the key from the certificate. 
																					  Second, the key is static and may violate key rotation policies.
																Hash Pinning		: we pin the hash of the Public Key of our server’s certificate and match it with the hash of the certificate’s public key received during a network request. This technique is more complex than others.
																					  After having the certificate, we can hash it with hashing algorithm SHA-256 to hash the key.After calculating the hash, I simply encoded it with Base64 encoding, to make it easier to store, and read.
																					  
														Ways To Implement SSL Pinning :
																	
																(a) TrustManager <The old-school way>
																(b) OkHttp and CertificatePinner
																(c) Pinning with Retrofit
																(d) Network Security Configuration <Most Prefered way since Android 7.0.>
																
							7) App Signing -  

							8) App Publication -	
							
5> 	String vs StringBuffer vs StringBuilder :
		
		String : 
				-	Its immutable.
				-	Every immutable object is thread safe. Means same object can’t be shared by 2 or more threads at the same time.
				- 	Object created as a String and stored in Constant Literal Pool.
				
		StringBuffer:
				-	Its mutable.
				-	Its methoda (API) are synchronized means its thread safe.
				-	Object created as a StringBuffer and stored in Heap.
				
		StringBuilder:
				-	StringBuilder is same as StringBuffer but its methods are not synchronized.
				-	It is more faster than StringBuffer.
				-	If you are not using Threading logic, then better to use StringBuilder rather than StringBuffer.
				
				
6> Interceptors:
				Types of Interceptors
						We have two types of interceptors as follows:

				Application Interceptors: 	These are interceptors that are added between the Application Code(our written code) and the OkHttp Core Library. 
											These are the ones that we add using addInterceptor().
											We can add it with addInterceptor().
				Network Interceptors	: 	These are interceptors that are added between the OkHttp Core Library and the Server. 
											These can be added to OkHttpClient using addNetworkInterceptor().
											We can add it with addNetworkInterceptor() 
											
											
7> common mistakes that lead to memory leaks:
							Memory Leak = Failure to release unused objects from the memory.


							- Avoid using Enums and prefer Sealed Class.
							
							- If you don’t unregister the broadcast receiver :
									 Always remember to call unregister receiver in onStop() of the activity.
									 if the broadcast Receiver is registered in onCreate(), then when the app goes into the background and resumed again, the receiver will not be registered again.
									 It is always good to register the broadcastReceiver in onStart() or onResume() of the activity and unregister in onStop().
							
							- Static Activity or View Reference:			
									Declaring a TextView as static (for whatever reason). If you reference an activity or view directly or indirectly from a static reference, the activity would not be garbage collected after it is destroyed.
									Always remember to NEVER use static variables for views or activities or contexts.
									Avoid using Activity’s context wherever possible. Try to use the application’s context instead(e.g. for creating Room database instances, etc.).
							
							- Static Variables :
									The variables inside a companion object are static variables. These variables are associated with a class and not with instances of the class. So, they’ll live since the system loads the class.
									You should avoid having static variables referencing activities. They won’t be garbage collected even though they’re no longer needed.
								
							- TimerTask Reference: Cancel timer in activity onDestroy() to avoid memory leak.
							
							- Cancel any asyncTasks or Threads inside onDestroy() method of activity.
								
							-  Inner Class Reference:
							
							- Anonymous Classes : 
									Sometimes an anonymous class instance lives longer than the container instance is supposed to. If this anonymous class instance calls any method, or reads or writes any property of the container class, it would retain the container instance. This would leak the memory of the container.
							
							- AsyncTasks, Handlers, Singletons, Threads, and other components are used incorrectly.
							
							- Avoid binding leaks by setting binding = null in the onDestroyView() lifecycle method. 
							  Android’s official documentation has mentioned a cleaner way to handle view bindings.
							  
							- Pass viewLifecycleOwner instead of this while observing a LiveData object in a Fragment. 
							  This is because viewLifecycleOwner is tied to the fragment as long as it has its UI (onCreateView(), onDestroyView()). 
							  On the other hand, this is tied to the fragment’s overall lifecycle (onCreate(), onDestroy()).  
							  
							- Avoid ViewPager-related leaks by doing the following in onDestroyView(): 
							  set viewPager.adapter = null, 
							  remove listeners set on tabs(if any), and detach TabLayoutMediator  
							  
							- Set RecyclerView adapter to null in onDestroyView() to prevent the adapter from holding a reference to the RecyclerView object.  
							
8>	Kotlin Vs Java :

				Kotlin																		Java
Kotlin allows users to create an extension function.					Java doesn’t offer any extension functions.

Kotlin doesn’t require too much work for data classes.					Java developers write and construct a lot of elements to develop classes

Kotlin doesn’t offer implicit conversions.								Java supports implicit conversions.

Kotlin doesn’t have a static member for a class							It is available in Java

There are no null variables or objects in Kotlin.						Null variable or objects are part of Java language.

we can have one or more secondary constructors.							we can’t have secondary constructors. However, it can have multiple constructors.

In Kotlin, coroutine are concurrency design pattern 					Java uses two coroutine options as 1) Rx Java and 2) Project loom.
which can be used to simplify code.	

Kotlin’s type of system has inbuilt null safety.						NullPonter Exception is mainly responsible for the development of Java and Android.

Lazy-Loading feature is available in Kotlin.							This feature is not available in Java.


9> 	Disadantages OF MVVM :

		Communication between various MVVM components and data binding can be painful
		Code reusability of views and view model is difficult.
		Managing view models and their state in nested views and complex UI’s is difficult
		MVVM for beginners is hard to put to use.		


10> Best practices to support multiple screen size:
		
		a)	Dimensions:
						- Always avoid hard-coded layout sizes.
						- Use only dp (density-independent pixels), match_parent or wrap_content for layout elements dimensions.
						- Use only sp (scale-independent pixels) for text size.
						- Keep dimensions in dimens.xml files (Not hardcoded in app code or xml file).
						- Provide dimensions for different values folder for different screen resolutions.
					
		b)	Images and icons:
						-	Provide different images and icon in different drawable folder for different screen resolutions.
								drawable-ldpi        //240x320
								drawable-mdpi        //320x480
								drawable-hdpi        //480x800
								drawable-xhdpi       //720x1280
								drawable-xxhdpi      //1080X1920
								drawable-xxxhdpi     //1440X2560
						-	Don’t apply fixed values everywhere for image. Fixed dimensions can be vary with different device and image will be looked stretch. So use wrap_content.
						-	Recommended minimum size for icons is 32 dp and you need 8 dp free space between another icon.
						-	You should put all your app icons in mipmap directories instead of drawable directories. Beause all mipmap directories are retained in the APK even if you build density-specific APKs. This allows launcher apps to pick the best resolution icon to display on the home screen.
													
		
		c)	Layout design:
		
						- Use Constraints layout extensively 
							- Percenatage Guidelines
							- Barriers
							- Chains
							
						- Use Layout-qualifiers for smallest screen size and Orientation:
							-	320dp (sw320dp, sw320dp-land) 	: Small to medium phone screens
							-	480dp (sw480dp, sw480dp-land)	: Large phone screens (~5 inch)
							-	600dp (sw600dp, sw600dp-land)	: Small Tablets (~7 inch)
							-	720dp (sw720dp, sw720dp-land)	: Large Tablets (~10 inch)
		
				It is not a good practice to create different folders for layouts. 
				Create your layout such that it works fine with all the screen sizes. 
				To achieve this, play with the layout attributes. 
				You only need to have different images for hdpi, mdpi and ldpi types. The rest will be managed by android OS.
				If you want to use single layout and that should support all the screens like ldpi, , mdpi, hdpi, x-hdpi, xx-hdpi 
				then you have to use layout_weight in your layout that will handle screen size for all the screens					
									
									
11> Device is rooted or not? <Refer : https://medium.com/@scottyab/detecting-root-on-android-97803474f694>

		1> Use Promon shield
		2> Use Rootbeer library
		3> Your own code check:
		     (a) checkForBusyBoxBinary, checkForSuBinary* — su (super user) and Busybox binaries are often present on rooted devices to perform some of the privilege escalation and utility functions. Using file search look we search of presences of these in various which if found in the Android file system could indicate the device is rooted.
			 (b) checkSuExists* — slightly different file system check for the su binary.
			 
			 
        String[] places = { "/sbin/", "/system/bin/", "/system/xbin/",
                "/data/local/xbin/", "/data/local/bin/",
                "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" };
        for (String where : places) {
            if (new File(where + "su").exists()) {
                isRooted = true;

                break;
            }
        }
    }
    return isRooted;
	
	
	OR
	try {
			process = Runtime.getRuntime().exec(su);
			("It is rooted device");
			
	} catch (Exception e) {
      ("It is not rooted device");
   } 
   
12>	Task Affinity and Launch Modes : 
				*Reference :	https://medium.com/android-news/https-medium-com-yashsoniweb-android-tasks-ffbd547ff5b8
								https://medium.com/@jangraajit/task-affinity-impact-31d9032642d4
								https://0202gaurav.medium.com/activity-launch-modes-android-d7135a360170

				* 	Task means stack of activities. 
				*	Stack basically works on last in first out <LIFO> the concept.
				*	The affinity indicates in which task, activity refers to belongs to. 
				* 	Affinity is importanant in case of SingleInstance and SingleTask launch mode.

		a) Task Affinity (Manifest Activity):	
					Activities have affinity towards default package, that is the reason all the Activities in one App falls under one task, by default.
					By default, every activity has same affinity as your package attribute value of mainfest tag.
					
					<manifest package="com.example"...>
					
					<activity 
						android:taskAffinity="" 
						..	/>
				
		b) Activity Launch Modes in Manifest / Intent Flags :
		
			It is used to instructs Android system on how to launch a particular activity.
			Two ways to define launchMode for an Activity:
			1. In Manifest file			<activity android:launchMode = [“standard” | “singleTop” | “singleTask” | “singleInstance”] ../>
			2. Using Intent Flags
		
                    - standard <Default Launch Mode> :
						This is the default mode. In case you don’t define any launchMode, the new activity is launched in standard mode.
						Here, a new instance of the Activity will be created — everytime.
						No impact of task affinity change with standard launch mode
						e.g. Activity sequence : A → B → B → B   => Task1 => (Bottom) A → B → B → B (Top)
						
						
						
					- singleTop:
						This is just as same as “standard” mode, except for — Android will perform an extra check “whether this activity is already on the top of the Activity Stack.”
						If YES, then it won’t create a new instance of the Activity but instead it will call the onNewIntent() of the same Activity.
						No impact of task affinity change with SingleTop launch mode
						e.g. Activity sequence :	A → B → B 		=>	Task1 =>	(Bottom) A → B (Top)
							 Activity sequence :	A → B → A 		=> 	Task1 =>	(Bottom) A → B → A (Top)		(A new instance of A will be created as we don't have A at the top of stack)
						
					- singleTask:
						A new task will be created, and a new instance of activity will be moved at the top of the new stack (if this new activity have different taskAffinity).
						Your current activity has to have a “taskAffinity” value defined other than the default package name. 
						Or else, even though you have tagged it as “singleTask” it will still open it in the same damn Task.
						One last important point to note is: You CAN still have other Activities coming on top of this Activity, even in the newly created Task.
						e.g. Activity sequence :	A → B → C 					=>	Task1 =>	(Bottom) A → B → C (Top)	
													D (Same Affinity)			=>	Task1 =>	(Bottom) A → B → C → D (Top)
													E (Different X Affinity)	=>	Task2 =>	E (Top)
													F (Different Y Affinity)	=>	Task3 =>	F (Top)
													G (Different Y Affinity)	=>	Task3 =>	(Bottom) F → G (Top)
						
					- singleINstance
						This is exactly same as “singleTask” with one teeny-tiny difference. 
						That is:You CANNOT have other Activities coming on top of this Activity. This Activity is a lone warrior in the Tasks playground.
						Any activities started by this one open in a separate task.
						e.g. Activity sequence :	A → B → C 						=>	Task1 =>	(Bottom) A → B → C (Top)
													D (Different X Affinity)		=>	Task2 =>	D (Top)
													E (Different X Affinity)		=>	Task2 =>	E (Top)
													F (Same Affinity as of A/B/C)	=>	Task1 =>	F (Top)
			
			NOTE for using “singleTask” & “singleInstance”: 	
					When you launch an activity with a launchMode defined in Manifest, the Android system looks for the taskAffinity first. 
					Then in the main stack of Tasks (i.e. Recents screen), Android checks if there is a task already present with the root Activity having same taskAffinity as the one for intended Activity, 
					if Yes, then the Activity is opened in that task, else a new task is created and with Intended Activity placed at its root.		
			

			Defining launch modes using Intent Flags:
			
			
					FLAG_ACTIVITY_CLEAR_TASK - Clear any existing tasks on this stack before starting the activity.
					FLAG_ACTIVITY_NEW_TASK - Start the activity in a new task or reuse an existing task tied to that activity.
					FLAG_ACTIVITY_SINGLE_TOP - If the activity being started is the same as the current activity, then reuses the existing instance which receives a call to onNewIntent()
					FLAG_ACTIVITY_CLEAR_TOP - If the activity being started is already running in the current task, delivers us back to the existing instance and clears the stack.
					
			
					1)	 “FLAG_ACTIVITY_NEW_TASK”: same as launchMode — singleTask.
						e.g.
							Intent i = new Intent(FirstActivity.this, SecondActivity.class);
							i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							startActivity(i);
					Notes:
						(a) If you haven’t defined taskAffinity value different from the default one, setting this flag will have no effect. (Just like you did when using launchMode — singleTask)
						(b) The default behaviour of back press on newly created activity in a new task is — GO TO HOMESCREEN. If you want to go back to the Activity in your main task, that started this new Activity, then you have to define it in Manifest of your app. 
							See the following snippet:
														<activity android:name=".SecondActivity"
															android:taskAffinity="com.yash.soni"
															android:parentActivityName=".FirstActivity"/>
	
					2) “FLAG_ACTIVITY_SINGLE_TOP”:	same as launchMode — singleTop
						e.g.
							Intent i = new Intent(FirstActivity.this, FirstActivity.class);
							i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
							startActivity(i);
							
						Note :  if the Activity to be launched is on the Top of the Activity stack, then instead of creating a new Activity, it will call onNewIntent() of the already open Activity.
	
					3) “FLAG_ACTIVITY_CLEAR_TOP”:
							There are two scenarios of use here:
							a) All Activities in the same Task:
										As expected, this flag will clear all the Activities on the top of Intended Activity in the stack and bring it to Foreground.
							b) Activities spread across different tasks:
										If this flag is set along with FLAG_ACTIVITY_NEW_TASK then the system will bring the required Task that contains the intended Activity to Foreground, and clear all the Activities on the top of that Activity.

	
	
13> Accessibility :
				Testing : Download Accessibility Scanner from the Play Store.
					
				<a> TalkBack : 
						-	Content description : contentDescription can be set to @null. If you do this, TalkBack, and other screen readers will skip the element entirely, and move onto the next thing in the view.
						- 	Grouping : 
										Include label and value in parent layout. 
										add the android:focusable=  ”true” to  parent layout.
										add the attribute android:focusableInTouchMode= ”false” to parent layout
						- 	Labels	:	Add labelsFor attribute for text view which are label for the editable input fields
										android:labelFor="@id/coffeeLimitValue"
										
				<b> Touch targets: 
							EditText : Consider making the height of this touch target 48dp or larger.”
										add the android:minHeight="48dp"
										
				<c>	Color contrast :						
										
										
14> Services :	

				*Reference: https://medium.com/@Codeible/understanding-and-using-services-in-android-background-foreground-services-8130f6bbf2a5
							https://aalishan565.medium.com/android-services-frequently-asked-interview-questions-d33b37adf06d
				
				Services are application component which has no interface and can perform long-running operations in the background.
				These are the three different types of services:
				
				- Foreground service(starts by calling startForeground())
				- Started service or Background service(starts by calling startService())
				- Bound service(starts by calling bindService())
				
				Each of these terms are misleading because it is not describing the behavior of how each service are used, but it is describing how they are terminated.
				
				By default Started and Bind services run in the main thread, Only the intent service creates a different thread.
				
			1>	Foreground service(starts by calling startForeground()): 
						It is a service that stays alive even when the app is terminated.
						A foreground service performs some operation that is noticeable to the user. 
						For example, an audio app would use a foreground service to play an audio track. 
						Foreground services must display a Notification. Foreground services continue running even when the user isn’t interacting with the app.
						It has its lifecycle independent of the activity or fragment they were created. 
						It can be triggered by activity, broadcast receiver, content provider and service.
						e.g. playing music or downloading a file.
						
					Note: 	The WorkManager API offers a flexible way of scheduling tasks, and is able to run these jobs as foreground services if needed. 
							In many cases, using WorkManager is preferable to using foreground services directly.
			
			2>	Started service or Background service(starts by calling startService(), Started and Intent Service) :
						started service :-	A service is started when an application component, such as an activity, starts it by calling startService(). 
											Once started, a service can run in the background indefinitely, even if the component that started it is destroyed.
						
						intent service :-	A Intent service is a special type of service, It creates its own thread and executes work in a separate thread, 
											So in this, you explicitly don't create the thread. It has on handle intent() method which gets a callback once you start a service, 
											Does the same work as started service but get destroy once work has been finished.
						
						It is a service that runs only when the app is running so it’ll get terminated when the app is terminated.
						A background service performs an operation that isn’t directly noticed by the user. 
						For example, if an app used a service to compact its storage, that would usually be a background service.
						It has its lifecycle independent of the activity or fragment they were created. 
						It can be triggered by activity, broadcast receiver, content provider and service.
						e.g syncing your data with the server
						
					Note: 	If your app targets API level 26 or higher, the system imposes restrictions on running background services when the app itself isn’t in the foreground. 
							In most situations, for example, you shouldn’t access location information from the background. Instead, schedule tasks using WorkManager.	
										
			3>	Bound service(starts by calling bindService()):	
						It is a service that runs only if the component it is bound to is still active.
						It is used when your operation is related to interprocess communication. 
						A bound service allows components (such as activities) to bind to the service, send requests, receive responses, and even perform interprocess communication (IPC). 
						In simple words, when you want to get results continuously from your service you should use bound service.
						Activity, content provider and service can bind to the Bound service. 
						A Bound service offers a client-server interface that allows components to interact with the service, send requests, receive results. 
						It has no lifecycle. It uses the lifecycle of activity or fragment they were bounded.
						
					Note:	If your app targets API level 26 or higher, the system imposes restrictions on running background services when the app itself isn’t in the foreground. 
							In most cases like this, your app should use a scheduled job instead.	
							
			Note : In the new android versions, even the service doesn’t run indefinitely. Every operation except foreground service stops when device enters doze mode.


		*	Different intent flags while starting a service(Sticky, NotSticky, Re-deliver):
			START_NOT_STICKY: 	If the system kills the service after onStartCommand() returns, do not recreate the service unless there are pending intents to deliver.
								It does not create service again after onStartCommand function is executed and service is killed.
			START_STICKY: 		If the system kills the service after onStartCommand() returns, recreate the service and call, but do not redeliver the last intent.
								It creates service again after onStartCommand function is executed and service is killed. But it does not send the last intent again. 
								Calls onStartCommand function with a null intent unless there are pending intents to start the service. In that case, those intents are delivered.
			START_REDELEVER_INTENT: If the system kills the service after onStartCommand() returns, recreate the service and call onStartCommand() with the last intent that was delivered to the service.
									It creates service with last intent which is delivered again after onStartCommand function is executed and service is killed.
				
		* Service Life cycle:
						onCreate() -> onStartCommand() -> Service is Runing -> onDestroy()
						onCreate() -> onStartCommand() -> onBind() -> Service is Runing -> onRebind() -> onUnbind() -> onDestroy()
						
						
15>						
						

		


/**
