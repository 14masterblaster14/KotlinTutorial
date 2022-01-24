
1> Android Software Stack:  SJNAHLP

	(a) S -> System Apps
	(b) J -> Java API Framework
	(c) N -> Native C/C++ Libraries
	(d) A -> Android Runtime
	(e) H -> Hardware Abstraction Layer (HAL)
	(f) L -> Linux Kernel
	(g) P -> Power Management

Refer: AndroidSoftwareStack.png

2> Android Components:  CABS
	-	Content Providers
	-	Activities
	-	BroadCaste Receiver
	-	Services
	
3> Layouts:
			1> Linear Layout
			2> Relative Layouts
			3> Constraints Layout:
						(a) Guidelines:
										android:orientation="vertical"
										app:layout_constraintGuide_percent="0.25"
										
						(b) Barrier: Barrier's position is flexible and always based on the size of multiple UI elements contained within it. 
									e.g.:
									
									 <	androidx.constraintlayout.widget.Barrier
										android:id="@+id/barrier"
										android:layout_width="wrap_content"
										android:layout_height="wrap_content"
										app:barrierDirection="bottom"
										app:constraint_referenced_ids="left_text_view,right_text_view" />
							


						Note: 	The only difference between Barrier and Guideline is that Barrier's position is flexible and always based on the size of multiple UI elements contained within it 
								and Guideline's position is always fixed.
								
						(c) Bias:
									app:layout_constraintHorizontal_bias="0.2"
									 app:layout_constraintVertical_bias="0.2"
									 
						(d) View Sizing:
						
									android:layout_width="80dp"
									android:layout_height="0dp"			 
									app:layout_constraintDimensionRatio="4:8"	// Width:height
									
									android:layout_width="0dp"
									android:layout_height="0dp
									app:layout_constraintDimensionRatio="H, 1:0.4"	// Calculate width first and scale it in 1:0.4 (w:H) ratio
									// here width will be first computed from other constraints and then height will be adjusted according to the aspect ratio.

						(e) Chains:		
								 Spread Chain (by Default):
									app:layout_constraintHorizontal_chainStyle="spread"	// ByDefault	|	A	B 	C	|
									
								Spread Inside Chain:
									app:layout_constraintHorizontal_chainStyle="spread_inside"			|D		E		F|

								Weighted Chain:
									android:layout_width="0dp"
									app:layout_constraintHorizontal_weight="4"
									app:layout_constraintHorizontal_weight="2"
									app:layout_constraintHorizontal_weight="4"							|G     H  I		|
								
								Packed Chain:
									app:layout_constraintHorizontal_chainStyle="packed"					|	  JKL		|
									
								Packed chain with Bias:	
									app:layout_constraintHorizontal_chainStyle="packed"
									app:layout_constraintHorizontal_bias="0.2"							|  MNO			|


	CoordinatorLayout :
						CoordinatorLayout is a super-powered FrameLayout.
						CoordinatorLayout is intended for two primary use cases:
						1.	As a top-level application decor or chrome layout
						2.	As a container for a specific interaction with one or more child views

	
4> Activity Life Cycle	:  Refer : ActivityLifeCycle.png
 
5> Fragment Life Cycle	:	Refer : FragmentLifeCycle.png


