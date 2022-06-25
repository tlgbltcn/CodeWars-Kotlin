package katas.`6kyu`


/**
 * You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of the integers to the left of N is equal to the sum of the integers to the right of N. If there is no index that would make this happen, return -1.

For example:

Let's say you are given the array {1,2,3,4,3,2,1}:
Your function will return the index 3, because at the 3rd position of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.

Let's look at another one.
You are given the array {1,100,50,-51,1,1}:
Your function will return the index 1, because at the 1st position of the array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.

Last one:
You are given the array {20,10,-80,10,10,15,35}
At index 0 the left side is {}
The right side is {10,-80,10,10,15,35}
They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
Index 0 is the place where the left side and right side are equal.

Note: Please remember that in most programming/scripting languages the index of an array starts at 0.

Input:
An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.

Output:
The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index that fits these rules, then you will return -1.

Note:
If you are given an array with multiple answers, return the lowest correct index
 */

fun main() {

    val arr1 = intArrayOf(1, 2, 3, 4, 1, 2, 3)
    val arr2 = intArrayOf(1, 100, 50, -51, 1, 1)
    val arr3 = intArrayOf(1, 2, 3, 4, 5, 6)
    val arr4 = intArrayOf(20, 10, 30, 10, 10, 15, 35)
    val arr5 = intArrayOf(-8505, -5130, 1926, -9026)
    val arr6 = intArrayOf(2824, 1774, -1490, -9084, -9696, 23094)
    val arr7 = intArrayOf(4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4)
    val arr8 = intArrayOf(10, -80, 10, 10, 15, 35)
    val arr9 = intArrayOf(0, 0, 0, 0, 0, 0)
    val arr10 = intArrayOf(10, 20, 30, 30, 20, 10)
    val arr11 = intArrayOf(10, 10, 10, 10, 10, 10)
    val arr12 = intArrayOf(1, 1, 1, 1, 2, 1)

    println(findEvenIndex__(arr10))

}

fun findEvenIndex(arr: IntArray): Int {
    var left = 0
    var total = arr.sum()
    for (i in arr.indices) {
        total -= arr[i]
        if (left == total) return i
        left += arr[i]
    }
    return -1
}

fun findEvenIndex_(arr:IntArray):Int {
    for (i in arr.indices) {
        if (arr.sliceArray(0..i).sum() == arr.sliceArray(i until arr.size).sum()) {
            return i
        }
    }
    return -1
}

fun findEvenIndex__(arr: IntArray) = arr.indices.indexOfFirst { arr.take(it).sum() == arr.drop(it + 1).sum() }