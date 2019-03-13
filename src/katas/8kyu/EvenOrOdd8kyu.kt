package katas.`8kyu`

/**
 * Create a function (or write a script in Shell) that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
 */
fun main(args: Array<String>) {

    print(evenOrOdd(3))
    print(evenOrOdd(5))
    print(evenOrOdd(7))
    print(evenOrOdd(10))
}

fun evenOrOdd(number: Int) : String = if(number%2 ==0) "Even" else "Odd"