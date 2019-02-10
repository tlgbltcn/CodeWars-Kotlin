package CodeWarsKata

class CircularList<T>(vararg val elements: T) {

    init {
        if (elements.isEmpty()){
            throw Exception()
        }
    }

    var size = elements.size
    var step = -1

    fun next(): T {
        step++

        if (size == step) {
            step = 0
        }

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


