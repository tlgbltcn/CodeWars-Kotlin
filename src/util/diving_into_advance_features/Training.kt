package util.diving_into_advance_features

import java.util.function.BiPredicate

fun main() {

    val numberListOne = listOf(1, 2, 3, 4)
    val numberListTwo = listOf(5, 6, 7, 8)
    println(numberListOne combineWith numberListTwo)

    println(NumericHolder(1, 2).compareTo(NumericHolder(1, 1)))
    println(NumericHolder(1, 2).plus(NumericHolder(1, 1)))

    numberListOne.each(::print)
    println()

    numberListOne.doStuff(predicate = true, anotherPredicate = false) {
        println(size)
        println(first())
        println(last())
    }

    val x = conference("Google I/O", "Ankara") {

        this.addTalk(Talk("q1w", "dsd", 1L, TalkType.CONFERENCE))
    }
    x.talks.forEach(::print)
}


// infix
val cities = mapOf(
    "uk" to "london"
)

infix fun <T> List<T>.combineWith(list: List<T>): List<T> {
    val combinedList = mutableListOf<T>()
    combinedList.run {
        addAll(this)
        addAll(list)
    }
    return combinedList
}

infix fun <T> List<T>.advanceCombineWith(list: List<T>): List<T> = this.plus(list)


// wrap two Ints
data class NumericHolder(val a: Int, val b: Int) : Comparable<NumericHolder> {
    override fun compareTo(other: NumericHolder): Int {
        return (a + b).compareTo(other.a + other.b)
    }
}

operator fun NumericHolder.plus(other: NumericHolder): NumericHolder {
    return NumericHolder(a + other.a, b + other.b)
}

inline fun <T> Iterable<T>.each(action: (T) -> Unit) {
    for (element: T in this) action(element)
}

fun <T> List<T>.doStuff(predicate: Boolean, anotherPredicate: Boolean, other: List<T>.() -> Unit) {
    if (predicate) this.other() else this.reversed().other()
}


//dsl
class Conference(
    val name: String,
    val location: String
) {

    val schedule = mutableListOf<Talk>()

    val talks get() = schedule.toList()

    fun addTalk(talk: Talk) {
        schedule.add(talk)
    }

}

data class Talk(
    val topic: String? = null,
    val speaker: String? = null,
    val time: Long? = null,
    val type: TalkType? = TalkType.CONFERENCE

)

enum class TalkType {
    CONFERENCE, KEYNOTE
}


fun conference(name: String, location: String, block: Conference.() -> Unit): Conference {
    val conference = Conference(name, location).apply(block)
    return conference
}




