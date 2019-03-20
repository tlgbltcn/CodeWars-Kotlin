package katas.`6kyu`

/**
 * A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity.

A natural number is thus prime if and only if it is 1-prime.

Examples of k-primes:
k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, …
k = 3 -> 8, 12, 18, 20, 27, 28, 30, …
k = 5 -> 32, 48, 72, 80, 108, 112, …
The k-prime numbers are not regularly spaced. Between 2 and 50 we have the following 2-primes:

[4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49]

The steps between two consecutive k-primes are 2, 3, 1, 4, 1, 6, 1, 3, 1, 7, 1, 1, 3, 1, 7, 3.

We will write a function kprimes_step(k, step, start, nd) with parameters:

k (integer > 0) which indicates the type of k-primes we are looking for,

step (integer > 0) which indicates the step we want to find between two k-primes,

start (integer >= 0) which gives the start of the search (start inclusive),

nd (integer >= start) which gives the end of the search (nd inclusive)

In the example above kprimes_step(2, 2, 0, 50) will return [[4, 6], [33, 35]] which are the pairs of 2-primes between 2 and 50 with a 2 steps.

So this function should return an array of all the pairs (or tuples) of k-prime numbers spaced with a step of step between the limits start, nd. This array can be empty.

Examples:
kprimes_step(2, 2, 0, 50) => [[4, 6], [33, 35]]
kprimes_step(6, 14, 2113665, 2113889) => [[2113722, 2113736]])
kprimes_step(2, 10, 0, 50) => [[4, 14], [15, 25], [25, 35], [39, 49]]
kprimes_step(5, 20, 0, 50) => []
 */

fun main() {

    kprimesStep(2, 7, 246709, 247185).forEach(::print)
}

fun kprimesStep(k: Int, step: Int, start: Long, nd: Long): List<LongArray> {

    val list = arrayListOf<LongArray>()
    val allList = k.primes(nd, start)
    allList.map { if (allList.contains(it + step)) list.add(longArrayOf(it.toLong(), (it + step).toLong())) }
    return list
}

fun Int.k_prime(x: Int): Boolean {
    var n = x
    var f = 0
    var p = 2
    while (f <= this && p * p <= n) {
        while (0 == n % p) n /= p; f++
        p++
    }
    return f + (if (n > 1) 1 else 0) == this
}

fun Int.primes(n: Long, start: Long): List<Int> {
    var i = start.toInt()
    val list = mutableListOf<Int>()
    for (t in i..n.toInt() + 1) {
        if (k_prime(t)) list.add(t)
        i++
    }
    return list
}

/*********************** Best Practice *************************/

fun getFactors(number: Long): List<Long> {
    for (i in 2..number) {
        if (number % i == 0L) {
            return listOf(i).plus(getFactors(number / i))
        }
    }
    return emptyList()
}

fun kprimesStepp(k: Int, stp: Int, start: Long, end: Long): List<LongArray> {
    var kFactorNumbers = (start..end)
        .filter { getFactors(it).size == k }

    val result = mutableListOf<LongArray>()
    kFactorNumbers.forEach {
        if (it + stp in kFactorNumbers) result.add(longArrayOf(it, it + stp))
    }

    return result
}
