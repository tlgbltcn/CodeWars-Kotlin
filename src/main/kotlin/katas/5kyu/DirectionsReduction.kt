package katas.`5kyu`

import java.util.Stack

/**
 * Once upon a time, on a way through the old wild mountainous west,…
… a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.

Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!

How I crossed a mountainous desert the smart way.
The directions given to the man are, for example, the following (depending on the language):

["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
or
{ "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
or
[North, South, South, East, West, North, West]
You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
["WEST"]

Other examples:
In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.

The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).

In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].

Task
Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South.
The Clojure version returns nil when the path is reduced to nothing.
The Rust version takes a slice of enum Direction {North, East, West, South}.
See more examples in "Sample Tests:"
Notes
Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].

 */

fun main() {
    println(
        DirReductionList.dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")).joinToString(" ")
    )
    println(
        DirReductionList.dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH"))
            .joinToString(" ")
    )
    println(
        DirReductionStack.dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH"))
            .joinToString(" ")
    )
    println(
        DirReduction.dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")).joinToString(" ")
    )

    println(
        DirReduction_.dirReduc(arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")).joinToString(" ")
    )
}

val map = mapOf("NORTH" to "SOUTH", "SOUTH" to "NORTH", "EAST" to "WEST", "WEST" to "EAST")

object DirReductionList {
    fun dirReduc(arr: Array<String>): Array<String> {
        return DirectionsList().also { it.addAll(arr) }()
    }
}

class DirectionsList(
    private val directions: MutableList<String> = mutableListOf()
) : MutableList<String> by directions {

    override fun addAll(elements: Collection<String>): Boolean {
        if (elements.isEmpty()) return false
        elements.forEach { direction ->
            directions.lastOrNull()?.let { last ->
                if (last == (map[direction])) directions.removeLast()
                else directions.add(direction)
            } ?: directions.add(direction)
        }
        return true
    }

    operator fun invoke(): Array<String> = directions.toTypedArray()
}

/*********************** Alternatives *************************/

object DirReductionStack {
    fun dirReduc(arr: Array<String>): Array<String> {
        return DirectionsStack().also { it.addAll(arr) }()
    }
}

class DirectionsStack(
    private val stack: Stack<String> = Stack()
) : MutableList<String> by stack {

    override fun addAll(elements: Collection<String>): Boolean {
        if (elements.isEmpty()) return false
        elements.forEach { direction ->
            when {
                stack.empty() -> stack.push(direction)
                stack.peek() == map[direction] -> stack.pop()
                else -> stack.push(direction)
            }
        }
        return true
    }

    operator fun invoke(): Array<String> = stack.toTypedArray()
}

/*********************** Alternatives *************************/

object DirReduction {
    fun dirReduc(arr: Array<String>): Array<String> {
        if (arr.size <= 1) return arr

        val stack = Stack<String>()
        val oppositeOf = mapOf(
            "WEST" to "EAST", "EAST" to "WEST",
            "SOUTH" to "NORTH", "NORTH" to "SOUTH"
        )

        arr.forEach { direction ->
            when {
                stack.empty() -> stack.push(direction)
                stack.peek() == oppositeOf[direction] -> stack.pop()
                else -> stack.push(direction)
            }
        }

        return stack.toTypedArray()
    }
}

/*********************** Alternatives *************************/


object DirReduction_ {
    fun oppositeTo(direction: String): String = when (direction) {
        "NORTH" -> "SOUTH"
        "SOUTH" -> "NORTH"
        "EAST" -> "WEST"
        "WEST" -> "EAST"
        else -> ""
    }

    fun dirReduc(arr: Array<String>): Array<String> = arr.fold(listOf<String>()) { acc, dir ->
        if (acc.lastOrNull() == oppositeTo(dir)) acc.take(acc.size - 1)
        else acc.plus(dir)
    }.toTypedArray()
}