package katas.`6kyu`

/**
Your task, is to create NxN multiplication table, of size provided in parameter.

for example, when given size is 3:

1 2 3
2 4 6
3 6 9
for given example, the return value should be: [[1,2,3],[2,4,6],[3,6,9]]
 */
fun main() {

    println(multiplicationTable(3))
}


fun multiplicationTable(size: Int): Array<IntArray> {
    val array = arrayListOf<IntArray>()
    val list = (1..size).toList()
    list.forEach { i ->
        val tempList = arrayListOf<Int>()
        list.forEach { t ->
            tempList.add(i * t)
        }
        array.add(tempList.toIntArray())
    }

    return array.toTypedArray()
}


/*********************** Best Practice *************************/


fun multiplicationTable_(size: Int) = Array(size) { x -> IntArray(size) { y -> (x + 1) * (y + 1) } }

fun multiplicationTable__(size: Int) = Array<IntArray>(size) {
        i -> (1..size).map { it * (i + 1) }.toIntArray()
}

