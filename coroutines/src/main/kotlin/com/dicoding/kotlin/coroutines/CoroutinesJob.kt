package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.*

// menjalankan job

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {
    val job = launch(Dispatchers.Default, start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Start new job")
    }

    // job.start() // job dijalankan tanpa menunggu job tersebut selesai
    job.join() //job akan dijalankan dengan menunggu job tersebut selesai
    println("Other task")

    println()
    delay(10000L)
    job.cancel(cause = CancellationException("Times is up..."))
    println("Cancelling job....")
    if (job.isCompleted) {
        println("Job cancelled ${job.getCancellationException().message}")
    }
}