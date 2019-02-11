package CodeWarsKata

/**
 * This kata is about multiplying a given number by eight if it is an even number and by nine otherwise.
 */

fun main(args: Array<String>) {

    print(simpleMultiplication(5))
    print(simpleMultiplication(4))
}

fun simpleMultiplication(n: Int): Int = if(n.rem(2)==0) n*8 else n*9