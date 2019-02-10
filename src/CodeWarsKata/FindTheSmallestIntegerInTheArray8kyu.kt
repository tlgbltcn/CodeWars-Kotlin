package CodeWarsKata

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


fun findSmallestInt_(nums: List<Int>): Int = nums.min()!!


fun findSmallestInt__(nums: List<Int>): Int {
    return nums.reduce { lowestNum, numToCompare -> if (lowestNum > numToCompare) numToCompare else lowestNum }
}


fun findSmallestInt____(nums: List<Int>) = nums.reduce { min, e -> if(e < min) e else min }






