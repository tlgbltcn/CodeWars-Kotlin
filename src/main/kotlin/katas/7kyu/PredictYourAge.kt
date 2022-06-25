package katas.`7kyu`

import kotlin.math.sqrt

/**
 * My grandfather always predicted how old people would get, and right before he passed away he revealed his secret!

In honor of my grandfather's memory we will write a function using his formula!

Take a list of ages when each of your great-grandparent died.
Multiply each number by itself.
Add them all together.
Take the square root of the result.
Divide by two.
Example
predictAge(65, 60, 75, 55, 60, 63, 64, 45) === 86
Note: the result should be rounded down to the nearest integer.

Some random tests might fail due to a bug in the JavaScript implementation. Simply resubmit if that happens to you.
 */

fun main(args: Array<String>) {


    print(predictAge_(65, 60, 75, 55, 60, 63, 64, 45))
}

fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int {

    val arr = arrayOf(age1, age2, age3, age4, age5, age6, age7, age8)
    var total = 0
    arr.forEach {total += it * it }
    return (Math.sqrt(total.toDouble()) / 2).toInt()
}

/*********************** Alternatives *************************/


fun predictAge_ (vararg age : Int) : Int {
    return (sqrt(age.fold(0.0) { t, e -> t + e * e }) / 2).toInt()
}

fun predictAge(vararg age:Int) = (sqrt((age.map{it*it}.sum().toDouble()))/2).toInt()

fun predictAgee(vararg ages : Int): Int {
    return ages
            .map{ it * it }
            .sum()
            .let{ sqrt(it.toDouble()) }
            .let{ it / 2.0 }
            .let{ it.toInt() }
}