6> Intent Filters:
					- Action	<One>			"android.intent.action.MAIN" , "android.intent.action.CALL", "com.google.action.DIAL" 
					- Category	<Category> 		"android.intent.category.LAUNCHER", "android.intent.category.DEFAULT" 
					- Data		<One>			<data android:scheme="http"/> <data android:scheme="tel"/>

					
	•	Every activity have one default category.So should be mentioned in the intent filter in manifest file.
	•	When your intent filter tag has data then user need to include the data tag in the code
	
	Types of Intent : 
		
		1>	Explicit Intent :
				-	specifies the component / Target by providing the external class to be invoked.
				e.g.
					val intent = Intent(getApplicationContext(), ActivityTwo.class)
					startActivity(intent)
		
		2>  Implicit Intents :	
				-	doesn’t specify the component / target
				-	provides information on available components provided by the system that is to be invoked.
				e.g.
					val intent = Intent(Intent.ACTION_VIEW)
					intent.data =   Uri.parse(“http://www.google.com”) 
					startActivity(intent)  
		

7> BroadCaste Receiver <Intent Recceivers>:
		a)	Broadcast receivers are also called intent receivers.
		b)	Android fires the intents (i.e.broadcast) and we need to wright the intent filters in our code to receive these intents.
		c)	If you want that your app should receive the broadcast during your app is active/open then register the broadcast in the code. (Don’t include manifest file “Receiver” tag and receiver class as well)
		d)	If you include/register the broadcast receiver in the manifest file then your app will receive the broadcasts all the time 
			i.e. irrespective of your app on or off, you app will receive the broadcast from app installation to uninstallation.(new -> other -> broadcast receiver(MyReceiver))

		android:enabled="true"     	//	 Receiver should instantiated by system.
		android:exported="true"		//	Should broadcast receiver can receive msg from source outside its app.


8> Notifications:
	
	**Pending Intent**
				In this type of notification user action is pending until and unless user is not going to click on status bar notification, 
				in such cases you are going to use pending intent. Pending can start new activity, start new service or broadcast


		Dialog Notification:
		•	Types :    AlertDialog , DatePickerDialog, TimePickerDialog and custom


9> Content Provider:
		(a)	Creation of content provider :
				•	In addition to the SQLite DB, we need to add one content provider.
				•	(new -> other -> content provider)
				•	Exported,Enabled = true;
				•	URI Authorities : unique entity
						e.g. "com.sampleuriauthorities.provider"
						
						
10> Coroutines:

		
		THREAD 1 |---> job_1 (coroutine_1)
		|---> job_2 (coroutine_2)
		|---> job_3 (coroutine_3)
		|---> job_4 (coroutine_3)
		|       :
		|---> job_n (coroutine_n)
		
		Coroutine works in scope i.e. we need to group the coroutines so that we can handle them in a better way and avoid leaks.
		
		Types of Coroutine Scopes:
		|---> GlobalScope 	 : It lives till the application is running and rarely used in android.
		|---> viewModelScope : Its a coroutine scope tied to a ViewModel so that when ViewModel destroyed then it will cancel all the coroutines/Job running within this scope.
		|---> lifecycleScope : Its a coroutine scope tied to the Activity/Fragment lifecycle so that when corresponding activity/ fragment gets destroyed then it will cancel all the coroutines/Job running within this scope.
								e.g.
										lifecycleScope.launch(Dispatchers.Main) {	delay(5000)	}
										lifecycleScope.launchWhenCreated { }
										lifecycleScope.launchWhenStarted { }
										lifecycleScope.launchWhenResumed { }
						
		Dispatchers (Context)
		|---> Main 		: For main thread / UI thread i.e. while interaction with UI
		|---> Default 	: For heavy computational work processing i.e. intensive CPU task sorting large data, parsing large json
		|---> IO 		: For background thread i.e. I/O operations, DB, network, file operations
		|---> Unconfined : 	runs in current thread but if it is suspended and resumed it will run on suspending function's thread.
							Use it with at most care, and mostly use for testing
							
		Note : Best practice to start coroutines on main thread and switch to other thread
		
		Jobs : We can run/tagged multiple jobs in a particular Coroutine scope.
		
		Coroutine Builders:
		|--->   launch      :   It's basic builder and doesn't block current thread. It needs scope.
								It returns instance of job,which can be used as a ref to the coroutine.
								We use this for coroutines that doesn't have any result as the return value.
		|--->   async       :   It launches new coroutine w/o blocking current thread.
								It returns instance of Deferred<T> and need to invoke await() to get the value.
								It needs parent coroutine. It doesn't block parent coroutine. But if "await" is called then it blocks.
								We use this for coroutines that does have any result as the return value.
		#   The main difference between launch() and async() is that the first one doesn’t allow to obtain a value returned by its coroutine block, while the second one allows the block to return a value that can be used outside the coroutine.
		
		|--->   Produce 	:   It's for coroutines which produce a stream of elements and returns an instance of ReceiveChannel Block current thread to run coroutines. So don't use it.
		|--->   runBlocking : 	Block current thread to run this coroutines and returns a result of type T. So don't use it. Mostly used for testing.
		
		Coroutine Methods:
		|--->   withContext
		Suspended Functions:    A suspending function doesn't block a thread but only suspend the coroutine itself.
								The thread is returned to the pool while the coroutine is waiting and when waiting is done
								the coroutine resumes on the free thread in the pool.
								We can call/invoke suspending function from either a coroutine block or
								from another suspending function only.
		e.g.                withContext
							withTimeout
							withTimeoutOrnull
							join
							delay
							await
							supervisorScope
							coroutineScope
							
		# We can convert the callbacks to coroutine
		
		# Structured Concurrency :  It is set of language features and best practises introduced for kotlin coroutines to avoid leaks and manage them productively.
		
		# CoroutineScope : It's an interface.
		
		# coroutineScope : Its a suspend function which will create child scope and gives the guarantee to complete all the task of child scope before returning the value.
		
		  
		The Deferred interface defines a coroutine job that returns a result value (Deferred inherits from Job).
		The Deferred interface includes a method called await(), which causes your code to wait without blocking
		until the value is ready, and then that value is returned.	
		
		**/
		
		
