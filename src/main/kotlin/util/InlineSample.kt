package util

import kotlin.random.Random
import kotlin.system.measureNanoTime

var list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
var numbers = "1234567"
val random = Random(100)

fun main() {
    println("time millis " + measureNanoTime {
        list.myEach { println(random.nextInt(0, 10) * it) }
    })

    println(stringBuilder())
    println()
    multiplyByTwo(5) { println("Result is: $it") }
}

inline fun <T> Collection<T>.myEach(block: (T) -> Unit) {
    for (e in this) block(e)
}

inline fun <T> Iterable<T>.sumBy(block: (T) -> Int): Int {
    var sum = 0
    for (item in this) {
        sum += block(item)
    }
    return sum
}

fun stringBuilder(): String {
    val x = stringWithFixedParameters { name: String, age: Int ->
        return "Name is : $name Age is $age"
    }

    return x
}

inline fun stringWithFixedParameters(block: (String, Int) -> String): String {
    return block("Tolga", 29)
}


inline fun multiplyByTwo(num: Int, crossinline lambda: (result: Int) -> Unit): Int {
    val result = num * 2
    lambda.invoke(result)
    return result
}












