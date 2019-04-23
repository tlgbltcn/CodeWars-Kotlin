package util

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6)
    val stringList = mutableListOf("A,B,C,D,E")


    for (i in 'E'..'Z') {
        stringList addItem i.toString()
        list addItem i.toInt()
    }

    list.joinToString(",").forEach(::print)
    println()
    stringList.joinToString(",").forEach(::print)
    println()
    println(10 calculateArea 2)
}


infix fun Int.calculateArea(x: Int): Int {
    return this * x
}

infix fun <T> MutableCollection<T>.addItem(item: T) {
    this.add(item)
}

