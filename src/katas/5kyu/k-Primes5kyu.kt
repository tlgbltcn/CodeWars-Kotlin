package katas.`5kyu`

/**
 * k = 2  -->  4, 6, 9, 10, 14, 15, 21, 22, ...
k = 3  -->  8, 12, 18, 20, 27, 28, 30, ...
k = 5  -->  32, 48, 72, 80, 108, 112, ...
A natural number is thus prime if and only if it is 1-prime.

Task:
Complete the function count_Kprimes (or countKprimes, count-K-primes, kPrimes)
which is given parameters k, start, end (or nd) and returns an array (or a list or a string depending on the language - see "Solution" and "Sample Tests") of the k-primes between start (inclusive) and end (inclusive).

Example:
countKprimes(5, 500, 600) --> [500, 520, 552, 567, 588, 592, 594]
Notes:

The first function would have been better named: findKprimes or kPrimes :-)
In C some helper functions are given (see declarations in 'Solution').
For Go: nil slice is expected when there are no k-primes between start and end.
Second Task (puzzle):
Given positive integers s, a, b, c where a is1-prime, b is 3-prime, c is 7-prime,
find the total number of solutions where a + b + c = s. Call this function puzzle(s).

Examples:
puzzle(138)  -->  1  because [2 + 8 + 128] is the only solution
puzzle(143)  -->  2  because [3 + 12 + 128] and [7 + 8 + 128] are the solutions
 */

fun main() {
    countKprimes(5, 500, 600)
    println(puzzle(138))
    println(puzzle(143))

}

fun countKprimes(k: Int, start: Long, end: Long) = k.primes_(end, start).map { it.toLong() }.toLongArray()

fun puzzle(s: Int): Int {
    var result = 0
    countKprimes(1, 1, s.toLong()).forEach { i ->
        countKprimes(3, 1, s.toLong()).forEach { j ->
            repeat(
                countKprimes(7, 1, s.toLong())
                    .asSequence()
                    .filter { i + j + it == s.toLong() }.count()
            ) { result++ }
        }
    }
    return result
}


fun Int.k_prime_(x: Long): Boolean {
    var n = x
    var f = 0
    var p = 2
    while (f < this && p * p <= n) {
        while (0 == n.toInt() % p) {
            n /= p; f++
        }
        p++
    }
    return f + (if (n > 1) 1 else 0) == this
}

fun Int.primes_(n: Long, start: Long): List<Int> {
    var i = start
    val list = mutableListOf<Int>()
    while (i < n + 1) {
        if (k_prime_(i)) list.add(i.toInt())
        i++
    }
    return list
}

/*********************** Best Practice *************************/

fun countKprimess(k: Int, start: Long, end: Long): LongArray {
    return (start..end).filterTo(ArrayList()) { found(it) + 1 == k }.toLongArray()
}

tailrec fun found(input: Long, primes: Int = 2, count: Int = 0): Int {
    return if (primes <= input / primes && (input % primes).toInt() != 0) found(input, primes + 1, count)
    else if (primes <= input / primes) found(input / primes, 2, count + 1)
    else count
}

fun puzzlee(s: Int): Int {
    val aarray = countKprimes(1, 2, s.toLong())
    val barray = countKprimes(3, 8, s.toLong())
    val carray = countKprimes(7, 128, s.toLong())
    var count = 0

    carray.map { s - it }.forEach {
        for (b in barray) {
            if (b > it) {
                return@forEach
            }
            val remain2 = it - b
            if (aarray.contains(remain2)) {
                count++
            }
        }
    }
    return count
}



