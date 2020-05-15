@file:Suppress("IMPLICIT_CAST_TO_ANY")

package katas.`5kyu`

/**
 * This is a series of Kotlin tricks.

This time! We're gonna do a code golf (it doesn't matter if you don't understand this phrase)!
Maybe you're fed up with those advanced language features in the recent Tricky Kotlin Katas,
so this time let's take a look into Kotlin's standard library.

I have a string with wrong directed paranthesis, I want to replace ( with ) and ) with ( and < with > and > with < and { with } and } with { at same time, you should do it with a single replace method.
For example I have this string : You }}need{{ >extra< time ) or money (
Which should be like this : You {{need}} <extra> time ( or money )

You shouldn't use split.

Since this is a code golf, you should write only one line of code, and less than 95 characters.
Empty lines are ignored so don't worry.

The final solution will fail if:

You used split (don't use this word in your comments)
You used more than 1 non-empty lines of code
You used more than 95 characters
I will not check for multiple use of replaces, but I recommend you to use only one.

My solution is of 90 characters. Have fun!
 *
 */

val string = "You }}need{{ >extra< time ) or money ("

fun main() {

    print(f(string))
}

fun f(s: String): String = s.map { c -> ("<>(){}" zip "><)(}{").toMap()[c] ?: c }.joinToString("")

fun f_(s: String) = s.fold("") { s1, s2 -> s1 + "{)<>(}$s2"[5 - "{)<>(}".indexOf(s2)] }

fun f__(s: String) = s.replace(Regex("[()><{}]")) { ")(<>}{"["()><{}".indexOf(it.value)] + "" }

fun f___(s: String) = s.map { "$it)(><}{"["()<>{}".indexOf(it) + 1] }.joinToString("")

fun f____(s: String) = s.replace(Regex("[(){}<>]")) { "${")(}{><"["(){}<>".indexOf(it.value[0])]}" }

fun f_____(s: String) = s.replace(Regex("[(){}<>]")) { "${")(}{><"["(){}<>".indexOf(it.value[0])]}" }

fun f______(s: String) = s.replace(Regex("[()<>{}]")) { "" + "()<>{}"[")(><}{".indexOf(it.value)] }

fun f_______(s: String) = s.replace(Regex("[()<>{}]")) { "" + "()<>{}"[")(><}{".indexOf(it.value)] }

fun f________(s: String) = s.map { "})>{(<$it"["{(<})>$it".indexOf(it)] }.joinToString("") { "" + it }

val r = "()({}{<><";
fun f_________(s: String) = Regex("[$r]").replace(s) { "" + r[r.indexOf(it.value) + 1] }

fun f__________(s: String) =
    s.fold("") { s, c -> "<([{}])>".let { it.indexOf(c).let { i -> s + if (i < 0) c else it[7 - i] } } }

fun f___________(s: String) = s.fold("") { a, c -> a + ("{}()<>".zip("}{)(><").toMap()[c] ?: c) }











