package com.dicoding.kotlin.coroutines.latihan

import kotlinx.coroutines.*

suspend fun sum(valueA: Int, valueB: Int) : Int {
    delay(3000)
    return valueA + valueB
}

suspend fun multiple(valueA: Int, valueB: Int) : Int {
    delay(2000)
    return valueA * valueB
}

fun main() = runBlocking {
    println("Connecting...")

    val resultSum = async { sum(10, 10) }
    val resultMultiple = async { multiple(20, 20) }

    println("Result sum: ${resultSum.await()}")
    println("Result multiple: ${resultMultiple.await()}")
}