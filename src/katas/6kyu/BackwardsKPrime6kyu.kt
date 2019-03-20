package katas.`6kyu`

import java.math.BigInteger
import kotlin.math.pow

/**
Backwards Read Primes are primes that when read backwards in base 10 (from right to left) are a different prime.
(This rules out primes which are palindromes.)

Examples:
13 17 31 37 71 73 are Backwards Read Primes
13 is such because it's prime and read from right to left writes 31 which is prime too. Same for the others.

Task
Find all Backwards Read Primes between two positive given numbers (both inclusive),
the second one always being greater than or equal to the first one.
The resulting array or the resulting string will be ordered following the natural order of the prime numbers.

Example
backwardsPrime(2, 100) => [13, 17, 31, 37, 71, 73, 79, 97] backwardsPrime(9900, 10000) => [9923, 9931, 9941, 9967] backwardsPrime(501, 599) => []

Don't use Ruby Prime class, it's disabled.
backwardsPrime(2, 100) => [13, 17, 31, 37, 71, 73, 79, 97]
backwardsPrime(9900, 10000) => [9923, 9931, 9941, 9967]
 */

fun main() {

    print(backwardsPrime(7000, 7100))
}

fun backwardsPrime(start: Long, end: Long) = (start..end).toList().filter {
    it.isPrime_() &&
            it.toString().reversed().toLong() != it &&
            it.toString().reversed().toLong().isPrime_()
}.joinToString(" ")

private fun Long.isPrime_(): Boolean {
    val bigInt = BigInteger.valueOf(this)
    return bigInt.isProbablePrime(32)
}

/*********************** Best Practice *************************/

fun Long.isPrimee(): Boolean = this.rem(2) != 0L && (3..(this / 2) step 2).none { this.rem(it) == 0L }

fun Long.isPalindrome(): Boolean = this == this.toString().reversed().toLong()
fun Long.isReversePrime(): Boolean = this.toString().reversed().toLong().isPrime()

fun backwardsPrimee(start: Long, end: Long): String =
    (start..end)
        .filter { it.isPrimee() && !it.isPalindrome() && it.isReversePrime() }
        .joinToString(" ")


fun Long.isPrime__(): Boolean = this.rem(2) != 0L && (3..this.toDouble().pow(0.5).toInt()).none { this.rem(it) == 0L }
fun Long.reversed(): Long = this.toString().reversed().toLong()

fun backwardsPrimeee(start: Long, end: Long): String {
    return (start..end).filter { it.isPrime() && it != it.reversed() && it.reversed().isPrime() }
        .joinToString(separator = " ")
}