package CodeWarsKata

fun main(args: Array<String>) {

    print(Kata("middle"))
}

fun Kata(word : String) : String = if(word.length.rem(2)==0)
    word.slice((word.length/2)-1..(word.length/2))
    else word.slice(word.length/2..(word.length/2))

/*********************** Best Practice *************************/


fun getMiddle(word : String) : String {
    val worldLength = (word.length - 1) / 2
    return word.drop(worldLength).dropLast(worldLength)
}