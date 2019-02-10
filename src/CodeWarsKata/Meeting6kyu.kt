package CodeWarsKata

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
