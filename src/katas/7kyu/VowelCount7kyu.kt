package katas.`7kyu`

/**
 * Return the number (count) of vowels in the given string.

We will consider a, e, i, o, and u as vowels for this Kata.

The input string will only consist of lower case letters and/or spaces.
 */
fun main(args: Array<String>) {
    println(getCount(str = "abracadabra"))
    println(getCount_(str = "abracadabra"))
}

fun getCount(str : String) : Int{
    val character = "aeio"
    var count = 0

    str.forEach {
        var char = it
        character.forEach {
            if (char.toString().equals(it.toString())) count++
        }
    }
    return count
}


fun getCount_ (str: String) = str.count{it in "aeiou"}
