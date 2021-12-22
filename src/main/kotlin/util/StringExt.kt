package util


fun String.replace(vararg pairs: Pair<String, String>): String =
    pairs.fold(this) { acc, (old, new) -> acc.replace(old, new, ignoreCase = true) }

fun String.maxRepeatingForNumbers(x: Int = 0): Boolean {
    var count = 0
    this.reduce { acc, c ->
        if (Integer.valueOf(acc.toString()) + 1 == Integer.valueOf(c.toString())) count++
        c
    }
    if (count < 2) {
        count = 0
        this.reversed().reduce { acc, c ->
            if (Integer.valueOf(acc.toString()) + 1 == Integer.valueOf(c.toString())) count++
            c
        }
    }
    return count < 2
}

fun <T : Any, R : Any> safeLet(first: T?, second: R?, block: (first: T, second: R) -> Unit): Boolean {
    return if (first != null && second != null) {
        block(first, second)
        true
    } else false
}

val string = mutableListOf("a", "b", "c")
val x = string.joinToString(separator = "") { "- ".plus(it).plus("\n") }
