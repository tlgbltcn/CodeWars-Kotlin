package katas.`6kyu`

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * This is a series of Kotlin tricks.

As we all know, Kotlin supports something called extension methods, which means you can add some methods to some existing classes.

In this Kata, you should make some extension constructor. For example, you can add a constructor to kotlin.Int that accepts a String and parse the string to int.

You should add such extension constructor to kotlin.Int, kotlin.Long, kotlin.Double.
 */

operator fun Int.Companion.invoke(s: String) = s.toInt()

operator fun Long.Companion.invoke(s: String) = s.toLong()

operator fun Double.Companion.invoke(s: String) = s.toDouble()

class KotlinTrickss {
    @Test
    fun testInt() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextInt().let { assertEquals(it, Int(it.toString())) } }
    }
}