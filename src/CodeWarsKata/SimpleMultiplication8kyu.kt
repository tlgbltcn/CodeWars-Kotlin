package CodeWarsKata

fun main(args: Array<String>) {

    print(simpleMultiplication(5))
    print(simpleMultiplication(4))
}


fun simpleMultiplication(n: Int): Int = if(n.rem(2)==0) n*8 else n*9