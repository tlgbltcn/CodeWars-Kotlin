package katas.`6kyu`

/**
 * The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of
 * size sz (ignore the last chunk if its size is less than sz).

If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk;
otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.

If

sz is <= 0 or if str is empty return ""
sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
 */
fun main(args: Array<String>) {
    // 123456779  8 -> 1856
    // 66443875  4 -> 1567
    // 66443875  8 -> 1567
    println(revRot("233534525436534", 4))

}

fun revRot(nums : String , sz : Int) : String {
    if (nums.isEmpty() || sz <= 0 || sz > nums.length) {
        return ""
    }

    var limit = (nums.length / sz) -1
    var result : String = ""
    for ((count, i) in (0..nums.length step sz).withIndex()){
        var process = nums.substring(i,i+sz)
        result = "$result${revOrRot(checkCubicDivideTwo(process), process)}"
        if (count == limit) break
    }

    return result
}


fun checkCubicDivideTwo(str : String) : Boolean{
    var total =      str.asSequence().map {
        it.toInt() * it.toInt()* it.toInt()
    }.sum()

    return total%2 == 0
}

fun revOrRot(isDivideTwo : Boolean, partOfStr : String) : String{
    return if (isDivideTwo){
        partOfStr.reversed()
    } else {
        "${partOfStr.subSequence(1 until partOfStr.length)}${partOfStr[0]}"
    }
}

/*********************** Best Practice *************************/


fun revRot_(nums:String, sz:Int)
        = nums
        .chunkedDroppingRemainder(sz)
        .map{
            when {
                it.sumOfCubesOfDigits divisibleBy 2 -> it.reversed()
                else -> it rotateLeftBy 1
            }
        }.joinToString("")

private fun String.chunkedDroppingRemainder(n: Int) = (0 until (length/n)).map{ substring(it*n, it*n+n) }
private val String.sumOfCubesOfDigits get() = map{ it - '0' }.map{ it * it }.sum()
private infix fun Int.divisibleBy(n: Int) = (this % n) == 0
private infix fun String.rotateLeftBy(n: Int) = substring(n) + substring(0, n)

/*********************** Best Practice *************************/

fun revRot__(nums: String, sz: Int): String =
        if (sz <= 0) ""
        else nums.chunked(sz).filter { it.length == sz }.map {
            if (it.sumBy { it - '0' } % 2 == 0) it.reversed() else it.drop(1) + it.first()
        }.joinToString("")


/*********************** Best Practice *************************/

fun revRot___(nums:String, sz:Int): String {
    return nums.chunked(sz).map { r(it, sz) }.joinToString("")
}

fun r(s: String, sz: Int): String {
    return when {
        s.length < sz -> ""
        s.sumBy { it - '0' } % 2 == 0 -> s.reversed()
        else -> s.drop(1) + s.take(1)
    }
}

/*********************** Best Practice *************************/


fun revRot____(nums:String, sz:Int): String {
    if (sz <= 0 || nums.isEmpty() || sz > nums.length) {
        return ""
    }

    return nums.chunkedSequence(sz)
            .filter { it.length == sz }
            .map { chunk ->
                if (shouldReverse(chunk)) {
                    chunk.reversed()
                } else {
                    chunk.rotateLeft()
                }
            }
            .joinToString(separator = "")
}

private fun shouldReverse(chunk: String): Boolean {
    val sumOfCubes = chunk.asSequence()
            .map { it.toString().toInt() }
            .map { it * it }
            .sum()
    return sumOfCubes % 2 == 0
}

fun String.rotateLeft() = this.drop(1) + this.first()