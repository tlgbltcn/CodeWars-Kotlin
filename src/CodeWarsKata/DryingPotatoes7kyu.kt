package CodeWarsKata

fun main(args: Array<String>) {

    print(potatoes(82, 127, 80))
}

fun potatoes(p0:Int, w0:Int, p1:Int):Int = w0 * (100 - p0) / (100 - p1)
