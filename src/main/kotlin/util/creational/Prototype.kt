package util.creational

enum class EngineType {
    GASOLINE,
    ELECTRIC
}

data class Car(
    val engineType: Int? = null,
    val power: Double? = null,
    val topSpeed: Double? = null,
    val weight: Double? = null,
    val width: Double? = null,
    val height: Double? = null
) {
    fun printSpecs() {
        println(
            "Engine Type: $engineType \n" +
                    "Power: $power \n" +
                    "Top Speed: $topSpeed \n" +
                    "Weight: $weight \n" +
                    "Width: $width \n" +
                    "Height: $height \n"
        )
    }
}

fun Car.print() = printSpecs()

fun main() {

    val porsche = Car(
        engineType = EngineType.GASOLINE.ordinal,
        power = 565.4,
        topSpeed = 320.3,
        weight = 1234.3,
        width = 4.1,
        height = 1.5
    )

    val tesla = porsche.copy(
        engineType = EngineType.ELECTRIC.ordinal,
        power = 465.0,
        topSpeed = 310.3,
        weight = 934.3,
        width = 3.9,
        height = 1.4
    )

    val ferrari = porsche.copy(power = 700.0)

    porsche.printSpecs()
    tesla.printSpecs()
    ferrari.printSpecs()
}