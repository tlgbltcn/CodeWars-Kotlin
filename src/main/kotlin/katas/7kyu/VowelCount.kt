package katas.`7kyu`

import util.maxRepeatingForNumbers

/**
 * Return the number (count) of vowels in the given string.

We will consider a, e, i, o, and u as vowels for this Kata.

The input string will only consist of lower case letters and/or spaces.
 */
fun main(args: Array<String>) {
    println(getCount(str = "abracadabra"))
    println(getCount_(str = "abracadabra"))

    println("12".maxRepeatingForNumbers())          //true
    println("13".maxRepeatingForNumbers())          //true
    println("123".maxRepeatingForNumbers())         //false
    println("1234".maxRepeatingForNumbers())        //false
    println("1324".maxRepeatingForNumbers())        //true
    println("4321".maxRepeatingForNumbers())        //false
    println("432".maxRepeatingForNumbers())         //false
    println("98765432".maxRepeatingForNumbers())    //false
    println("32".maxRepeatingForNumbers())          //true
}


fun getCount(str : String) : Int{
    val character = "aeio"
    var count = 0

    str.forEach {
        val char = it
        character.forEach {
            if (char.toString().equals(it.toString())) count++
        }
    }
    return count
}

fun getCount_ (str: String) = str.count{it in "aeiou"}
