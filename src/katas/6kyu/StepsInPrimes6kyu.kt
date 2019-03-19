package katas.`6kyu`

import java.math.BigInteger

/**
 * The prime numbers are not regularly spaced. For example from 2 to 3 the step is 1.
 * From 3 to 5 the step is 2. From 7 to 11 it is 4. Between 2 and 50 we have the following pairs of 2-steps primes:

3, 5 - 5, 7, - 11, 13, - 17, 19, - 29, 31, - 41, 43

We will write a function step with parameters:

g (integer >= 2) which indicates the step we are looking for,

m (integer >= 2) which gives the start of the search (m inclusive),

n (integer >= m) which gives the end of the search (n inclusive)

In the example above step(2, 2, 50) will return [3, 5] which is the first pair between 2 and 50 with a 2-steps.

So this function should return the first pair of the two prime numbers spaced with a step of g between the limits m, n
if these g-steps prime numbers exist otherwise nil or null or None or Nothing or [] or "0, 0" or {0, 0} (depending on the language).

#Examples:

step(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7} or "5 7"

step(2, 5, 5) --> nil or ... or [] in Ocaml or {0, 0} in C++

step(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}

See more examples for your language in "RUN"
Remarks:
([193, 197] is also such a 2-steps primes between 130 and 200 but it's not the first pair).

step(6, 100, 110) --> [101, 107] though there is a prime between 101 and 107 which is 103; the pair 101-103 is a 2-step.

#Notes: The idea of "step" is close to that of "gap" but it is not exactly the same.
For those interested they can have a look at http://mathworld.wolfram.com/PrimeGaps.html.

A "gap" is more restrictive: there must be no primes in between (101-107 is a "step" but not a "gap". Next kata will be about "gaps":-).

For Go: nil slice is expected when there are no step between m and n. Example: step(2,4900,4919) --> nil
 */
fun main() {

    println(step(2, 100, 110)[0].toString() + " " + step(2, 100, 110)[1].toString())

}

fun step(g: Int, m: Long, n: Long): LongArray {
    var isFind = false
    val x = (m..n).toList().fold(m) { acc, l ->
        if (isFind) acc else {
            return@fold if (!acc.isPrime()) l else if ((acc + g).isPrime()) {
                isFind = true
                return@fold acc
            } else l
        }
    }

    return if (x == n) longArrayOf(0, 0) else longArrayOf(x, (x + g))
}

fun Long.isPrime(): Boolean {
    val bigInt = BigInteger.valueOf(this)
    return bigInt.isProbablePrime(32)
}

/*********************** Best Practice *************************/


fun stepp(g: Int, m: Long, n: Long) =
    (m..n - g).find { it.toBigInteger().isProbablePrime(10) && (it + g).toBigInteger().isProbablePrime(10) }?.let {
        longArrayOf(
            it,
            it + g
        )
    } ?: LongArray(0)


fun steppp(g: Int, m: Long, n: Long): LongArray {
    for (i in m..n) if (isPrimee(i) && isPrimee(i + g) && i + g <= n) return longArrayOf(i, i + g)
    return longArrayOf()
}

fun isPrimee(num: Long): Boolean {
    for (i in 2..num / 2)
        if (num % i == 0L) return false
    return true
}


fun stepppp(g: Int, m: Long, n: Long): LongArray =
    (m..n).zip(m + g..n)
        .find { it.first.isPrimeeee() && it.second.isPrime() }
        ?.toList().orEmpty().toLongArray()

val primes = sequenceOf(2L) + generateSequence(3L) { it + 2L }.filter(Long::isPrime)

fun Long.isPrimeeee(): Boolean = this > 1L && primes.takeWhile { it * it <= this }.all { this % it != 0L }
