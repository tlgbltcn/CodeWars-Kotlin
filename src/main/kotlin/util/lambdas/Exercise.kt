package util.lambdas


enum class Color {
    BLACK,
    WHITE,
    GRAY,
    RED,
    BLUE,
    YELLOW
}

sealed class MotorSports(val modelName: String?) {
    open fun extraSpecs(spec: String): String? = null
}

data class SuperCar(
    val name: String? = null,
    val topSpeed: Int? = null,
    val engine: Double? = null,
    val color: Color? = null
) : MotorSports(modelName = name)


data class Motorcycle(
    val name: String? = null,
    val wheelCount: Int? = null,
    val topSpeed: Int? = null,
    val engine: Double? = null,
    val color: Color? = null
) : MotorSports(modelName = name) {
    override fun extraSpecs(spec: String) = "Extra Öhlins suspension"
}

fun <T> List<T>.sortByTopSpeed() : List<T>{

    return this
}

val listVehicles = listOf<MotorSports>(
    SuperCar("Mercedes GLA", 330, 3999.0, Color.BLACK),
    Motorcycle("Ducati Panigale", 2, 350, 1200.0, Color.RED),
    SuperCar("Range Rover", 330, 3999.0, Color.GRAY),
    Motorcycle("Honda CB650R", 2, 270, 1200.0, Color.BLACK),
    Motorcycle("Triumph", 2, 370, 1200.0, Color.WHITE),
    SuperCar("Lamborghini Aventador", 400, 3999.0, Color.GRAY),
    SuperCar("Porche 911GT", 350, 3999.0, Color.BLACK),
    Motorcycle("Yamaha R6", 2, 296, 1200.0, Color.BLUE),
    Motorcycle("BMW S1000R", 2, 370, 1200.0, Color.YELLOW),
    Motorcycle("Suzuki GSX-600", 2, 290, 1200.0, Color.RED)
)

fun main() {

    listVehicles.sortByTopSpeed().forEach {

        it.modelName
    }

}

