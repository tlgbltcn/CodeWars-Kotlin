package util.creational


class FoodOrder private constructor(builder: Builder) {

    private val bread: String?
    private val condiments: String?
    private val meat: String?
    private val fish: String?

    init {
        this.bread = builder.bread
        this.condiments = builder.condiments
        this.meat = builder.meat
        this.fish = builder.fish
    }

    class Builder {

        var bread: String? = null
            private set
        var condiments: String? = null
            private set
        var meat: String? = null
            private set
        var fish: String? = null
            private set

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(this)
    }
}

fun main() {
    val foodOrder = FoodOrder.Builder()
        .bread("Yes")
        .condiments("Yes")
        .build()
}
