package katas.`5kyu`

/**
 * My friend John and I are members of the "Fat to Fit Club (FFC)".
 * John is worried because each month a list with the weights of members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?

Example:
"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes: "100 180 90 56 65 74 68 86 99"

When two numbers have the same "weight", let us class them as if they were strings and not numbers: 100 is before 180
because its "weight" (1) is less than the one of 180 (9) and 180 is before 90 since, having the same "weight" (9), it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.

Notes
it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers
Don't modify the input
 */

fun main() {
    println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"))

}


fun orderWeight(string: String) =
    string.split(" ").map { it.sumOfDigits() }.sortedWith(compareBy({ it.second }, { it.first }))
    .joinToString(" ") { it.first }

fun String.sumOfDigits() : Pair<String, Int> {
    val list = this.toList()
    val listOfInt = list.map { it.toString().toInt() }
    return Pair(this, listOfInt.sum())
}

/*********************** Best Practice *************************/

fun orderWeightt(string:String):String {
    return string.split(" ")
        .sortedWith(compareBy<String>{ it.toCharArray().map(Char::toString).map(String::toInt).sum() }.thenBy{ it })
        .joinToString(" ")
}


fun orderWeighttt(i: String) = i.split(' ').sortedWith(compareBy({ it.sumBy { it - '0' } }, { it })).joinToString(" ")


fun orderWeightttt(string:String):String {

    val list = mutableListOf<Pair<Int, String>>()
    string.split(" ").forEach { fat -> list.add(fat.sumBy { Integer.valueOf(it.toString()) } to fat) }
    return list.sortedWith(Comparator { o1, o2 ->
        if (o1.first == o2.first) {
            o1.second.compareTo(o2.second)
        } else
            o1.first.compareTo(o2.first)
    })
        .map { it.second }
        .joinToString(separator = " ") { it }
}

fun orderWeighttttt(s: String) = ("\\d+").toRegex().findAll(s).map { it.value }
    .sortedWith(compareBy<String> { it.map(Character::getNumericValue).sum() }.thenBy { it })
    .joinToString(" ")


fun orderWeightttttt(input:String):String {
    val numbers = input.split(" ").filter { it.isNotEmpty() }
    val groups = numbers.groupByTo(java.util.TreeMap()) { it.fold(0) { a, c -> a + c.toString().toInt() } }
    return groups.values.flatMap { it.sort(); it }.joinToString(" ")
}

fun orderWeighttttttt(string:String):String {
    return string.trim().split(Regex("\\s+"))
        .sortedWith(compareBy<String> { it.map { char -> char.toString().toInt() }.sum() }.thenBy { it })
        .joinToString(" ")
}

fun orderWeightttttttt(string: String) = string.split(" ").sorted().sortedBy { s -> s.sumBy { it.toString().toInt() } }.joinToString(" ")


fun orderWeighttttttttt(string:String) =
    string.split(" ").sortedWith( compareBy({it.map { c -> c.toString().toInt() }.sum()}, {it}) ).joinToString(" ")

fun orderWeightttttttttt(string:String):String = string.split(" ").sortedWith(compareBy({it.toCharArray().sumBy { char -> char.toString().toInt() }}, {it})).joinToString(" ", "", "")
