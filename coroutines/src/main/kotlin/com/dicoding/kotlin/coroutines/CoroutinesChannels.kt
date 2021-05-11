package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking(CoroutineName("main")) {
    val channels = Channel<Int>()
    launch(CoroutineName("v1coroutine")) {
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) {
            delay(1000)
            channels.send(x * x)
        }
    }

    repeat(5) {println(channels.receive())}
    println("Receive in thread ${Thread.currentThread().name}")
}