package katas.`8kyu`


/**
 * Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
 */


fun main(args: Array<String>) {

    print(replace("tolga"))
    print(replace("halenurcaliskan"))
    print(replace("aaahmet"))
    print(replace("merrryeeeem"))
    print(replace("dilekee"))


    println(replace__("tolga"))
    println(replace__("halenurcaliskan"))
    println(replace__("aaahmet"))
    println(replace__("merrryeeeem"))
    println(replace__("dilekee"))
}


fun replace(s: String): String = s.replace("[aeiouAEIOU]".toRegex(),"!")

fun replace__(s: String) : String = s.replace(Regex("[aeiou]", RegexOption.IGNORE_CASE),"!")

/*********************** Alternatives *************************/

fun replace_(s: String) = s.map { when (it) {
    'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> '!'
    else -> it
}
}.joinToString("")