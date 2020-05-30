package katas.`5kyu`

/**
 * Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
Examples:

foo -> foo1

foobar23 -> foobar24

foo0042 -> foo0043

foo9 -> foo10

foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.
 */

fun main() {

    println(incrementString(""))
    println(incrementString("1"))
    println(incrementString("009"))
    println(incrementString("foo"))
    println(incrementString("foo000"))
    println(incrementString("foo999"))
    println(incrementString("foo00999"))
    println(incrementString("foo"))
    println(incrementString("foobar001"))
    println(incrementString("foobar1"))
}


fun incrementString(str: String): String = str.partition { !it.isDigit() }.run {
    val num = (if (second.isEmpty()) 0 else second.toInt()).plus(1)
    return first + if (num.toString().length >= second.length) num.toString()
    else {
        var string = num.toString()
        do {
            string = "0".plus(string)
        } while (string.length < second.length); string
    }
}

fun _incrementString(str: String): String {
    val i = str.takeLastWhile { it.isDigit() }
    return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
}

fun __incrementString(str: String): String {
    return str.replace(Regex("([0-8]?)(9*)$")) { m ->
        val (d, ds) = m.destructured
        "${if (d.isEmpty()) 1 else d.toInt() + 1}${ds.replace('9', '0')}"
    }
}