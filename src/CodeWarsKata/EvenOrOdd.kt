package CodeWarsKata

fun main(args: Array<String>) {

    print(evenOrOdd(3))
    print(evenOrOdd(5))
    print(evenOrOdd(7))
    print(evenOrOdd(10))
}

fun evenOrOdd(number: Int) : String = if(number%2 ==0) "Even" else "Odd"