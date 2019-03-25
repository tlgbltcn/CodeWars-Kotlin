package katas.`5kyu`

import java.math.BigInteger

/**
 * The aim of the kata is to decompose n! (factorial n) into its prime factors.

Examples:

n = 12; decomp(12) -> "2^10 * 3^5 * 5^2 * 7 * 11"
since 12! is divisible by 2 ten times, by 3 five times, by 5 two times and by 7 and 11 only once.

n = 22; decomp(22) -> "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"

n = 25; decomp(25) -> 2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23
Prime numbers should be in increasing order. When the exponent of a prime is 1 don't put the exponent.

Notes

the function is decomp(n) and should return the decomposition of n! into its prime factors in increasing order of the primes, as a string.
factorial can be a very big number (4000! has 12674 digits, n will go from 300 to 4000).
In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing whitespace: you can use dynamically allocated character strings.

 */

fun main() {
    print(decomp(300))
}

fun decomp(m: Int) = sharredFact(getFactorial(m), 1, arrayListOf())
    .map { it.first }
    .groupingBy { it }
    .eachCount()
    .map { if (it.value != 1) "${it.key}^${it.value}" else "${it.key}" }
    .joinToString(" * ")

tailrec fun sharredFact(n: BigInteger, prime: Int, list: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>> {
    var t = n
    var count = 0
    val nextPrime = primeFactory(prime)
    while (t % nextPrime.toBigInteger() == 0.toBigInteger()) {
        count++
        list.add(Pair(nextPrime, count))
        t /= nextPrime.toBigInteger()
    }
    return if (t != 1.toBigInteger()) sharredFact(t, prime + 1, list) else return list
}

tailrec fun primeFactory(n: Int): Int {
    return if (!(n + 1).toLong().isPrime_()) primeFactory(n + 1) else n + 1
}

fun Long.isPrime_(): Boolean {
    val bigInt = BigInteger.valueOf(this)
    return bigInt.isProbablePrime(32)
}

fun getFactorial(number: Int): BigInteger {
    var factorial: BigInteger = 1.toBigInteger()
    for (i in 1..number) factorial *= i.toBigInteger()
    return factorial
}

