package CodeWarsKata

import java.lang.StringBuilder
import java.util.LinkedHashSet
import java.util.ArrayList


/**
 * There is a war and nobody knows - the alphabet war!
There are two groups of hostile letters.
The tension between left side letters and right side letters was too high and the war began.
The letters called airstrike to help them in war - dashes and dots are spreaded everywhere on the battlefield.

Task
Write a function that accepts fight string consists of only small letters and * which means a bomb drop place.
Return who wins the fight after bombs are exploded. When the left side wins return Left side wins!,
when the right side wins return Right side wins!, in other case return Let's fight again!.

The left side letters and their power:

w - 4
p - 3
b - 2
s - 1
The right side letters and their power:

m - 4
q - 3
d - 2
z - 1
The other letters don't have power and are only victims.
The * bombs kills the adjacent letters ( i.e. aa*aa => a___a, **aa** => ______ );


explodedList = ArrayList(LinkedHashSet<Int>(indexArray.sorted()))

 */

fun main() {
    print(alphabetWar("zd*www*b"))
}

fun alphabetWar(fight: String): String {

    val sb = StringBuilder()
    var listIndex = 0
    var explodedList = ArrayList(LinkedHashSet<Int>(fight.bombExploded()))

    if (explodedList.isEmpty()) return fight.win()

    for ((i, item) in fight.withIndex()) {
        if (explodedList[listIndex] != i) {
            sb.append(item.toString())
        } else if (listIndex < explodedList.size - 1) listIndex++
    }
    return sb.toString().win()
}

fun String.bombExploded(): List<Int> {
    val indexArray: ArrayList<Int> = arrayListOf()
    this.mapIndexed { index, c ->
        if (c.toString() == "*") {
            indexArray.add(index)
            if (index - 1 >= 0) indexArray.add(index - 1)
            if (index + 1 <= this.length - 1) indexArray.add(index + 1)
        }
    }
    return indexArray.sorted()
}

fun String.win(): String {
    var score = 0
    this.forEach {
        when(it.toString()) {
            "w" -> score -= 4
            "p" -> score -= 3
            "b" -> score -= 2
            "s" -> score -= 1
            "m" -> score += 4
            "q" -> score += 3
            "d" -> score += 2
            "z" -> score += 1
        }
    }

    return if (score > 0) "Right side wins!" else if (score < 0) "Left side wins!" else "Let's fight again!"
}

/*********************** Best Practice *************************/

fun alphabetWarr(fight: String): String {
    val _fight = fight.replace(Regex(""".?\*+.?"""), "")
    val map = mapOf(
        'w' to 4,
        'p' to 3,
        'b' to 2,
        's' to 1,
        'm' to -4,
        'q' to -3,
        'd' to -2,
        'z' to -1
    )
    val sum = _fight.map{map[it] ?: 0}.fold(0){a,q->a+q}
    return if (sum > 0) "Left side wins!" else if (sum < 0) "Right side wins!" else "Let's fight again!"
}


fun alphabetWarrr(fight: String): String {
    val forces = mapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1, 'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val killedByBomb = Regex("""(?<=\*)\w|\w(?=\*)""")
    val result = fight.replace(killedByBomb, "_").sumBy { forces.getOrDefault(it, 0) }
    return when {
        result > 0 -> "Left side wins!"
        result < 0 -> "Right side wins!"
        else -> "Let's fight again!"
    }
}

fun alphabetWarrrr(fight: String): String {
    val lettersPower = hashMapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1,
        'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val afterBombing = fight.replace(regex = Regex(".?\\*+.?"), replacement = "")
        .map { letter -> lettersPower.getOrDefault(letter, 0) }
        .sum()
    if (afterBombing > 0) {
        return "Left side wins!"
    }
    if (afterBombing == 0) {
        return "Let's fight again!"
    }
    return "Right side wins!"
}


fun alphabetWarrrrr(fight: String): String = fight.explode().judge()

fun String.explode() = this.mapIndexed { index: Int, c: Char ->
    if (this.getOrNull(index - 1) == '*' || this.getOrNull(index + 1) == '*') '_' else c
}.joinToString("")

fun String.judge() =
    this.map {
        when(it) {
            'w' -> 4
            'p' -> 3
            'b' -> 2
            's' -> 1
            'm' -> -4
            'q' -> -3
            'd' -> -2
            'z' -> -1
            else -> 0
        }
    }
        .sum()
        .let {
            when {
                it > 0 -> "Left side wins!"
                it < 0 -> "Right side wins!"
                else -> "Let's fight again!"
            }
        }


fun alphabetWarrrrrr(s: String) = s.bombsApplied().reducedToScore().decideWinner()

private fun String.bombsApplied() = replace(Regex("""\w?\*\w?"""), "")
private const val sides = "wpbs*zdqm"
private fun String.reducedToScore() = filter{ it in sides }.map{ sides.indexOf(it) - 4 }.sum()
private fun Int.decideWinner() = when {
    this < 0 -> "Left side wins!"
    this > 0 -> "Right side wins!"
    else -> "Let's fight again!"
}


fun alphabetWarrrrrrr(fight: String): String {
    val letters = mapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1, 'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    var res = fight.toList()
    while(res.contains('*')) {
        var bombIndex = res.indexOf('*')
        res = res.mapIndexed { index, elem -> if(index < bombIndex - 1 || index > bombIndex + 1 || ((index == bombIndex - 1 || index == bombIndex + 1 ) && elem == '*')) elem else '_' }
    }
    val sum = res.sumBy { elem -> letters[elem] ?: 0}
    when{
        sum > 0 -> return "Left side wins!"
        sum < 0 -> return "Right side wins!"
        else -> return "Let's fight again!"
    }
}


fun alphabetWarrrrrrrr(fight: String): String {
    val s = fight.replace(Regex("""\w?\*\w?"""), "")
        .sumBy {
            when (it) {
                in "sbpw" -> "sbpw".indexOf(it) + 1
                in "zdqm" -> -("zdqm".indexOf(it) + 1)
                else -> 0
            }
        }
    return when {
        s < 0 -> "Right side wins!"
        s > 0 -> "Left side wins!"
        else -> "Let's fight again!"
    }
}