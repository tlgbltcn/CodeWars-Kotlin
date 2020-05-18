package util

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

data class StringContainer(val values: List<String>)

var data =
    "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9" +
            "\n" +
            "London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9" +
            "\n" +
            "Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7" +
            "\n" +
            "NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2" +
            "\n" +
            "Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5" +
            "\n" +
            "Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2" +
            "\n" +
            "Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4" +
            "\n" +
            "Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4" +
            "\n" +
            "Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7" +
            "\n" +
            "Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7"

val elements = listOf("A", "B", "C", "D", "E", "F", "G", "H")

data class Shape(
    val id: Long,
    val name: String,
    val type: ShapeEnum
)

enum class ShapeEnum {
    CIRCLE,
    SQUARE,
    TRIANGLE
}

val shapeList = mutableListOf<Shape>(
    Shape(id = 0, name = "circle0", type = ShapeEnum.CIRCLE),
    Shape(id = 1, name = "square0", type = ShapeEnum.SQUARE),
    Shape(id = 2, name = "triangle0", type = ShapeEnum.TRIANGLE),
    Shape(id = 3, name = "square1", type = ShapeEnum.SQUARE),
    Shape(id = 4, name = "circle1", type = ShapeEnum.CIRCLE),
    Shape(id = 5, name = "square2", type = ShapeEnum.SQUARE),
    Shape(id = 6, name = "triangle1", type = ShapeEnum.TRIANGLE)
)

data class Name(
    val firstName: String,
    val lastName: String
)

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

fun parseFullName(name: String): Name {
    val parser = name.split(" ")
    return Name(firstName = parser.first(), lastName = parser.last())
}


