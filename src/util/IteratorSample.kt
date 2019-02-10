package util

class IteratorSample<T>(var list : MutableList<T>)  : Iterator<T>{

    private var index = 0

    override fun hasNext(): Boolean {

        return index < list.size
    }

    override fun next(): T{

        return try {
            list[index++]
        } catch (e : ArrayIndexOutOfBoundsException){
            index -= 1
            throw  NoSuchElementException(e.message)
        }
    }
}