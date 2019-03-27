package katas.`6kyu`

import org.junit.Test
import kotlin.test.assertEquals

/**
 * This is a series of Kotlin tricks.

In this Kata you should implement three fundamental functions:

unless (the opposite of if)
until (the opposite of while)
forceRun (whatever happens (exceptions? errors?), just make it continue)
The example tests are nearly the same as the final tests(just some more robust tests). This is why I provide such poor initial solution.
 */

private fun unless(boolean: Boolean, function: () -> Unit) {
    if (boolean.not()) function()
}

private fun until(function: () -> Boolean, function1: () -> Int) {
    while (function.invoke().not()) function1()
}

private fun forceRun(function: () -> Unit) = try {
    function()
} catch (e: Exception) {
}


class KotlinTricks2 {
    private fun testUnlessHelper(boolean: Boolean) {
        var int = 1
        unless(boolean) { int = 2 }
        assertEquals(if (boolean) 1 else 2, int)
    }

    private fun testUntilHelper(boolean: Int) {
        var int = 1
        var cond = boolean
        until({ (cond--) == 0 }) { int++ }
        assertEquals(boolean + 1, int)
    }

    @Test
    fun testUnless() {
        val r = java.util.Random(System.currentTimeMillis())
        (0..30).forEach { testUnlessHelper(r.nextBoolean()) }
    }

    @Test
    fun testUntil() {
        val r = java.util.Random(System.currentTimeMillis())
        (0..30).forEach { testUntilHelper(Math.abs(r.nextInt(10))) }
    }

    @Test
    fun testForceRun() {
        val r = java.util.Random(System.currentTimeMillis())
        (0..30).forEach { forceRun { listOf(1)[r.nextInt()] } }
        var a = 1
        forceRun { a = 2 }
        assertEquals(a, 2)
    }
}
