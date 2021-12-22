package katas.`6kyu`

fun main() {

    val dummyBoolean = true
    unlesss(dummyBoolean) {
        printText()
    }
}

inline fun unlesss(predicate: Boolean, block: () -> Unit) = predicate.takeIf { !it }?.let {
    block()
}

inline fun untill(condition: () -> Boolean, block2: () -> Unit) {
    while (condition.invoke().not()) {
        block2()
    }
}


fun printText() = print("I am here.")

