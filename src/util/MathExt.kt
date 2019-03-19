package util

import java.math.BigInteger
import java.util.stream.IntStream


fun Long.isPrime(): Boolean {
    return this > 2 && IntStream.rangeClosed(2, Math.sqrt(this.toDouble()).toInt())
        .noneMatch { n -> this.toInt() % n == 0 }
}


fun Long.isPrime_(): Boolean {
    var isNotPrime = false
    for (t in this / 2 downTo 2) {
        isNotPrime = this % t == 0.toLong()
        if (isNotPrime) break
    }
    return !isNotPrime
}


fun Long.isPrime__(): Boolean {
    val bigInt = BigInteger.valueOf(this)
    return bigInt.isProbablePrime(32)
}

val primes = sequenceOf(2L) + generateSequence(3L) { it + 2L }.filter(Long::isPrime)

fun Long.isPrime____(): Boolean = this > 1L && primes.takeWhile { it * it <= this }.all { this % it != 0L }

fun isPrime_____(x: Long) = (2L..Math.sqrt(x.toDouble()).toLong()).none { x % it == 0L }





