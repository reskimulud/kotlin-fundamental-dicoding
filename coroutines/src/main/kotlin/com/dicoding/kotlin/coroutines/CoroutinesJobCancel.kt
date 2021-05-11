package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        delay(5000L)
        println("New task")
    }

    delay(2000L)
    job.cancel()
    println("Canceling job")
    if (job.isCancelled) {
        println("Job cancelled")
    }
}