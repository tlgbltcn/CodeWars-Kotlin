package CodeWarsKata

/**
 *
 *The two oldest ages function/method needs to be completed. It should take an array of numbers as its argument and return the two highest numbers within the array. The returned value should be an array in the format [second oldest age, oldest age].

The order of the numbers passed in could be any order. The array will always include at least 2 items.

For example:

twoOldestAges(listOf(1, 5, 87, 45, 8, 8)) // should return listOf(45, 87)
 */

fun main(args: Array<String>) {
    val arr = listOf(1,87,5, 45, 8, 8)
    print(twoOldestAges(arr))
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    val newList = ages.sortedDescending()

    return listOf(newList[0],newList[1])
}

/*********************** Best Practice *************************/

fun twoOldestAges_(ages: List<Int>) = ages.sorted().takeLast(2)

fun twoOldestAges__(ages: List<Int>): List<Int> { return ages.sorted().takeLast(2) }

fun twoOldestAges___(ages: List<Int>): List<Int> {
    val sorted = ages.sorted()
    return if (sorted.size >= 2) sorted.subList(sorted.size - 2, sorted.size) else sorted
}

fun twoOldestAges_____(ages: List<Int>): List<Int> {
    return ages.sortedWith(compareBy { it }).subList(ages.size - 2, ages.size)
}

fun twoOldestAges______(r: List<Int>) = r.sortedBy{v -> -v}.subList(0,2).reversed()