11> Navigation Components:
		
		Safe Args plugin for passing the data in between fragments.
	
		NavHostFragment	-	The main container which will host all the fragment.
							It should consists:
									android:name="androidx.navigation.fragment.NavHostFragment"
									app:defaultNavHost="true"
									app:navGraph="@navigation/nav_graph"
											
		NavigationGraph	-	nav_graph.xml
							It should consists: 
									android:id="@+id/nav_graph"					// Should be similar to nav graph file name
									app:startDestination="@id/firstFragment"
		
		Navcontroller	-	NavController is an object which manages the navigation of destinations with NavHost. 
							This controls the swapping of destination content as the user navigates through the destinations through the application.
							It's recommended you use one of the following extension functions, depending on whether you're calling the navigation command from within a fragment, activity or view:
								->  Fragment.findNavController()
								->  View.findNavController()
								->  Activity.findNavController(viewId: Int)
							
							Your NavController is associated with a NavHostFragment. Thus whichever method you use,
							you must be sure that the fragment, view, or view ID is either a NavHostFragment itself,
							or has a NavHostFragment as a parent. Otherwise you will get an IllegalStateException.
							
		- 	Add destinations
		-	Define Actions with Arguments , popUpTo etc	
		
		
12> DeepLinking:
					Deep links are URLs that link to a specific screen or content of your app.
						Need to implementation of the onNewIntent() method to MainActivity.
					 
							 override fun onNewIntent(intent: Intent?) {
							  super.onNewIntent(intent)
							  findNavController(this, R.id.navHostFragment).onHandleDeepLink(intent)
							}
							
13>	Room: It's a wrapper over SQLite .
		
		Entity: 
				It's an Data class.
				An entity class defines a table.
				Each instance of that class represents a row in the table.
				Each property defines a column.
				Annotations:	
							@Entity(tableName = "daily_sleep_quality_table")
							@PrimaryKey(autoGenerate = true)
							@ColumnInfo(name = "start_time_milli")
							
		DAO (Data Access Object):
				It's an Interface.				
				Defines methods for using the Entity class with Room.
				Annotations:
						@Dao,	@Insert,	@Update,	@Query,		@Delete
						
		DataBase:
				It's an abstract class.
				Annotations:
						@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
						
						@Volatile :-
						The value of a volatile variable will never be cached, and all writes and reads will be
						done to and from the main memory. This helps make sure the value of INSTANCE is always
						up-to-date and the same to all execution threads. It means that changes made by one
						thread to INSTANCE are visible to all other threads immediately, and you don't get a
						situation where, say, two threads each update the same entity in a cache,
						which would create a problem.

				synchronized :-
				Multiple threads can potentially ask for a database instance at the same time,
				resulting in two databases instead of one. This problem is not likely to happen
				in this sample app, but it's possible for a more complex app. Wrapping the code
				to get the database into synchronized means that only one thread of execution
				at a time can enter this block of code, which makes sure the database only gets
				initialized once.

				fallbackToDestructiveMigration() :-
				Normally, you would have to provide a migration object with a migration strategy for
				when the schema changes. A migration object is an object that defines how you take all rows
				with the old schema and convert them to rows in the new schema, so that no data is lost.
				Migration is beyond the scope of this codelab. A simple solution is to destroy and rebuild the database,
				which means that the data is lost.

