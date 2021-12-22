package katas.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

/**
This is a series of Kotlin tricks.

As we all know, there're two ways to implement loops. while/for and recursion.

You're expected to use recursion. So you're not allowed to write while/for/all/none/any/Each/map/filter.

A function is given. It's using recursion. But the test case make it cases StackOverflowError.

Please do something to prevent it from raising an error.
 */

tailrec fun loop(random: Random, int: Int): Int {
    if (int <= 0) return random.nextInt()
    else {
        random.nextInt()
        return loop(random, int - 1)
    }
}

tailrec fun loop_(random: Random, int: Int): Int =
    if (int <= 0) random.nextInt() else loop_(random.apply { nextInt() }, int - 1)

fun loop__(random: Random, int: Int): Int {
    repeat(int) { random.nextInt() }
    return random.nextInt()
}

tailrec fun loop___(random: Random, int: Int): Int {
    val r = random.nextInt()
    return if (int <= 0) r else loop___(random, int - 1)
}

tailrec fun loop____(random: Random, int: Int): Int {
    when {
        int <= 0 -> return random.nextInt()
        else -> random.nextInt()
    }
    return loop____(random, int - 1)
}

class KotlinTricks4 {
    @Test
    fun loopTest() {
        fun loopTester(random: Random, int: Int): Int {
            (1..int).forEach { random.nextInt() }
            return random.nextInt()
        }
        (0..100).forEach {
            val i = System.currentTimeMillis()
            assertEquals(loopTester(Random(i), 10000), loop_(Random(i), 10000))
        }
    }
}