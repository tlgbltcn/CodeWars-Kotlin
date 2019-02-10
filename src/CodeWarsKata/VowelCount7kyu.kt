package CodeWarsKata

fun main(args: Array<String>) {
    println(getCount(str = "abracadabra"))
    println(getCount_(str = "abracadabra"))
}


fun getCount(str : String) : Int{
    val character = "aeio"
    var count = 0

    str.forEach {
        var char = it
        character.forEach {
            if (char.toString().equals(it.toString())) count++
        }
    }

    return count
}


fun getCount_ (str: String) = str.count{it in "aeiou"}