15> Data Caching:

	/**
                        *-----  Concept: Caching    ----*

After an app fetches data from the network, the app can cache the data by storing the data
in a device's storage.You cache data so that you can access it later when the device is offline,
or if you want to access the same data again.

The following table shows several ways to implement network caching in Android.

Caching technique :
                    1)  Retrofit :
                            It is a networking library used to implement a type-safe REST client
                            for Android.You can configure Retrofit to store a copy of every
                            network result locally.

                        Uses :
                            Good solution for simple requests and responses, infrequent network calls,
                            or small datasets.

                    2) SharedPreferences :
                            You can use SharedPreferences to store key-value pairs.

                        Uses :
                            Good solution for a small number of keys and simple values.
                            You can't use this technique to store large amounts of structured data.

                    3) Internal storage :
                            You can access the app's internal storage directory and save data files
                            in it.Your app's package name specifies the app's internal storage
                            directory, which is in a special location in the Android file system.
                            This directory is private to your app, and it is cleared when your app
                            is uninstalled.
                        Uses :
                            Good solution if you have specific needs that a file system can solve—
                            for example, if you need to save media files or data files and you have
                            to manage the files yourself. You can't use this technique to store
                            complex and structured data.

                    4) Room :
                            You can cache data using Room, which is an SQLite object-mapping library
                            that provides an abstraction layer over SQLite.


                        Uses :
                            Recommended solution for complex and structured data, because the best
                            way to store structured data on a device's file system is in a
                            local SQLite database.

In this codelab, you use Room, because it's the recommended way to store structured data on a device file system.

        **/


14> WorkManager:			

/**
                  *-----  WorkManager ----*
				  
		/**
			Work Manager used for ->
						Chaining Tasks
						Status Updates
						Constraints
						Ensures Minimum resource usage
						Supports Different Versions
						Supports Asynchronous Tasks
						Supports Periodic Tasks
						
			Work manager is not for tasks that needs to be run in a background thread but donn't need to survive process death.
			
			Type of Work Request :  
									1) Periodic Work Request
									2) One Time Work request
									
			Steps to schedule a task with Work Manager :
									1) Create Worker class i.e. subclass of Worker class
									2) Create a Work request
									3) Enqueue the request
									4) Get the status updates (i.e. WorkInfo)
									
			Work States : BLOCKED, ENQUEUED, RUNNING and SUCCEEDED
			
			Constraints : The conditions in which u want to execute ur work
			
			Chaining :
						We can set inputs and outputs data of a worker class
						We can sequentially and parallel chain different task
						Periodic Work Request : Minimum period length = 15 min
 */		  
				  
				  
		WorkManager is for background work that's deferrable and requires guaranteed execution:

		->  Deferrable means that the work is not required to run immediately.
			For example, sending analytical data to the server or syncing the database in the background
			is work that can be deferred.
		->  Guaranteed execution means that the task will run even if the app exits or the device restarts.


		While WorkManager runs background work, it takes care of compatibility issues and best practices
		for battery and system health. WorkManager offers compatibility back to API level 14.
		WorkManager chooses an appropriate way to schedule a background task, depending on the device
		API level. It might use JobScheduler (on API 23 and higher) or
		a combination of AlarmManager and BroadcastReceiver.

		 WorkFlow:->
										Determine the Background Schedular
										==================================
														||
														||
														||
											   Yes      ||        No
											========= API 23+ ==========
											||                         ||
											||                         ||
											||                         ||
											||                         ||
										JobSchedular            AlarmManager and
																BroadcastReceiver


		Note:

		->  WorkManager is not intended for in-process background work that can be terminated safely
			if the app process is killed.
		->  WorkManager is not intended for tasks that require immediate execution.

		WorkManager library:

		#   Worker :-
					This class is where you define the actual work (the task) to run in the background.
					You extend CoroutineWorker class and override the doWork() method. The doWork() method is where
					you put code to be performed in the background, such as syncing data with the server
					or processing images. You implement the Worker in this task.

		#   WorkRequest :-
					This class represents a request to run the worker in background. Use WorkRequest to
					configure how and when to run the worker task, with the help of Constraints such as
					device plugged in or Wi-Fi connected. You implement the WorkRequest in a later task.

		#   WorkManager :-
					This class schedules and runs your WorkRequest. WorkManager schedules work requests
					in a way that spreads out the load on system resources, while honoring the constraints
					that you specify. You implement the WorkManager in a later task.

		In this codelab, you schedule a task to pre-fetch the DevBytes video playlist from the network
		once a day. To schedule this task, you use the WorkManager library.


	Sequence:
				1> Create Worker : CoroutineWorker , override suspend fun doWork(): Result.success()/Result.failure()/Result.retry()
				2> Define constraints ( with constraints.Builder)
				3> Define work Request i.e. Repeating request (and set constraints)
				4> Get WorkManager instance and enque the work and repeating request.


