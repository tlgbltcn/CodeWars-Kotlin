package util

import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*
import java.util.TimeZone

private val FORMAT = "yyyy-MM-dd"

fun main() {
    println(DateUtil.TODAY.calculateDiffDate(DAY_OF_YEAR, 0).timeInMillisToDate(FORMAT))
    println(DateUtil.SEVEN_DAYS.calculateDiffDate(DAY_OF_YEAR, -7).timeInMillisToDate(FORMAT))
    println(DateUtil.ONE_MONTH.calculateDiffDate(MONTH, -1).timeInMillisToDate(FORMAT))
    println(DateUtil.THREE_MONTH.calculateDiffDate(MONTH, -3).timeInMillisToDate(FORMAT))
    println(DateUtil.SIX_MONTH.calculateDiffDate(MONTH, -6).timeInMillisToDate(FORMAT))
    println(DateUtil.LAST_YEAR.calculateDiffDate(YEAR, -1).timeInMillisToDate(FORMAT))
    println(convertDiffToLong(YEAR, -1).timeInMillisToDate(FORMAT))
}

fun Long.timeInMillisToDate(format: String) = SimpleDateFormat(format).format(Date(this))

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


