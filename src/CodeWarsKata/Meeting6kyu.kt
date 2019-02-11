package CodeWarsKata

/**
 * John has invited some friends. His list is:

s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
Could you make a program that

makes this string uppercase
gives it sorted in alphabetical order by last name.
When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.

So the result of function meeting(s) will be:

"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
It can happen that in two distinct families with the same family name two people have the same first name too.

Notes
You can see another examples in the "Sample tests".
 */

fun main(args: Array<String>) {
    val s = "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"
    println(meeting(s))
}

fun meeting(s: String): String {

    var list = s.split(Regex(";")).map { "${it.split(Regex(":")).last()}, ${it.split(Regex(":")).first()}"}
    return list.map { it.myRotate() }.sortedBy { it.toUpperCase() }.joinToString("").toUpperCase()
}

fun String.myRotate(): String = this.map { it }.joinToString(prefix = "(", postfix = ")", separator = "")


/*********************** Best Practice *************************/


fun meeting_(s: String) = "(" + s.toUpperCase().split(";")
        .map{x -> x.split(":").reversed().joinToString(", ")}
        .sorted()
        .joinToString(")(") + ")"
