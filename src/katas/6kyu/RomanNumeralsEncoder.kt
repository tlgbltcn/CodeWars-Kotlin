package katas.`6kyu`

/**

Create a function taking a positive integer as its parameter and returning a string containing
the Roman Numeral representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and
skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Example:

encode(1000) // should return "M"
Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
Remember that there can't be more than 3 identical symbols in a row.
 */
fun main() {

    println(encode(1990))
    println(encode_(1990))
}

fun encode(num: Int): String {
    if (num == 0) return ""

    (0..mapRomanNumbers.size).forEach { i ->
        if (mapRomanNumbers[i].first <= num) {
            return mapRomanNumbers[i].second + encode(num - mapRomanNumbers[i].first)
        }
    }

    return ""
}

val mapRomanNumbers = arrayListOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)


/*********************** Best Practice *************************/

fun encode_(num: Int): String {
    tailrec fun encodeAux(num: Int, acc: String): String =
        if (num == 0) acc else {
            val (k, v) = numerals.first { it.second <= num }
            encodeAux(num - v, acc + k)
        }
    return encodeAux(num, "")
}

val numerals = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I").zip(
    listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
)