e.g.

		---------------------	Application Class	-----------------

	/**
     * Setup WorkManager background job to 'fetch' new network data daily.
     *
     */
	
    private fun setupRecurringWork() {

        /**
         * When defining the WorkRequest, you can specify constraints for when the Worker should run.
         * For example, you might want to specify that the work should only run when the device is
         * idle, or only when the device is plugged in and connected to Wi-Fi. You can also specify
         * a backoff policy for retrying work.
         *
         */
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)  //the work request will only run when the device is on an unmetered network.
            .setRequiresBatteryNotLow(true) //the work request should run only if the battery is not low.
            .setRequiresCharging(true)      //it runs only when the device is charging.
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setRequiresDeviceIdle(true) // it runs only when the device is idle.
                }
            }
            .build()

        //  repeat interval of 1 with a time unit of TimeUnit.DAYS.
        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        //  repeat interval of 1 with a time unit of TimeUnit.DAYS.
        //	val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(15, TimeUnit.MINUTES)
        //    .setConstraints(constraints)
        //    .build()

        Timber.d("Periodic Work request for sync is scheduled")

        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
            //  If pending (uncompleted) work exists with the same name, the ExistingPeriodicWorkPolicy.
            //  KEEP parameter makes the WorkManager keep the previous periodic work and discard the new work request.
        )
    }

	---------------------	Worker	-----------------
	
	class RefreshDataWorker(appContext : Context, params: WorkerParameters) : CoroutineWorker(appContext,params) {

    /**
     *
     * A suspending function is a function that can be paused and resumed later.
     *  A suspending function can execute a long running operation and wait for it to complete
     *  without blocking the main thread.
     *
     *  The doWork() method inside the Worker class is called on a background thread.
     *  The method performs work synchronously, and should return a "ListenableWorker.Result" object.
     *  The Android system gives a Worker a maximum of 10 minutes to finish its execution and
     *  return a ListenableWorker.Result object. After this time has expired,
     *  the system forcefully stops the Worker.
     *
     *      Result.success()—work completed successfully.
     *      Result.failure()—work completed with a permanent failure.
     *      Result.retry()—work encountered a transient failure and should be retried.
     *
     *   A Worker defines a unit of work and the WorkRequest defines how and when work should be run.
     *   There are two concrete implementations of the WorkRequest class:
     *
     *   The OneTimeWorkRequest class is for one-off tasks. (A one-off task happens only once.)
     *
     *   The PeriodicWorkRequest class is for periodic work, work that repeats at intervals.
     *   Note:  The minimum interval for periodic work is 15 minutes.
     *          Periodic work can't have an initial delay as one of its constraints.
     *
     * */

    companion object {
        // Define a work name to uniquely identify this worker.
        const val WORK_NAME = "com.example.repositoryworkmanager.work.RefreshDataWorker"
    }

    override suspend fun doWork(): Result {

        val database = getDatabase(applicationContext)
        val repository = VideosRepository(database)

        try {
            repository.refreshVideos( )
            Timber.d("Work request for sync is run")
        } catch (e: HttpException) {
            return Result.retry()
        }

        return Result.success()
    }
}

 */
	

