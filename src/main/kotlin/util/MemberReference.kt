package util

val isEmptyStringList: List<String>.() -> Boolean = List<String>::isEmpty

fun main() {
    var str = arrayListOf<String>("2","","aaa","","ddd")
    var str2 = arrayListOf<String>()

    println(str2.isEmptyStringList())
}