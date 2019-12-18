package katas.`3kyu`

import org.junit.Ignore
import org.junit.Test
import java.lang.RuntimeException
import java.util.*
import kotlin.NoSuchElementException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import java.util.Optional.empty as none
import java.util.Optional.of as some

/**
 * Let's build a simple for-comprehension DSL in kotlin!

Look, I have a function like this:

import java.util.Optional
fun plus(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> {
if (o1.isPresent && o2.isPresent)
return Optional.of(o1.get() + o2.get())
else
return Optional.empty()
}
I can rewrite it with a more functional style:

fun plus(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> =
o1.flatMap { i1 ->
o2.flatMap { i2 ->
Optional.of(i1 + i2)
}
}
o1.flatMap {...} means if o1 is not empty, invoke the closure with the value wrapped in o1 and then use the result of the closure as the return value of flatMap. Otherwise (if o1 is empty) discard the closure and simply return Optional.empty(). As you can see, this code does the same thing as the original code.

In Scala, we can do it in a more elegant way called for-comprehension.

// this is scala, not kotlin
def plus(o1: Option[Int], o2: Option[Int]) = {
for {
i1 <- o1
i2 <- o2
} yield i1 + i2
}
// it's equivalent to
// o1.flatMap(i1 => o2.flatMap(i2 => Some(i1 + i2)))
But Kotlin has no similar feature to achieve this!

So in this kata, your task is to build a simple for-comprehension DSL in Kotlin, enable you to write the following code (like Scala):

fun plus(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> =
`for` {
val i1: Int = bind(o1)
val i2: Int = bind(o2)
yield(i1 + i2)
}
// it's required to be equivalent to
// o1.flatMap { i1 -> o2.flatMap { i2 -> Optional.of(i1 + i2) } }
Don't worry, this DSL is only used for java.util.Optional, you don't need to deal with other types. Most of the test cases have already been provided for you. (

Additionally, we've banned try and catch keywords. if you use them or write those words in the comment/string, you'll get error.
 */

fun main() {

    val o1: Optional<Int> = Optional.empty()
    val o2: Optional<Int> = Optional.of(4)

    print(plus(o1, o2))
}

fun plus(o1: Optional<Int>, o2: Optional<Int>) =
    `for` {
        val i1: Int = bind(o1)
        val i2: Int = bind(o2)
        yield(i1 + i2)
    }

fun <T> `for`(lambda: () -> Optional<T>): Optional<T> =
    runCatching(lambda).getOrElse { exception ->
        when (exception) {
            is NoSuchElementException -> Optional.empty()
            else -> throw exception
        }
    }

fun <T> yield(value: T): Optional<T> = Optional.of(value)

fun <T> bind(optional: Optional<T>): T = optional.get()


fun failNoSuchElement(): Nothing {
    throw NoSuchElementException()
}

// Traditional Way
fun pluss(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> {
    if (o1.isPresent && o2.isPresent)
        return Optional.of(o1.get() + o2.get())
    else
        return Optional.empty()
}

class SimpleForComprehensionTest {

    @Test
    fun test1_IntAddition() {
        fun plus(
            o1: java.util.Optional<Int>,
            o2: java.util.Optional<Int>
        ): java.util.Optional<Int> =
            `for` {
                val i: Int = bind(o1)
                val j: Int = bind(o2)
                yield(i + j)
            }

        fun testPlus(
            expected: java.util.Optional<Int>,
            o1: java.util.Optional<Int>, o2: java.util.Optional<Int>
        ) {
            val actual = plus(o1, o2)
            assert(expected == actual) { "$o1 plus $o2 should be $expected, but you give me a $actual" }
        }

        val nothing = none<Int>()
        testPlus(some(6), some(4), some(2))
        testPlus(nothing, nothing, some(2))
        testPlus(nothing, some(4), nothing)
        testPlus(nothing, nothing, nothing)
    }

    @Test
    fun test2_StringConcat() {
        /**
         * If [o1] gets empty, [o2] should never be used!
         */
        fun concat(
            o1: () -> java.util.Optional<String>,
            o2: () -> java.util.Optional<String>
        ): java.util.Optional<String> =
            `for` {
                val i: String = bind(o1())
                val j = " is "
                val k: String = bind(o2())
                yield(i + j + k)
            }

        class ThisCodeShouldBeExecuted : RuntimeException()
        class ThisCodeShouldNotBeExecuted : RuntimeException()

        val nothing = none<String>()
        assertFailsWith<ThisCodeShouldBeExecuted> {
            concat(
                { throw ThisCodeShouldBeExecuted() },
                { throw ThisCodeShouldNotBeExecuted() })
        }
        assertFailsWith<ThisCodeShouldBeExecuted> {
            concat(
                { some("ice1000 is julao") },
                { throw ThisCodeShouldBeExecuted() })
        }
        assertEquals(nothing, concat({ nothing }, { throw ThisCodeShouldNotBeExecuted() }))
        assertEquals(some("ice1000 is julao"), concat({ some("ice1000") }, { some("julao") }))
        assertEquals(nothing, concat({ some("ice1000") }, { nothing }))
        assertEquals(nothing, concat({ nothing }, { some("julao") }))
        assertEquals(nothing, concat({ nothing }, { nothing }))
    }

    @Test
    fun test3_EatRice() {
        val sb: java.util.Optional<StringBuilder> = `for` {
            val i: Int = bind(some(1551))
            val s: CharSequence = bind(`for` { yield("ywwuyi") })
            var sb: StringBuilder = bind(some(StringBuilder(100)))
            repeat(10) {
                sb = bind(some(sb.append(i).append(s)))
            }
            yield(sb)
        }
        assertEquals("1551ywwuyi".repeat(10), sb.get().toString())
    }

    @Test
    @Ignore
    fun test4_RandomIntAddition() {
        fun plus(
            o1: java.util.Optional<Int>,
            o2: java.util.Optional<Int>
        ): java.util.Optional<Int> =
            `for` {
                val i: Int = bind(o1)
                val j: Int = bind(o2)
                yield(i + j)
            }

        fun okPlus(o1: java.util.Optional<Int>, o2: java.util.Optional<Int>) =
            o1.flatMap { i1 -> o2.flatMap { i2 -> some(i1 + i2) } }

        val random = java.util.Random()
        fun getRandomInt() =
            java.util.Optional.ofNullable(random.nextInt(1_0000_0000).takeIf { it < (1_0000_0000 * 0.618) })

        repeat(100) {
            val o1 = getRandomInt()
            val o2 = getRandomInt()
            val expected = okPlus(o1, o2)
            val actual = plus(o1, o2)
            assert(expected == actual) { "$o1 plus $o2 should be $expected, but you give me a $actual" }
        }
    }

    @Test
    fun dont_use_try_and_catch() {
        java.nio.file.Files.lines(java.io.File("/home/codewarrior/solution.txt").toPath()).forEach { str ->
            assertFalse("\\u" in str)
            assertFalse("try" in str)
            assertFalse("catch" in str)
        }
    }
}

