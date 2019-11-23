package util

object Operators {

    @JvmStatic
    fun main(args: Array<String>) {
        println(timeValidations(3500F))
    }

    private fun timeValidations(time: Float): String {

        val toTimeMillis = Math.round(time / 60)
        val hours = toTimeMillis / 60
        val minutes = toTimeMillis % 60

        var _minutes = ""
        var _hours = ""

        if (hours > 0) _hours = "$hours" + if (hours == 1) " hour" else " hours"
        if (minutes > 0) _minutes = "$minutes" + if (minutes == 1) " minute" else " minutes"
        if (hours == 0 && minutes == 0) _minutes = "less than 1 minute"


        return "$_hours  $_minutes "
    }
}
