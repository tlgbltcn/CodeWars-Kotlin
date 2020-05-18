package util

fun main() {
    val expression = arrayOf("<>", "<>><")
    val maxReplacements = arrayOf(1, 0)
    println(balancedOrNot(expression = expression, maxReplacements = maxReplacements).forEach(::println))

    println(arrange(otherOne))
}

fun balancedOrNot(expression: Array<String>, maxReplacements: Array<Int>): Array<Int> {
    val balancedOrNot = IntArray(expression.size)
    expression.forEachIndexed { index, _ ->
        var formatted = expression[index]
        do {
            formatted = formatted.replace("<>".toRegex(), "")
            if (!formatted.contains("<>")) break
        } while (true)
        if (maxReplacements[index] >= formatted.length) balancedOrNot[index] = 1
        else balancedOrNot[index] = 0
    }
    return balancedOrNot.toTypedArray()
}

val otherOne = "The lines are printed in reverse order."

fun arrange(sentence: String): String {
    return sentence
        .split(" ")
        .sortedWith(comparator = compareBy { it.length })
        .joinToString(separator = " ", transform = { it.toLowerCase() })
        .replace(regex = Regex("[.][A-Z][a-z]"), replacement = " ")
        .capitalize()
}




