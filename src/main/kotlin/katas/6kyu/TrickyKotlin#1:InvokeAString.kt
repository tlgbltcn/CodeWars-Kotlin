package katas.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.invoke
import java.io.File
import java.util.*

/**
 * This is a series of Kotlin tricks.

In this Kata, you should make this compiles:

"this is a string, invoke it!"("wow, I am the argument!")
Whatever the argument is, just return the argument. There will be only one argument.

The example tests is the same as the final tests.
 */

fun main() {

    val str = "this is a string, invoke it!"("wow, I am the argument!")
    val strFile = "this is a string, invoke it!"(File(12.toLong().toString()))
    val strInt = "this is a string, invoke it!"(1)
    val strLong = "this is a string, invoke it!"(1.toLong())

    str.invoke(str)
    str.invoke(strFile)
    str.invoke(strInt)
    str.invoke(strLong)
}

operator fun <T> String.invoke(obj: T): T = obj

//operator fun <reified E : Any> String.invoke(value : E) = value

operator fun String.invoke(s: String): String = s

operator fun String.invoke(t: Long): Long = t

operator fun String.invoke(i: Int): Int = i

operator fun String.invoke(f: File): File = f


class KotlinTricks0 {
    @Test
    fun testString() {
        assertEquals("wow, I am the argument!", "this is a string, invoke it!"("wow, I am the argument!"))
        assertEquals("s", "this is a string, invoke it!"("s"))
    }

    @Test
    fun testInt() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextInt().let { assertEquals(it, "this is another string"(it)) } }
    }

    @Test
    fun testLong() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextLong().let { assertEquals(it, "oh come on!"(it)) } }
    }

    @Test
    fun testFile() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach {
            r.nextLong().let { assertEquals(File(it.toString()), "oh come on!"(File(it.toString()))) }
        }
    }
}