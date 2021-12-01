/**

************* Rx Java ********************
* Reference : 	https://medium.com/@gabrieldemattosleon/fundamentals-of-rxjava-with-kotlin-for-absolute-beginners-3d811350b701
				https://medium.com/p/367c22d86677

Key Components:: Observable is the Speaker, Operator is the Translator, and the Observer is the Listener.

Observable 	− 	It represents an object similar to Stream which can emit zero or more data, can send error message, 
				whose speed can be controlled while emitting a set of data, can send finite as well as infinite data.
				Internally in code, when a new word is emitted from the observable, the onNext() method is called on each subscriber. 
				When the observable finishes all of words either successful or with an error, the onComplete() or the onError() method is called on the subscriber.
				
				just :	The just operator converts an Item into an Observable and emits it.
					e.g.	
								Observable.just("Hello Reactive World")
										.subscribe { value -> println(value) } 	//	Hello Reactive World
										
										
								Observable.just("Apple", "Orange", "Banana")
										.subscribe(
											{ value -> println("Received: $value") }, // onNext
											{ error -> println("Error: $error") },    // onError
											{ println("Completed!") }                 // onComplete
										)		
				
										o/p:	Received: Apple
												Received: Orange
												Received: Banana
												Completed!
												
				from : 
					e.g.		Observable.fromArray("Apple", "Orange", "Banana")
										.subscribe { println(it) }						// Apple Orange Banana
										
								Observable.fromIterable(listOf("Apple", "Orange", "Banana"))
										.subscribe(
											{ value -> println("Received: $value") },      // onNext
											{ error -> println("Error: $error") },         // onError
											{ println("Completed") }                       // onComplete
										)
										
										O/P:	Received: Apple
												Received: Orange
												Received: Banana
												Completed
												
				interval : 
					e.g.		Observable.intervalRange(
											10L,     // Start
											5L,      // Count
											0L,      // Initial Delay
											1L,      // Period
											TimeUnit.SECONDS
										).subscribe { println("Result we just received: $it") }	

										O/P:	Result we just received: 10
												Result we just received: 11
												Result we just received: 12
												Result we just received: 13
												Result we just received: 14
												
												
								Observable.interval(1000, TimeUnit.MILLISECONDS)				// infinite interval.
										.subscribe { println("Result we just received: $it") }		
										
										O/P:	Result we just received: 0
												Result we just received: 1
												Result we just received: 2
												...		
												
				range :
					e.g.:		Observable.range(1,6)
									.subscribe(num-> System.out.println("Item "+num));			

										O/P:	
											Item 1
											Item 2
											Item 3
											Item 4
											Item 5
											Item 6
												
				BackPressure:
							Backpressure is the process of handling an emitter that will produce a lot of items very fast. 
							Let’s say an Observable produces 100000 items per second, how will a subscriber that can only handle 100 items per second process those items?
							The Observable class has an unbounded buffer size, it buffers everything and pushed onto the subscriber, and if it’s emitting more than it can handle, you’re bound to get OutOfMemoryException .
							We can handle such a stream of data if we apply Backpressure to the items as needed, in this way it the unnecessary items will be discarded or even let the producer know when to create or when to push the newly emitted item.
							
							
Other Observables / Emitter types :
				
							Flowable : It works exactly like an Observable but it supports Backpressure.
										e.g.
												Flowable.just("This is a Flowable")
														.subscribe(
															{ value -> println("Received: $value") },
															{ error -> println("Error: $error") },
															{ println("Completed") }
														)
														
							Maybe : 	This class is used when you’d like to return a single optional value. The methods are mutually exclusive, in other words, only one of them is called. 
										If there is an emitted value, it calls onSuccess , if there’s no value, it calls onComplete or if there’s an error, it calls onError .							
										e.g.
												Maybe.just("This is a Maybe")
														.subscribe(
															{ value -> println("Received: $value") },
															{ error -> println("Error: $error") },
															{ println("Completed") }
														)

							Single :	It’s used when there’s a single value to be returned. 
										If we use this class and there is a value emitted, onSuccess will be called. If there’s no value, onError will be called.
										e.g.
												Single.just("This is a Single")
														.subscribe(
															{ v -> println("Value is: $v") },
															{ e -> println("Error: $e")}
														)
														
							Completable:	A completable won’t emit any data, what it does is let you know whether the operation was successfully completed. 
											If it was, it calls onComplete and if it wasn’t it calls onError . 
											A common use case of completable is for REST APIs, where successful access will return HTTP 204 , and errors can ranger from HTTP 301 , HTTP 404 , HTTP 500 , etc. We might do something with the information.							
										e.g.
												Completable.create { emitter ->
															emitter.onComplete()
															emitter.onError(Exception())
														}
														
							You can also manually call the methods doOnSubscribe, doOnNext, doOnError, doOnComplete.			
									
									Observable.just("Hello")
											.doOnSubscribe { println("Subscribed") }
											.doOnNext { s -> println("Received: $s") }
											.doAfterNext { println("After Receiving") }
											.doOnError { e -> println("Error: $e") }
											.doOnComplete { println("Complete") }
											.doFinally { println("Do Finally!") }
											.doOnDispose { println("Do on Dispose!") }
											.subscribe { println("Subscribe") }
											
Schedulers	-	Although RxJava is heavily marketed as an asynchronous way of doing reactive programming, it’s important to clarify that RxJava is single threaded by default, 
				and you need to specify otherwise, and that’s where Schedulers come in.			

				With Synchronous programming, only one thing happens at a time. The code fires up method a, which Reads/Write from the database, and waits for a to finish before moving on to b. 
												So you get one thing happening at a time, and it’s the most common cause for UI freeze since the code will also run in the same thread as the UI.
				With Asynchronous programming, you can call many methods at once, without waiting for another to finish. 
												It’s one of the most fundamentals aspects of Android Development, you do not want to run every code on the same thread as the UI, especially computational code.		
	
				subscribeOn and observeOn : These methods allow you to control the action of the subscription and how you receive the changes.
	
				subscribeOn:	The method subscribeOn() will instruct the source Observable which thread to emit the items on and push the emissions on our Observer .
				
					Scheduler.io()			:	Generally t is used for IO related stuff, such as network requests, file system operations, and it’s backed by a thread pool. 
					Scheduler.computation()	:	It is quite similar to IO as it’s also backed up by the thread pool, however, the number of threads that can be used is fixed to the number of cores present in the device. 
												Say you have 2 cores, it means you’ll get 2 threads, 4 cores, 4 threads, and so on.
					Scheduler.newThread()	: 	The name here is self-explanatory, as it will create a new thread for each active Observable . 
												You may want to be careful using this one as if there are a high number of Observable actions it may cause instability.	
												you can also set how many concurrent threads you want running, so you could do .
					Scheduler.single()		:	This Scheduler is backed up by a single thread. No matter how many Observable there are, it will only run in a single thread. 
												Think about it as a replacement for the main thread.	
												
				observeOn:	if it finds an observeOn() in the chain, it switches the emissions using the selected scheduler for the remaining operation.								
												
					AndroidSchedulers.mainThread():  Calling this on observeOn will bring the thread back to the Main UI thread, and thus make any modification you need to your UI.
													 Usually, the observing thread in Android is the Main UI thread.
													 
				e.g.	
							Observable.just("Apple", "Orange", "Banana")
									.subscribeOn(Schedulers.io())
									.observeOn(AndroidSchedulers.mainThread())
									.subscribe{ v -> println("Received: $v") }
									
	
Operator	-	An Operator has the capability to modify the data from one form to another.		
				
			map() : Transforms values emitted by an Observable stream into a single value.	
					e.g.:
							Observable.just("Water", "Fire", "Wood")
										.subscribeOn(Schedulers.io())
										.observeOn(AndroidSchedulers.mainThread())
										.map { m -> m + " 2" }
										.subscribe { v -> println("Received: $v") }
							
					o/p:	Received: Water 2
							Received: Fire 2
							Received: Wood 2

			flatMap():	Unlike the map() operator, the flatMap() will transform each value in an Observable stream into another Observable , 
						which are then merged into the output Observable after processing. 
						which can have its own specific chains, including specifying its own thread.
						e.g.:	
					
							Observable.just("Water", "Fire", "Wood")
										.subscribeOn(Schedulers.io())
										.observeOn(AndroidSchedulers.mainThread())
										.flatMap { m ->
											Observable.just(m + " 2")
												.subscribeOn(Schedulers.io())
										}
										.subscribe { v -> println("Received: $v") }
										
					o/p:	Received: Water 2
							Received: Fire 2
							Received: Wood 2					
					It simply transformed each value emitted by the Observable into separate Observable .
					
			switchMap():	The switchMap operator is similar to flatMap, except that it retains the result of only the latest observable, discarding the previous ones.	
						e.g. : used in pull to refresh page cases

			zip():	It will combine the values of multiple Observable together through a specific function.
					e.g.:					
						Observable.zip(
										Observable.just("Roses", "Sunflowers", "Leaves", "Clouds", "Violets", "Plastics"),
										Observable.just("Red", "Yellow", "Green", "White or Grey", "Purple"),
										BiFunction<String, String, String> { type, color -> "$type are $color" }
										).subscribe { v -> println("Received: $v") }
									
						O/P : 	Received: Roses are Red
								Received: Sunflowers are Yellow
								Received: Leaves are Green
								Received: Clouds are White or Grey
								Received: Violets are Purple			
							Notice that the value "Plastics" did not reach its destination. That’s because the second Observable had no corresponding value.
							The BiFunction <String, String, String> simply means that the value of the first and secondObservable are both a string and the resulting Observable is also a String.
							
			concat():	It will concatenate (join together) two or more Observable .		
						e.g.:
								val test1 = Observable.just("Apple", "Orange", "Banana")
								val test2 = Observable.just("Microsoft", "Google")
								val test3 = Observable.just("Grass", "Tree", "Flower", "Sunflower")

								Observable.concat(test1, test2, test3)
									.subscribe{ x -> println("Received: " + x) }
									
						O/P :	Received: Apple
								Received: Orange
								Received: Banana
								Received: Microsoft
								Received: Google
								Received: Grass
								Received: Tree
								Received: Flower
								Received: Sunflower		
			
			merge():	It works similarly to concat() , except merge will intercalate the emissions from both Observable , whereas concat() will wait for one to finish to show another.	
						e.g.:
								Both of the Observable above will keep emitting the item "Apple" and "Orange” , one every 250ms and the other every 150ms, then we take(10) results.
								
								Observable.merge(
												Observable.interval(250, TimeUnit.MILLISECONDS).map { i -> "Apple" },
												Observable.interval(150, TimeUnit.MILLISECONDS).map { i -> "Orange" })
												.take(10)
												.subscribe{ v -> println("Received: $v") }

						O/P	:	Received: Orange
								Received: Apple
								Received: Orange
								Received: Orange
								Received: Apple
								Received: Orange
								Received: Apple
								Received: Orange
								Received: Orange
								Received: Apple
								
								Vs
								
								Observable.concat(
												Observable.interval(250, TimeUnit.MILLISECONDS).map { i -> "Apple" },
												Observable.interval(150, TimeUnit.MILLISECONDS).map { i -> "Orange" })
												.take(10)
												.subscribe{ v -> println("Received: $v") }
												
						O/P:	Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple
								Received: Apple		
						The concat() operator is waiting for the first Observable to finish emitting values before it moves on to the next Observable . 
						But since our Observable are designed to run forever it will never move on to the next one.	

			filter():	Filter the values according to a set condition.
						e.g.:
								Observable.just(2, 30, 22, 5, 60, 1)
											.filter{ x -> x < 10 }
											.subscribe{ x -> println("Received: " + x) }
						
						O/P:	Received: 2
								Received: 5
								Received: 1
					
			repeat():	It will repeat the emission of the values however many times we may need.
						e.g.:
								Observable.just("Apple", "Orange", "Banana")
											.repeat(2)
											.subscribe { v -> println("Received: $v") }
											
						O/P:	Received: Apple
								Received: Orange
								Received: Banana
								Received: Apple
								Received: Orange
								Received: Banana			
								
			take():		It meant to grab however many emissions you’d like.
						e.g.
								Observable.just("Apple", "Orange", "Banana")
											.take(2)
											.subscribe { v -> println("Received: $v") }
			
						O/P:	Received: Apple
								Received: Orange
								
								
Disposable 	-	A Disposable will release memory, resources, and threads used by an Observable . 
				So, the main purpose of disposable is to free up system resources and make your app more stable.	
				e.g.
						Observable.just("Apple", "Orange", "Banana")
									.subscribeOn(Schedulers.io()) //Changing the thread
									.observeOn(AndroidSchedulers.mainThread())
									.subscribe(
										{ v -> println("Received: $v") }
									).dispose()
									
						You would be doing network calls with Schedulers.io() , and in this situation, you will get no results, 
						because since it changed threads the main thread called for disposal, thus erasing the work it was performing on the io thread.
						Remember when dealing with dispose() you should use it when you know for certain that your thread has finished. 
						The most elegant way of doing it is disposing of your Observable through the activity lifecycle, especially onDestroy
						
				CompositeDisposable:	
						
						val compositeDisposable = CompositeDisposable()

						val observableOne = Observable.just("Tree")
							.subscribe { v -> println("Received: $v") }
						val observableTwo = Observable.just("Blue")
							.subscribe { v -> println("Received: $v") }

						compositeDisposable.add(observableOne)
						compositeDisposable.add(observableTwo)
						compositeDisposable.clear()
						
						O/P: 	Reveived: Tree
								Received: Blue
								
								
PublishSubject :	PublishSubject works like an Observable and an Observer at the same time.
					Observer — Any object that wants to be notified when another object changes.
					Observable — Any object whose state may be of interest, and in whom another object may register an interest.
					So, a PublishSubject will receive the values as an Observer would and also emit it as an Observable would.	
			
Observer 	− 	It subscribes to Observable's data of sequence and reacts per item of the observables. 
				Observers are notified whenever Observable emits a data. An Observer handles data one by one.
			
				
				
				
				
				
				
				
Misc Operators:

Map		: transform the items emitted by an Observable by applying a function to each item
Zip		: combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function
Filter	: emit only those items from an Observable that pass a predicate test
FlatMap	: transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
Take	: emit only the first n items emitted by an Observable
Reduce	: apply a function to each item emitted by an Observable, sequentially, and emit the final value
Skip	: suppress the first n items emitted by an Observable
Buffer	: periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
Concat	: emit the emissions from two or more Observables without interleaving them
Replay	: ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
Merge	: combine multiple Observables into one by merging their emissions
SwitchMap: transform the items emitted by an Observable into Observables, and mirror those items emitted by the most-recently transformed Observable
			




**/
