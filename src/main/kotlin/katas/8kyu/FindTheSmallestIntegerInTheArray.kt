package katas.`8kyu`

/**
 * Given an array of integers your solution should find the smallest integer.

For example:

Given [34, 15, 88, 2] your solution will return 2
Given [34, -345, -1, 100] your solution will return -345
You can assume, for the purpose of this kata, that the supplied array will not be empty.
 */

fun main(args: Array<String>) {

    val a = listOf(1,45,-32,68, -23,-35)
    println(findSmallestInt(a))
    print(findSmallestInt__(a))
}


fun findSmallestInt(nums: List<Int>): Int {

    var min = java.lang.Float.MAX_VALUE
    var index = -1
    for (i in 0 until nums.size) {
        val f = nums[i]
        if (java.lang.Float.compare(f.toFloat(), min) < 0) {
            min = f.toFloat()
            index = i
        }
    }
    return nums[index]
}

/*********************** Best Practice *************************/


fun findSmallestInt_(nums: List<Int>): Int = nums.minOrNull()!!


fun findSmallestInt__(nums: List<Int>): Int {
    return nums.reduce { lowestNum, numToCompare -> if (lowestNum > numToCompare) numToCompare else lowestNum }
}


fun findSmallestInt____(nums: List<Int>) = nums.reduce { min, e -> if(e < min) e else min }






