package katas.`6kyu`

/**
You are given an array (which will have a length of at least 3,
but could be very large) containing integers.
The array is either entirely comprised of odd integers or entirely comprised of even integers except for
a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples

[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)

 */

fun main(args: Array<String>) {

    //print(find(arrayOf(2, 4, 0, 100, 4, 11, 2602, 36)))
    print(find(arrayOf(160, 3, 1719, 19, 11, 13, -21)))
}

fun find(integers: Array<Int>): Int {
    var odd = 0
    var even = 0
    var result = 0
    if (integers.size == 2) return 0

    integers.map { it.isOddNumber() }.forEach {
        when (it) {
            true -> odd++
            else -> even++
        }
    }

    result = if (odd > even) {
        integers.first { !it.isOddNumber() }
    } else {
        integers.first { it.isOddNumber() }
    }

    return result
}

fun Int.isOddNumber(): Boolean = this % 2 == 0


/*********************** Alternatives *************************/

fun find___(integers: Array<Int>): Int {
    val partitionedArray = integers.partition { it % 2 == 0 }
    return if (partitionedArray.first.size == 1) partitionedArray.first[0] else partitionedArray.second[0]
}

/*********************** Alternatives *************************/


fun find_(integers: Array<Int>): Int {
    val evens = integers.filter { it % 2 == 0 }
    return if (evens.size == 1) {
        evens[0]
    } else { // find the odd
        integers.find { it % 2 != 0 }!!
    }
}

/*********************** Alternatives *************************/

fun find__(integers: Array<Int>): Int {
    val odds = integers.filter { (it % 2 == 1) || (it % 2 == -1) }
    val evens = integers.filter { it % 2 == 0 }
    if (odds.size == 1) {
        return odds[0]
    }
    return evens[0]
}