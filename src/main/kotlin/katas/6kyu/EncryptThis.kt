package katas.`6kyu`

import java.util.regex.Pattern
import java.util.stream.Collectors

/**
 * Acknowledgments:
I thank yvonne-liu for the idea and for the example tests :)

Description:
Encrypt this!

You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:

Your message is a string containing space separated words.
You need to encrypt each word in the message using the following rules:
The first letter needs to be converted to its ASCII code.
The second letter needs to be switched with the last letter
Keepin' it simple: There are no special characters in input.
Examples:
encryptThis "Hello" == "72olle"
encryptThis "good" == "103doo"
encryptThis "hello world" == "104olle 119drlo"
 */

fun main() {

    print(encryptThis("A wise old owl lived in an oak"))
}

fun encryptThis(text: String) = text.split(" ").joinToString { it.encrypt() }.replace(",", "")

fun String.encrypt(): String = when {
    this.length > 2 -> "${this.first().ascii()}${this.substring(1).last()}" +
            this.substring(2, this.lastIndex) +
            this.substring(1).first()
    this.length > 1 -> "${this.first().ascii()}${this[1]}"
    else -> this.first().ascii()
}

fun Char.ascii(): String = this.toByte().toInt().toString()


/*********************** Alternatives *************************/


fun encryptThiss(text: String): String {
    return text.split(" ")
        .map { it.first().toInt().toString() + it.drop(2).takeLast(1) + it.drop(2).dropLast(1) + it.drop(1).take(1) }
        .joinToString(" ")
}

val re = Regex("^(.)(.)(.*)(.)$")

fun encryptThisss(text: String) = text
    .trim()
    .split(" ")
    .map { if (it.length > 2) re.replace(it, "$1$4$3$2") else it }
    .joinToString(" ") { it[0].toByte().toString() + it.substring(1) }


fun encryptThissss(text: String): String =
    Pattern.compile(" +").splitAsStream(text).map(mapper).collect(Collectors.joining(" "))

private val mapper = { word: String ->
    val builder = StringBuilder().append(word[0].toInt())
    when (word.length) {
        1 -> {
        }
        2 -> builder.append(word[1])
        else -> builder.append(word[word.length - 1]).append(word.subSequence(2, word.length - 1)).append(word[1])
    }
    builder.toString()
}
