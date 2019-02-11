package CodeWarsKata

import java.lang.Math.ceil

/**
 * The accounts of the "Fat to Fit Club (FFC)" association are supervised by John as a volunteered accountant.
 * The association is funded through financial donations from generous benefactors. John has a list of the first n donations:
 * [14, 30, 5, 7, 9, 11, 15] He wants to know how much the next benefactor should give to the association so that the average of
 * the first n + 1 donations should reach an average of 30. After doing the math he found 149. He thinks that he made a mistake. Could you help him?

if dons = [14, 30, 5, 7, 9, 11, 15] then new_avg(dons, 30) --> 149

The function new_avg(arr, navg) should return the expected donation (rounded up to the next integer) that will permit to reach the average navg.

Should the last donation be a non positive number (<= 0) John wants us to throw an error

(return Nothing in Haskell, return None in F# and Ocaml, return -1 in C, Fortran, Nim, PowerShell, Go; echo ERRORin Shell)

so that he clearly sees that his expectations are not great enough.

Notes:

all donations and navg are numbers (integers or floats depending on the language), arr can be empty.
See examples below and "Test Samples" to see which error is to be thrown.

 */

fun main(args: Array<String>) {

    var arr = doubleArrayOf(14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0)
    print(newAvg(arr,90.0))
}

fun newAvg(a: DoubleArray, navg: Double): Long = if((((a.size +1)  * navg) - a.sum()).toLong() < 0) throw IllegalArgumentException()
else Math.ceil((((a.size +1)  * navg) - a.sum())).toLong()


/*********************** Best Practice *************************/

fun newAvg_(a: DoubleArray, navg: Double) = ceil(navg * (a.size + 1) - a.sum()).toLong().takeIf { it > 0 }
        ?: throw IllegalArgumentException()