15>

/**
 *  Databinding :   We can bind views views with data and vice versa
 *
 *  ViewBinding :   We can bind only views with data but can't bind data with views.
 *                  It's easy and superior in performance (due to faster compile time as annotation processor) than Databinding.
 *                  Requires no xml changes.
 *                  There is no binding expressions, two way binding and binding adapters.
 *
 * Note: There is nothing Viewbinding can do that databinding can't do.
 */
 
 
16> 

/**
 *  GET :   to retreive data from a server at the specified resource,
 *          its a default method in HTTP clients and returns a 200 status code.
 *          	GET requests can be cached
				GET requests remain in the browser history
				GET requests can be bookmarked
				GET requests should never be used when dealing with sensitive data
				GET requests have length restrictions
				GET requests are only used to request data (not modify)
 *
 *  POST :  to send data to the API server to create or update a resource and 200 status code is returned.
 *          It is non-idempotent. It mutates data on the backend server (by creating or updating a resource),
 *          as opposed to a GET request which does not change any data.
	 *          POST requests are never cached
				POST requests do not remain in the browser history
				POST requests cannot be bookmarked
				POST requests have no restrictions on data length
 *
 *  PUT :   to send data to the API to update or create a resource. The difference is that PUT requests are idempotent.
 *          That is, calling the same PUT request multiple times will always produce the same result.
 *          In contrast, calling a POST request repeatedly make have side effects of creating the same resource multiple times.
 *          It will respond with a 201 (Created), and if the request modifies existing resource the server will return a 200 (OK) or 204 (No Content).
 *
 *  PATCH : it is similar to POST and PUT. The difference with PATCH is that you only apply partial modifications to the resource.
 *          The difference between PATCH and PUT, is that a PATCH request is non-idempotent (like a POST request).
 *          A successful PATCH request should return a 2xx status code.
 *          PATCH requests should fail if invalid data is supplied in the request -- nothing should be updated.
 *
 *  DELETE : to delete the resource at the specified URL
 *            sending a DELETE request to an unknown resource should return a non-200 status code.
 *
 *  HEAD:   The HEAD method is almost identical to GET, except without the response body.
 *          In other words, if GET /users returns a list of users, then HEAD /users will make the same request
 *          but won't get back the list of users.
 *          HEAD requests are useful for checking what a GET request will return before actually making a GET request
 *          -- like before downloading a large file or response body.
 *
 *  OPTIONS: It should return data describing what other methods and operations the server supports at the given URL.
 */
 
	/*

Action                  	    GET	                                                                            POST

BACK button/Reload	            Harmless	                                                                    Data will be re-submitted (the browser should alert the user that the data are about to be re-submitted)
Bookmarked	                    Can be bookmarked	                                                            Cannot be bookmarked
Cached	                        Can be cached	                                                                Not cached
Encoding type	                application/x-www-form-urlencoded	                                            application/x-www-form-urlencoded or multipart/form-data. Use multipart encoding for binary data
History	                        Parameters remain in browser history	                                        Parameters are not saved in browser history
Restrictions on data length	    Yes, when sending data, the GET method adds the data to the URL;                No restrictions
                                and the length of a URL is limited (maximum URL length is 2048 characters)
Restrictions on data type	    Only ASCII characters allowed	                                                No restrictions. Binary data is also allowed
Security	                    GET is less secure compared to POST because data sent is part of the URL        POST is a little safer than GET because the parameters are not stored in browser history or in web server logs
                                Never use GET when sending passwords or other sensitive information!
Visibility	                    Data is visible to everyone in the URL	                                        Data is not displayed in the URL
 */
