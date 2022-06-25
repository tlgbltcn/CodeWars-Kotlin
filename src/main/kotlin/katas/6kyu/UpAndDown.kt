package katas.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Don't be afraid, the description is rather long but - hopefully - it is in order that the process be well understood.

You are given a string s made up of substring s(1), s(2), ..., s(n) separated by whitespaces. Example: "after be arrived two My so"

Task
Return a string t having the following property:

length t(O) <= length t(1) >= length t(2) <= length t(3) >= length t(4) .... (P)

where the t(i) are the substring of s; you must respect the following rule:

at each step from left to right, you can only move either already consecutive strings or strings that became consecutive after a previous move. The number of moves should be minimum.

Let us go with our example:
The length of "after" is greater than the length of "be". Let us move them ->"be after arrived two My so"

The length of "after" is smaller than the length of "arrived". Let us move them -> "be arrived after two My so"

The length of "after" is greater than the length of "two" ->"be arrived two after My so"

The length of "after" is greater than the length of "My". Good! Finally the length of "My" and "so" are the same, nothing to do. At the end of the process, the substrings s(i) verify:

length s(0) <= length s(1) >= length s(2) <= length s(3) >= length (s4) <= length (s5)

Hence given a string s of substrings s(i) the function arrange with the previous process should return a unique string t having the property (P).

It is kind of roller coaster or up and down. When you have property (P), to make the result more "up and down" visible t(0), t(2), ... will be lower cases and the others upper cases.

arrange("after be arrived two My so") should return "be ARRIVED two AFTER my SO"
Notes:
The string "My after be arrived so two" has the property (P) but can't be obtained by the described process so it won't be accepted as a result. The property (P) doesn't give unicity by itself.
Process: go from left to right, move only consecutive strings when needed.
For the first fixed tests the needed number of moves to get property (P) is given as a comment so that you can know if your process follows the rule.
 */

fun main() {
    println(arrange("after be arrived two My so")) // be ARRIVED two AFTER my SO
    println(arrange("who hit retaining The That a we taken")) // who RETAINING hit THAT a THE we TAKEN
    println(arrange("on I came up were so grandmothers")) // i CAME on WERE up GRANDMOTHERS so
    println(arrange("way the my wall them him")) // way THE my WALL him THEM

    println(arrange_("after be arrived two My so"))
}

fun arrange(strng: String): String {
    return strng.splitter(" ").swap().joinToString(" ")
}

val splitter: String.(String) -> MutableList<String> = { delimiter -> split(delimiter).toMutableList() }

fun <T> MutableList<T>.swapper(i: Int, j: Int): MutableList<T> {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
    return this
}

fun MutableList<String>.swap(): List<String> {
    var swapped: Boolean
    var switcher = false
    var index = size - 1
    while (index >= 1) {
        loop@ for (i in size - (index) until size) {
            swapped = false
            if (when {
                    switcher -> this[i].length > this[i - 1].length
                    else -> this[i].length < this[i - 1].length
                }
            ) {
                swapper(i = i, j = i - 1)
                swapped = true
            }
            switcher = !switcher
            index--
            if (swapped) break@loop
        }
    }

    return mapIndexed { i, string -> if ((i + 1) % 2 == 0) string.uppercase() else string.lowercase() }
}

/*********************** Alternatives *************************/

fun arrange_(strng: String): String {
    val p = strng.split(" ").toTypedArray()
    for (i in (0 until p.size - 1)) {
        val switch = if (i % 2 == 0) p[i].length > p[i+1].length else p[i].length < p[i+1].length
        if (switch) {
            val tmp = p[i]
            p[i] = p[i+1]
            p[i+1] = tmp
        }
    }
    return p.mapIndexed { i, v -> if (i % 2 == 1) v.toUpperCase() else v.toLowerCase() }.joinToString(" ")
}

/*********************** Tests *************************/

class ArrangeStringMainTest {
    @Test
    fun test() {
        println("Fixed Tests updown")
        assertEquals(arrange("who hit retaining The That a we taken"), "who RETAINING hit THAT a THE we TAKEN")
        assertEquals(arrange("on I came up were so grandmothers"), "i CAME on WERE up GRANDMOTHERS so")
        assertEquals(arrange("way the my wall them him"), "way THE my WALL him THEM")
    }
}
