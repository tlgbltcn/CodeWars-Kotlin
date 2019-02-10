package CodeWarsKata

fun main(args: Array<String>) {
    print(century(1901))
}

fun century(number: Int): Int {

    return if (number.rem(100 )==0) number / 100
    else (number / 100) + 1
}