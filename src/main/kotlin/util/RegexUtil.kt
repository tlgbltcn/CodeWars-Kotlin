package util

val regex = """\W+""".toRegex()
val beautiful = "Roses are red, Violets are blue"

fun maxRepeating(str: String): Char {
    val n = str.length
    var count = 0
    var res = str[0]
    var cur_count = 1

    // Traverse string except last character
    for (i in 0 until n) {
        // If current character matches with next
        if (i < n - 1 && str[i] == str[i + 1])
            cur_count++
        else {
            if (cur_count > count) {
                count = cur_count
                res = str[i]
            }
            cur_count = 1
        }// If doesn't match, update result
        // (if required) and reset count
    }
    return res
}



