package katas.`8kyu`

/**
 * Introduction
The first century spans from the year 1 up to and including the year 100, The second - from the year 101 up to and including the year 200, etc.

Task :
Given a year, return the century it is in.
 */
fun main(args: Array<String>) {
    print(century(1901))
}

fun century(number: Int): Int {

    return if (number.rem(100 )==0) number / 100
    else (number / 100) + 1
}