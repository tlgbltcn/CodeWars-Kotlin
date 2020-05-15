package katas.`6kyu`

import java.lang.Math.pow
import kotlin.math.pow

/**
 * Some numbers have funny properties. For example:

89 --> 8¹ + 9² = 89 * 1

695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2

46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51

Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p

we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n.
In other words:

Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k

If it is the case we will return k, if not return -1.

Note: n and p will always be given as strictly positive integers.

digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1
digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k
digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 */

fun main() {
    digPow(89, 1)
}

fun digPow(n: Int, p: Int): Long {

    val values = n.toString()
    var sum = 0.0
    (0 until values.length).forEach { i ->
        val value = Integer.parseInt(values[i].toString())
        sum += Math.pow(value.toDouble(), (p + i).toDouble())
    }

    return if ((sum / n) % 1 <= 0.0) (sum / n).toLong() else -1

}

/*********************** Best Practice *************************/


fun digPoww(n: Int, p: Int) = n.toString().mapIndexed { i, c ->
    c.toString().toDouble().pow(p + i).toInt()
}.sum().let { if (it % n == 0) it / n else -1 }


fun digPowww(n: Int, p: Int) = n.toString().chunked(1).mapIndexed { index, digit ->
    pow(digit.toDouble(), (p + index).toDouble())
}.sum().toInt().let { if (it % n == 0) it / n else -1 }
