package util

import java.io.File

val str = "this is a string, invoke it!"("wow, I am the argument!")
val strFile = "this is a string, invoke it!"(File(12.toLong().toString()))
val srtInt = "this is a string, invoke it!"(1)
val srtLong = "this is a string, invoke it!"(1.toLong())

fun main() {

    val greet = fun() { println("Hello") }
    val square = fun(x: Int) = x * x
    val square_ = { value: Int -> value * value }
    val producePrinter = fun() = fun() { println("I am printing") }

    invokeTwice(10)
    //println(square(5))
    //println(square.invoke(5))
    val function = MyFunction()
    function()

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

class MyFunction : () -> Unit {

    override fun invoke() {
        println("I am called")
    }
}


