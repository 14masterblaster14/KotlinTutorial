/*
*
*
*   --------------------------------
*
*
*           Difference between join and await.
* join waits for completion of launch.   await looks for the returned result.
*/

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


suspend fun helloSuspend() {
    println(" This is Suspending function")
}


fun main(Args: Array<String>) = runBlocking {

    println("Start of execution")

    //val x = launch(CommonPool){
    val x = async(CommonPool) {
        delay(4000)
        helloSuspend()
        println("inside launch")
    }

    x.await()
    println("Finished")
    // x.join()

    run {
        println("Inside run")
    }


}

