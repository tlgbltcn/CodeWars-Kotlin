package util.creational

class FooOrder(val pepper: String?,
               val bread: String?,
               val soup: String?,
               val fish: String?,
               val salads: String?) {

    data class Builder(var pepper: String? = null,
                       var bread: String? = null,
                       var soup: String? = null,
                       var fish: String? = null ,
                       var salads: String? = null) {
        fun bread(bread: String?) = apply { this.bread = bread }
        fun pepper(pepper: String?) = apply { this.pepper = pepper }
        fun soup(soup: String?) = apply { this.soup = soup }
        fun fish(fish: String?) = apply { this.fish = fish }
        fun salads(salads: String?) = apply { this.salads = salads }
        fun build() = FooOrder(pepper, bread, soup, fish, salads)
    }

}

fun main() {
    val fooOrder = FooOrder.Builder()
        .bread("Yes")
        .bread("")
        .fish("Yes")
        .salads("No")
        .build()
}