package katas.`7kyu`

/**
 * Cheesy Cheeseman just got a new monitor! He is happy with it, but he just discovered that his old desktop wallpaper no longer fits. He wants to find a new wallpaper, but does not know which size wallpaper he should be looking for, and alas, he just threw out the new monitor's box. Luckily he remembers the width and the aspect ratio of the monitor from when Bob Mortimer sold it to him. Can you help Cheesy out?

The Challenge
Given an integer width and a string ratio written as WIDTH:HEIGHT, output the screen dimensions as a string written as WIDTHxHEIGHT.
 */
fun main() {
    println(findScreenHeight(1024, "4:3"))
}

fun findScreenHeight(width: Int, ratio: String): String {
    val (x, y) = ratio.split(":").map { it.toInt() }
    return "${width}x${((width * y) / x)}"
}