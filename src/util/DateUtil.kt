package util

import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*
import java.util.TimeZone

private val FORMAT = "yyyy-MM-dd"

fun main() {
    println(DateUtil.TODAY.calculateDiffDate(DAY_OF_YEAR, 0)::timeInMillisToDate)
    println(DateUtil.SEVEN_DAYS.calculateDiffDate(DAY_OF_YEAR, -7)::timeInMillisToDate)
    println(DateUtil.ONE_MONTH.calculateDiffDate(MONTH, -1)::timeInMillisToDate)
    println(DateUtil.THREE_MONTH.calculateDiffDate(MONTH, -3)::timeInMillisToDate)
    println(DateUtil.SIX_MONTH.calculateDiffDate(MONTH, -6)::timeInMillisToDate)
    println(DateUtil.LAST_YEAR.calculateDiffDate(YEAR, -1)::timeInMillisToDate)
    println(convertDiffToLong(YEAR, -1)::timeInMillisToDate)
}

fun Long.timeInMillisToDate() = SimpleDateFormat(FORMAT).format(Date(this))

fun convertDiffToLong(field: Int, amount: Int): Long {
    val c = getInstance(TimeZone.getTimeZone("UTC"))
    c.add(field, amount)
    return c.timeInMillis
}

enum class DateUtil {

    TODAY {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    },

    SEVEN_DAYS {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    },
    ONE_MONTH {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    },

    THREE_MONTH {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    },

    SIX_MONTH {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    },

    LAST_YEAR {
        override fun calculateDiffDate(field: Int, amount: Int) = convertDiffToLong(field, amount)
    };

    abstract fun calculateDiffDate(field: Int, amount: Int): Long
}


