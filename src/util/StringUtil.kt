package util


fun String.replace(vararg pairs: Pair<String, String>): String =
    pairs.fold(this) { acc, (old, new) -> acc.replace(old, new, ignoreCase = true) }