package katas.`6kyu`

/**
Create a function that takes a Roman numeral as its argument and returns its value as a numeric decimal integer. You don't need to validate the form of the Roman numeral.

Modern Roman numerals are written by expressing each decimal digit of the number to be encoded separately, starting with the leftmost digit and skipping any 0s. So 1990 is rendered "MCMXC" (1000 = M, 900 = CM, 90 = XC) and 2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). The Roman numeral for 1666, "MDCLXVI", uses each letter in descending order.

Example:

decode("XXI") // should return 21
Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
 */
fun main() {
    println(romanNumeralsDecoder(""))
}

fun romanNumeralsDecoder(str: String): Int {
    return recursiveDecoder(str, 0)
}

tailrec fun recursiveDecoder(str: String, sum: Int): Int =
    if (str.isEmpty()) sum else {
        val (num, remain) = str.splitAtIndex(2)
        if (romanNumeralss[num] != null)
            recursiveDecoder(remain, sum + (romanNumeralss[num] ?: 0))
        else
            recursiveDecoder(num.drop(1).plus(remain), sum + (romanNumeralss[num.dropLast(1)] ?: 0))
    }

fun String.splitAtIndex(index: Int) = when {
    index < 0 -> 0
    index > length -> length
    else -> index
}.let {
    take(it) to substring(it)
}

val romanNumeralss = mapOf(
    "M" to 1000,
    "CM" to 900,
    "D" to 500,
    "CD" to 400,
    "C" to 100,
    "XC" to 90,
    "L" to 50,
    "XL" to 40,
    "X" to 10,
    "IX" to 9,
    "V" to 5,
    "IV" to 4,
    "I" to 1
)