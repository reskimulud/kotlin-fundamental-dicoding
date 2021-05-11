package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.*

//fun main() = runBlocking<Unit> {
//    launch(Dispatchers.Unconfined) {
//        println("Starting in thread ${Thread.currentThread().name}")
//        delay(2000)
//        println("Resuming in ${Thread.currentThread().name}")
//
//    }.start()
//}

fun main() = runBlocking<Unit> {
    val dispatcher = newSingleThreadContext("myThread")
    launch(dispatcher) {
        println("Starting in thread ${Thread.currentThread().name}")
        delay(2000)
        println("Resuming in thread ${Thread.currentThread().name}")
    }.start()
}