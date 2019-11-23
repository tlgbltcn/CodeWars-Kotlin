package katas.`8kyu`

/**
 * Given an array of integers.

Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers.

If the input array is empty or null, return an empty array.

Example
For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
 */

fun countPositivesSumNegatives(input: Array<Int>?) = if (input.isNullOrEmpty()) emptyArray() else

    input.run { arrayOf(input.toList().filter(::checkPositive).count(), input.filterNot(::checkPositive).sum()) }

fun checkPositive(number: Int): Boolean = number > 0

fun countPositivesSumNegativess(input: Array<Int>?) = input?.takeIf { !it.isNullOrEmpty() }?.let {
    val (positive, negative) = input.partition { it > 0 }
    arrayOf(positive.count(), negative.sum())
} ?: emptyArray()

fun countPositivesSumNegativesss(input: Array<Int>?) = input?.takeIf { it.isNotEmpty() }
    ?.let { listOf(it.filter { it > 0 }.count(), it.filter { it < 0 }.sum()) }?.toTypedArray() ?: arrayOf()

fun main() {

    countPositivesSumNegatives(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15)).map(::print)
}