fun main() {

    println(data.split("\n").joinToString(" "))

    println(data.split("\n").chunked(2).joinToString(" "))

    println(data.split("\n").windowed(2, 3, true).joinToString(" "))

    println(data.split("\n").windowed(2, 4, false).joinToString(" "))

    elements.chunked(2) { (switch, value) -> switch to value }.toMap()

    elements.windowed(2, 2, false) { (switch, value) -> switch to value }.toMap()

    println(elements.zipWithNext { a, b -> a to b }.forEach(::println))

    println(elements.zipWithNext { a, b -> " $a ---> $b --->" }.forEach(::print))

    elements.shuffled().forEach(::println)

    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println(shortWords)

    val doubled = List(3, { it * 2 })  // or MutableList if you want to change its content later
    println(doubled)

    val sourceList = mutableListOf(1, 2, 3)
    val copySet = sourceList.toMutableSet()
    copySet.add(3)
    copySet.add(4)
    println(copySet)

    val numbers = listOf("one", "two", "three", "four", "five", "six", "seven")
    println(numbers.associateWith { it.length })

    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) listIterator.next()
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }

    val mutableIterator = numbers.toMutableList().iterator()

    mutableIterator.next()
    mutableIterator.remove()
    println("After removal: $numbers")

    val mutableListIterator = numbers.toMutableList().listIterator()

    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println(numbers)

    val numbersSequence = sequenceOf("four", "three", "two", "one")
    numbersSequence.forEach(::println)
    val seqNumbers = numbers.asSequence()

    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
    println(oddNumbers.take(5).toList())

    val numberGenerator = generateSequence(1) { if (it < 10) it + 1 else null }
    numberGenerator.forEach(::print)
    println()
    println(measureTimeMillis {
        val list = generateSequence(1) { if (it < 10) it + 1 else null }
    })

    println(
        measureTimeMillis {
            val list = mutableListOf<Int>()
            (0..10).forEach { list.add(it) }
        }
    )

    val odds = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(odds.take(5).toList())

    val someWords = "The quick brown fox jumps over the lazy dog".split(" ")
    println(
        measureNanoTime {
            val lengthsList = someWords.filter { println("filter: $it"); it.length > 3 }
                .map { println("length:$it ${it.length}"); it.length }
                .take(4)

            println("Lengths of first 4 words longer than 3 chars:")
            println(lengthsList)
        })

    val wordsSequence = someWords.asSequence()
    println(
        measureNanoTime {
            val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
                .map { println("length: ${it.length}"); it.length }
                .take(4)

            println("Lengths of first 4 words longer than 3 chars")
            println(lengthsSequence.toList())
        }
    )

    val filterResults = mutableListOf<String>()  //destination object
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults) // contains results of both operations

    val z = numbers.filterTo(hashSetOf()) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })
    println(numbersMap.mapKeys { it.key.toUpperCase() }.mapValues { it.value + it.key.length })

    println("\nZip")
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))
    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color" })
    println(colors.zipWithNext { a, b -> a to b })

    val zippedPairList = colors zip animals
    println(zippedPairList)
    val unzippedLists = zippedPairList.unzip()
    println(unzippedLists)
    unzippedLists.first.forEach(::print)
    println()
    unzippedLists.second.forEach(::print)
    println()
    println("\nAssociate")
    println(numbers.associateWith { it.length })
    println(shapeList.associateWith(valueSelector = { "${it.id} - ${it.name}" }))
    println(shapeList.associate(transform = { it.name to it.id }))
    println(shapeList.associateBy(keySelector = { it.id }, valueTransform = { it.name.capitalize() }))
    shapeList.associateBy(keySelector = { it.id }, valueTransform = { it.name.capitalize() }).toList()
        .unzip().second.forEach(::println)
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate(transform = { name -> parseFullName(name).let { it.lastName to it.firstName } }))

    println("\nFlatten")
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten().toSet())

    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values })

    println("\nJoin")
    println(containers.flatMap { it.values }.joinToString(separator = ","))
    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString)
    println(listString)
    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    println("\nFilter")
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") and (value > 10) }
    println(filteredMap)

    println(numbers)
    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) and (s.length < 5) }
    val filteredNot = numbers.filterNot { it.length <= 3 }

    println(filteredIdx)
    println(filteredNot)
    println("\nFilter Instance")
    val numbersMess = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    numbersMess.filterIsInstance<String>().forEach(::print)
    val dest = mutableListOf<String>()
    numbersMess.filterIsInstanceTo(destination = dest)
    dest.forEach(::print)

    numbers.filterNotNull().forEach {
        println(it.length)   // length is unavailable for nullable Strings
    }
    println("\nPartition")
    val (match, rest) = numbers.partition { it.length > 3 }
    println(match)
    println(rest)
    println("\nAny and None")
    println(numbers.any { it.endsWith("e") }) // returns true if at least one element matches the given predicate.
    println(numbers.none { it.endsWith("a") }) // returns true if none of the elements match the given predicate.
    println(numbers.all { it.endsWith("e") }) // returns true if all elements match the given predicate.

    // Note that all() returns true when called with any valid predicate on an empty collection. Such behavior is known in logic as vacuous truth.
    println(emptyList<Int>().all { it > 5 })

    val empty = emptyList<String>()
    println("\nAny and None")
    println(numbers.any())
    println(empty.any())

    println(numbers.none())
    println(empty.none())

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)
    println("\nGrouping")
    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

    println(numbers.groupingBy { it.first() }.eachCount())
    println("\nSlice")
    println(numbers)
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))
    println("\nTake and drop")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
    println()
    println(numbers.takeWhile { !it.startsWith('f') })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })

    println("\nChunked")
    val someNumbers = (1..13).toList()
    println(someNumbers.chunked(3))
    println(someNumbers.chunked(3).dropLastWhile { it.size < 3 })
    println(someNumbers.chunked(size = 3, transform = { it.sum() }))

    println("\nWindowed")
    println(numbers.windowed(size = 4, partialWindows = true))
    println(numbers.windowed(size = 4, partialWindows = false))
    println(numbers.windowed(size = 4, partialWindows = true, step = 2))
    println(numbers.windowed(size = 4, partialWindows = true, step = 3))
    println(numbers.windowed(size = 2, partialWindows = true, step = 2))
    println(someNumbers.windowed(3) { it.sum() })

    println(numbers.zipWithNext())
    println(numbers.zipWithNext { s1, s2 -> s1.length > s2.length })

    println("\nRetrieving Single Element")
    println(numbers.elementAt(3))

    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet)
    println(numbersSortedSet.elementAt(3))
    println(numbers.first())
    println(numbers.last())
    println(numbers.first { it.length > 3 })
    println(numbers.last { it.startsWith("f") })
    println(numbers.elementAtOrNull(5))
    println(numbers.elementAtOrElse(8) { index -> "The value for index $index is undefined" })
    println(
        someNumbers.elementAtOrElse(
            index = 17,
            defaultValue = { index -> "The value for index $index is undefined" })
    )
    println(numbers.firstOrNull { it.length > 6 })
    println(numbers.lastOrNull { it.length > 6 })
    println(someNumbers.find { it % 2 == 0 })
    println(someNumbers.findLast { it % 2 == 0 })

    println("\nChecking Existing")
    println(numbers.contains("four"))
    println("zero" in numbers)
    println(numbers.containsAll(listOf("four", "two")))
    println(numbers.containsAll(listOf("one", "zero")))
    println(numbers.isEmpty())
    println(numbers.isNotEmpty())
    println(empty.isEmpty())
    println(empty.isNotEmpty())

    println("\nComparable")
    println(Version(1, 2) > Version(1, 3))
    println(Version(2, 0) > Version(1, 5))
    val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
    println(listOf("aaa", "bb", "c").sortedWith(comparator = compareBy { it.length }))

    println("Sorted ascending: ${someNumbers.sorted()}")
    println("Sorted descending: ${someNumbers.sortedDescending()}")


    val sortedNumbers = numbers.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")
    val sortedByLast = numbers.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    println(numbers.reversed())
    println(numbers.asReversed())

    println("\nCollection Aggregate Operations")
    println("Count: ${someNumbers.count()}")
    println("Max: ${someNumbers.max()}")
    println("Min: ${someNumbers.min()}")
    println("Average: ${someNumbers.average()}")
    println("Sum: ${someNumbers.sum()}")
    val minRemainder = someNumbers.minBy { it % 3 }
    println(minRemainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWith(compareBy { it.length })
    println(longestString)

    println(someNumbers.sumBy { it * 2 })
    println(someNumbers.sumByDouble { it.toDouble() / 2 })

    val sum = someNumbers.reduce { sum, element -> sum + element }
    println(sum)
    val sumDoubled = someNumbers.fold(0) { sum, element -> sum + element * 2 }
    println(sumDoubled)
    val sumDoubledRight = someNumbers.foldRight(0) { element, sum -> sum + element * 2 }
    println(sumDoubledRight)
    val sumEven = someNumbers.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    println(sumEven)
    val sumEvenRight = someNumbers.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
    println(sumEvenRight)

    someNumbers.fold(0) { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = someNumbers.fold("Elements:", { acc, i -> acc + " " + i })
    println(joinedToString)

// Function references can also be used for higher-order function calls:
    val product = someNumbers.fold(1, { acc, i ->
        print("acc = $acc, i = $i, ")
        val result = acc * i
        println("result = $result")
        result
    })
    println(product)

    val productCool = someNumbers.fold(1, Int::times)
    println(productCool)
}

class Version(val major: Int, val minor: Int) : Comparable<Version> {
    override fun compareTo(other: Version): Int {
        if (this.major != other.major) {
            return this.major - other.major
        } else if (this.minor != other.minor) {
            return this.minor - other.minor
        } else return 0
    }
}

