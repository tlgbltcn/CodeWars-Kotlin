package CodeWarsKata

import java.lang.Math.ceil

fun main(args: Array<String>) {

    var arr = doubleArrayOf(14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0)
    print(newAvg(arr,90.0))
}

fun newAvg(a: DoubleArray, navg: Double): Long = if((((a.size +1)  * navg) - a.sum()).toLong() < 0) throw IllegalArgumentException()
else Math.ceil((((a.size +1)  * navg) - a.sum())).toLong()


/*********************** Best Practice *************************/


fun newAvg_(a: DoubleArray, navg: Double) = ceil(navg * (a.size + 1) - a.sum()).toLong().takeIf { it > 0 }
        ?: throw IllegalArgumentException()