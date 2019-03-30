package katas.`6kyu`

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * This is a series of Kotlin tricks.

We have (preloaded):

data class Box(var x: Int, var y: Int, var width: Int, var height: Int) {
fun area() = width * height
fun rightDown() = width + x to height + y
fun rightUp() = width + x to height
fun leftDown() = width to (height + y)
}
We want to do something (you can do anything) that allow you to do the job shown below:

val box = Box(...)
box {
println(area()) // box.area()
println(width)
width += 1 // box.width is increased by 1
println(width)
}
 */
fun main() {

    val box = Box(10, 10, 20, 20)

    box {
        println(area()) // box.area()
        println(width)
        width += 1 // box.width is increased by 1
        println(width)
    }
}

inline operator fun Box.invoke(block: Box.() -> Unit) = block(this)

data class Box(var x: Int, var y: Int, var width: Int, var height: Int) {
    fun area() = width * height
    fun rightDown() = width + x to height + y
    fun rightUp() = width + x to height
    fun leftDown() = width to (height + y)
}

class KotlinTricks5 {
    @Test
    fun testBox() {
        val rand = Random(System.currentTimeMillis())
        val xx = rand.nextInt(100)
        val yy = rand.nextInt(100)
        val box = Box(xx, yy, xx + rand.nextInt(1000), yy + rand.nextInt(1000))
        val testerBox = box.copy()
        fun boxEquals(testerBox: Box, box: Box) {
            assertEquals(testerBox, box)
            assertEquals(testerBox.area(), box.area())
            assertEquals(testerBox.leftDown(), box.leftDown())
            assertEquals(testerBox.rightDown(), box.rightDown())
            assertEquals(testerBox.rightUp(), box.rightUp())
        }

        box {
            var r = rand.nextInt(10)
            boxEquals(testerBox, box)
            x -= r
            testerBox.x -= r
            boxEquals(testerBox, box)
            r = rand.nextInt(10)
            y -= r
            testerBox.y -= r
            boxEquals(testerBox, box)
            r = rand.nextInt(10)
            width += r
            testerBox.width += r
            boxEquals(testerBox, box)
            r = rand.nextInt(10)
            height += r
            testerBox.height += r
            boxEquals(testerBox, box)
        }

    }
}

