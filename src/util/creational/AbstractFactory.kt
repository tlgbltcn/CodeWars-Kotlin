package util.creational

import java.lang.IllegalArgumentException

interface Chart {
    fun draw()
}

interface LineChart : Chart {
    override fun draw()
    var thickness: Double?
}

interface PieChart : Chart {
    override fun draw()
    var perimeter: Double?
}

class iOSLineChart(override var thickness: Double? = null) : LineChart {
    override fun draw() = println("This is iOS line chart draw. ${thickness?.let { "Thickness : $it" } ?: ""}")
}

class AndroidLineChart(override var thickness: Double? = null) : LineChart {
    override fun draw() = println("This is Android line chart draw. ${thickness?.let { "Thickness : $it" } ?: ""}")
}

class iOSPieChart(override var perimeter: Double? = null) : PieChart {
    override fun draw() = println("This is iOS pie chart draw. ${perimeter?.let { "Perimeter : $it" } ?: ""}")
}

class AndroidPieChart(override var perimeter: Double? = null) : PieChart {
    override fun draw() = println("This is Android pie chart draw. ${perimeter?.let { "Perimeter : $it" } ?: ""}")
}

abstract class ChartFactory {

    abstract fun createLineChart(): LineChart

    abstract fun createPieChart(): PieChart

    companion object {
        inline fun <reified T : Chart> createChartFactory(): ChartFactory = when (T::class) {
            iOSLineChart::class, iOSPieChart::class -> iOSChartFactory()
            AndroidLineChart::class, AndroidPieChart::class -> AndroidChartFactory()
            else -> throw  IllegalArgumentException("There isn't os type.")
        }
    }
}

class iOSChartFactory : ChartFactory() {
    override fun createLineChart(): LineChart = iOSLineChart()
    override fun createPieChart(): PieChart = iOSPieChart()

}

class AndroidChartFactory : ChartFactory() {
    override fun createLineChart(): LineChart = AndroidLineChart()
    override fun createPieChart(): PieChart = AndroidPieChart()
}

fun main() {

    val androidLineChart = ChartFactory.createChartFactory<AndroidLineChart>().createLineChart()
    androidLineChart.apply {
        thickness = 100.0
        draw()
    }

    val iOSPieChart = ChartFactory.createChartFactory<iOSPieChart>().createPieChart()
    iOSPieChart.draw()
}