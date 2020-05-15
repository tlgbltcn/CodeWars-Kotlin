package katas.`8kyu`

/**
 *Very simple, given a number, find its opposite.

Examples:

1: -1
14: -14
-34: 34
But can you do it in 1 line of code and without any conditionals?
 */


fun main(args : Array<String>){
    println(opposite(5))

}

fun opposite(number : Int) : Int{
    return -number
    //return (number - (2*number))
}

