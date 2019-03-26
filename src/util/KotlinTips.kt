package util

import java.io.File

val square = { value: Int -> value * value }

val str = "this is a string, invoke it!"("wow, I am the argument!")
val strFile = "this is a string, invoke it!"(File(12.toLong().toString()))
val srtInt = "this is a string, invoke it!"(1)
val srtLong = "this is a string, invoke it!"(1.toLong())

fun main() {
    invokeTwice(10)
    //println(square(5))
    //println(square.invoke(5))
}

operator fun <T> String.invoke(obj: T): T = obj

//operator fun <reified E : Any> String.invoke(value : E) = value

operator fun String.invoke(s: String): String = s

operator fun String.invoke(t: Long): Long = t

operator fun String.invoke(i: Int): Int = i

operator fun String.invoke(f: File): File = f

operator fun Long.invoke(): Long {
    var x = this
    println(x++)

    return x
}

fun invokeTwice(inv: Long) = inv()()()
