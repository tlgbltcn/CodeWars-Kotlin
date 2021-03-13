package katas.`6kyu`

/**
Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.

For example:

persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
// and 4 has only one digit

persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
// 1*2*6 = 12, and finally 1*2 = 2

persistence(4) == 0 // because 4 is already a one-digit number
 */
fun main() {
    println(persistence__(999))
}

fun persistence(num: Int): Int {
    return recursivePersistence(num, 0)
}

tailrec fun recursivePersistence(num: Int, times: Int): Int {
    return if (num < 10) times else
        recursivePersistence(
            num.toString()
                .toList()
                .map(Character::getNumericValue)
                .foldIndexed(0)
                { index, acc, c ->
                    if (index <= 0) c
                    else acc * c
                },
            times + 1
        )
}

/*********************** Best Practice *************************/

fun persistence_(num: Int) = generateSequence(num) {
    it.toString().map(Character::getNumericValue).reduce { mult, element -> mult * element }
}.takeWhile { it > 9 }.count()

fun persistence__(num: Int): Int =
    if (num < 10) 0 else 1 + persistence__(num.toString().map { it - '0' }.reduce(Int::times))

val zeroAscii = '0'.toInt()  // fixing the bug in tests
