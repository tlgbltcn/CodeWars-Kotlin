package katas.`6kyu`

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.util.*


/**
 * This is a series of Kotlin tricks.

In this kata you should define a function that concat two strings.

BUT, you cannot use the keyword fun, and symbols { , }.

The example test is exactly the same as the final test.

Enjoy!
 */

fun main() {
    println(concatString("tolga", "bolatcan"))
}

fun concat1(s: String, s2: String) = s + s2

val concat2: (s1: String, s2: String) -> String = { s1, s2 -> if (true) s1 + s2 else s2 + s1 }

data class concat3 constructor(var s1: String, var s2: String, var s: String = s1 + s2)

val concat4: (s1: String, s2: String) -> String = { s1, s2 -> s1 + s2 }

val concat5: (s1: String, s2: String) -> String = fun(x, t) = x + t

fun concat6(s1: String, s2: String) = s1 + s2

val concatString_: (String, String) -> String = String::plus

val concatString__: (s1: String, s2: String) -> String = String::plus

val concatString = String::plus

/*********************** Tests *************************/

class KotlinTricks3 {
    @Test
    fun cannotUseFun() = try {
        Files.lines(File("/home/codewarrior/solution.txt").toPath()).forEach { line ->
            assertFalse { "fun" in line }
            assertFalse { "{" in line }
            assertFalse { "}" in line }
        }
    } catch (e: IOException) {
        fail("Failed to read the source file.")
    }

    @Test
    fun fixedTest() {
        assertEquals("ice1000", concat3("ice", "1000"))
    }

    @Test
    fun randomTest() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach {
            val a = r.nextInt().toString(2)
            val b = r.nextInt().toString(2)
            assertEquals(a + b, concat3(a, b))
        }
    }
}

