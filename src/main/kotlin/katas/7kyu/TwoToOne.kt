package katas.`7kyu`
import java.util.*

/**
 * Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible, containing distinct letters,

each taken only once - coming from s1 or s2. #Examples: ``` a = "xyaabbbccccdefww" b = "xxxxyyyyabklmopq" longest(a, b) -> "abcdefklmopqwxy"
a = "abcdefghijklmnopqrstuvwxyz" longest(a, a) -> "abcdefghijklmnopqrstuvwxyz" ```
 */

fun main(args: Array<String>) {

    print(longestA("aretheyhere", "yestheyarehere"))
}

fun longest(s1:String, s2:String):String {

    var string = s1+s2
    var builder = StringBuilder()
    var newString =""
    var stringList : ArrayList<String> = arrayListOf()

    string.forEach {

        if(!stringList.contains(it.toString())){
            stringList.add(it.toString())
            stringList.sort()
        }
    }

    stringList.forEach {
        builder.append(it)
    }

    newString = builder.toString()

    return newString
}

fun longestA(s1:String, s2:String) : String{
    return s1.split("").toSet().union(s2.split("")).toSortedSet().joinToString("")
}

/*********************** Best Practice *************************/

fun longest_(s1:String, s2:String):String {
    return (s1 + s2).toSortedSet().joinToString("")
}

fun longest__(s1:String, s2:String):String {
    return String((s1 + s2).toCharArray().distinct().sorted().toCharArray())
}

fun longest___(s1:String, s2:String):String {
    val cSet = TreeSet<Char>()
    s1.forEach { c -> cSet.add(c) }
    s2.forEach { c -> cSet.add(c) }
    return cSet.joinToString(separator = "")
}

fun longest____(s1:String, s2:String):String {
    return s1.split("").toSet().union(s2.split("").toSet()).sorted().joinToString("")
}