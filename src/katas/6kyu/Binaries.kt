package katas.`6kyu`

import java.lang.StringBuilder
import kotlin.coroutines.CoroutineContext

/**
Let us take a string composed of decimal digits: "10111213". We want to code this string as a string of 0 and 1 and after that be able to decode it.

We decompose the given string in its decimal digits 1 0 1 1 1 2 1 3 and we will code each.

Coding process to code a number n expressed in base 10:
a) Let k be the number of bits of n

b) Put k-1 times the digit 0 followed by the digit 1

c) Put number n in binary

d) Concat the result of b) and c)

So we code 0 as 10, 1 as 11 ... etc...

Repeating this process with the initial string

"10111213" becomes : "11101111110110110111" resulting of concatenation of 11 10 11 11 11 0110 11 0111 .

Task:
Given strng a string of digits representing a decimal number the function code(strng) should return the coding of strng as explained above.

Given a string strng resulting from the previous coding, decode it to get the corresponding decimal string.

Examples:
code("77338855") --> "001111001111011101110001100000011000001101001101"
code("77338")  --> "0011110011110111011100011000"
code("0011121314") --> "1010111111011011011111001100"

decode("001111001111011101110001100000011000001101001101") -> "77338855"
decode("0011110011110111011100011000") -> "77338"
decode("1010111111011011011111001100") -> "0011121314"
Notes
SHELL: The only tested function is decode.
Please could you ask before translating : some translations are already written.
 */

var binary = "0011110011110111011100011000"

/**

77338

001 111    001 111    01 11    01 11    0001 1000

001 111   001 111   01 11   01 11  0001 1000    0001 1000   001 101    001 101
 */

// 9 1001

fun main() {
    println(decode(binary))
    println(code(77338.toString()))
}

fun code(str: String): String {
    val stringBuilder = StringBuilder()
    str.forEach {
        val bits = it.toString().toUInt().toString(radix = 2)
        repeat(bits.count() - 1) {
            stringBuilder.append("0")
        }
        stringBuilder.append("1").append(bits)
    }
    return stringBuilder.toString()
}

fun decode(str: String): String {
    val numList = arrayListOf<String>()
    var tempIndex = 0
    generateSequence(str) {
        if (it.isNotEmpty()) {
            if (it.first() == '1') {
                val restOf = it.drop(1)
                tempIndex++
                numList.add(restOf.take(tempIndex).toUInt(radix = 2).toString(radix = 10))
                val remaining = restOf.drop(tempIndex)
                tempIndex = 0
                remaining
            } else {
                tempIndex++
                it.drop(1)
            }
        } else null
    }.count()
    return numList.joinToString("")
}

/**
 *     val x = generateSequence("000") {
if (it.isNotEmpty()) {
binary = binary.replace(it.plus(1), " ")
it.dropLast(1)
} else null
}
x.forEach(::println)

binary.trim().split(" ").filter { it.isNotBlank() }.forEach {
println(it.toUInt(radix = 2).toString(radix = 10))
}
 */