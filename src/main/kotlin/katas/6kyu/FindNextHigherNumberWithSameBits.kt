package katas.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


/**
Your task is to Find the next higher number (int) with same '1'- Bits.

I.e. as much '1' bits as before and output next higher than input. Input is always an int >0 up to 1<<30. No bad cases or special tricks...

Some easy examples:

Input: 129  => Output: 130 (10000001 => 10000010)
Input: 1022  => Output: 1279 (1111111110 => 10011111111) 10111111110
Input: 127 => Output: 191 (01111111 => 10111111)
Input: 1 => Output: 2 (01 => 10)
Input: 323423 => Output: 323439 (1001110111101011111 => 1001110111101101111)
First some static tests, later on many random tests too;-)!
 */

fun main() {
    println(nextHigher(1022))
    println(__nextHigher(127))
}

fun nextHigher(n: Int): Int {
    val bits = String.format("%" + 20 + "s", n.toString(radix = 2)).replace(" ".toRegex(), "0").reversed()
    val next = StringBuilder()
    var isChange = false
    bits.reduce(operation = { acc, cursor ->
        if ((acc != cursor) and (acc > cursor) and !isChange) {
            next.append(cursor)
            next.append(acc)
            isChange = true
        } else next.append(acc)
        cursor
    })

    return Integer.parseInt(next.reversed().toString(), 2);
}

fun _nextHigher(n: Int): Int {
    val right: Int = n.and(-n)
    val nextHigher = n + right
    var rightXorBitwise = n xor nextHigher
    rightXorBitwise /= right
    rightXorBitwise = rightXorBitwise.shr(2)
    return nextHigher or rightXorBitwise
}

fun __nextHigher(n: Int): Int {
    val bits = "0" + n.toString(2)
    val idx = bits.lastIndexOf("01")
    val movedBits = bits.take(idx) + "10" + bits.drop(idx + 2).toCharArray().sorted().joinToString("")
    return movedBits.toInt(2)
}

fun ___nextHigher(n: Int): Int {
    val o = n and -n
    return n + o or ((n xor n + o) / o shr 2)
}

fun nbOne(n: Int) = n.toString(2).count { it == '1' }
fun ____nextHigher(n: Int): Int {
    var m = n + 1
    while (nbOne(m) != nbOne(n)) m++
    return m
}

class TestKata {
    @Test
    fun basicTests() {
        assertEquals(256, __nextHigher(128))
        assertEquals(2, __nextHigher(1))
        assertEquals(1279, __nextHigher(1022))
        assertEquals(191, __nextHigher(127))
        assertEquals(1253359, __nextHigher(1253343))
    }
}