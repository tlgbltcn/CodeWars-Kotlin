package util

val mainList = mutableListOf(
    Foo(0, "0"),
    Foo(1, "1"),
    Foo(2, "2"),
    Foo(3, "3"),
    Foo(4, "4"),
    Foo(5, "5"),
    Foo(6, "6"),
    Foo(7, "7"),
    Foo(8, "8"),
    Foo(9, "9")
)

val boundedList = arrayListOf<Foo>()

data class Foo(
    val key: Int?,
    val value: String?
)

fun getRandomFooFromList() = mainList.random()

fun main() {

    boundedList.add(getRandomFooFromList())
    repeat(30) {
        val randomItem = getRandomFooFromList()
        if (boundedList.contains(randomItem)) {
            boundedList.remove(randomItem)
        } else {
            boundedList.add(randomItem)
        }
    }

    println(boundedList.map { it.key }.joinToString(" "))
}