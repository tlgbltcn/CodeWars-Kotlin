package katas.`7kyu`

/**
 * You are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd,
 * return the middle character. If the word's length is even, return the middle 2 characters.

#Examples:

Kata.getMiddle("test") should return "es"

Kata.getMiddle("testing") should return "t"

Kata.getMiddle("middle") should return "dd"

Kata.getMiddle("A") should return "A"
#Input

A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases due to an error in the test cases).
You do not need to test for this. This is only here to tell you that you do not need to worry about your solution timing out.

#Output

The middle character(s) of the word represented as a string.
 */

fun main(args: Array<String>) {

    print(Kata("middle"))
}

fun Kata(word : String) : String = if(word.length.rem(2)==0)
    word.slice((word.length/2)-1..(word.length/2))
    else word.slice(word.length/2..(word.length/2))

/*********************** Alternatives *************************/


fun getMiddle(word : String) : String {
    val worldLength = (word.length - 1) / 2
    return word.drop(worldLength).dropLast(worldLength)
}