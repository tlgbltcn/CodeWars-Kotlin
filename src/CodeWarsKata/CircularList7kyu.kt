package CodeWarsKata

/**
 * Create a Circular List

A circular list is of finite size, but can infititely be asked for its previous and next elements.
This is because it acts like it is joined at the ends and loops around.

For example, imagine a CircularList of [1, 2, 3, 4]. Five invocations of next() in a row should return 1, 2, 3, 4 and then
1 again. At this point, five invocations of prev() in a row should return 4, 3, 2, 1 and then 4 again.

Your CircularList is created by passing a vargargs parameter in, e.g. new CircularList(1, 2, 3).
Your list constructor/init code should throw an Exception if nothing is passed in.
 */

class CircularList<T>(vararg val elements: T) {

    init {
        if (elements.isEmpty()) throw Exception()
    }

    var size = elements.size
    var step = -1

    fun next(): T {
        step++

        if (size != step) return elements[step]
        step = 0
        return elements[step]
    }

    fun prev(): T {
        step--
        if (step <= -1) step = size -1
        return elements[step]
    }

}

fun main(args: Array<String>) {

    val circularList = CircularList("one", "two", "three")

    print(circularList.next())
    print(circularList.next())
    print(circularList.next())
    print(circularList.next())
    print(circularList.prev())
    print(circularList.prev())
    print(circularList.prev())
    print(circularList.prev())
}


