package CodeWarsKata

fun main(args: Array<String>) {

    print(negativeNumber(-2))
}

fun negativeNumber (x : Int ) : Int = if(x<0) x else -(x)

