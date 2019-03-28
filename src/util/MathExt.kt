@file:Suppress("NON_TAIL_RECURSIVE_CALL")

package util

import java.math.BigInteger
import java.util.stream.IntStream

object MathExt {
    val square: (Int) -> Int = { x -> x * x }

}

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

fun Long.isPrime______(): Boolean = this.rem(2) != 0L && (3..(this / 2) step 2).none { this.rem(it) == 0L }

tailrec fun Long.factorial(): Long {

    return if (this == 1.toLong()) this
    else {
        this
        this * (this - 1).factorial()
    }
}

tailrec fun Long.defactoriel(): Long {
    var n = 2
    var count = 0
    var pairList = arrayListOf<Pair<Int, Int>>()

    while (this % primeFactory(n) != 0.toLong()) {
        count++

    }
    return 1.toLong()
}

tailrec fun Int.factorial(): Int {

    return if (this == 1) this
    else this * (this - 1).factorial()
}

tailrec fun Int.deComposition(): List<Int> {
    val list = arrayListOf<Int>()
    return if (this == 1) return list
    else arrayListOf()
}

tailrec fun primeFactory(n: Int): Int {
    return if ((n + 1).toLong().isPrime__()) n + 1 else primeFactory(n + 1)
}





