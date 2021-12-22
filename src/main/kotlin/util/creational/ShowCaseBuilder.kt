package util.creational

class ShowCaseBuilder(var step: MutableList<Step>?) {

    data class Builder(var step: MutableList<Step> = mutableListOf()) {
        fun addStep(step: Step) = apply { this.step.add(step) }
        fun build(): ShowCaseBuilder = ShowCaseBuilder(step = step)
    }
}

data class Step(
    var title: String? = null,
    var desc: String? = null,
    var image: Int? = null
)

fun main() {

    val showCaseBuilder = ShowCaseBuilder.Builder()
        .addStep(Step("Pager 1", "Description 1", 1))
        .addStep(Step("Pager 2", "Description 2", 2))
        .addStep(Step("Pager 3", "Description 3", 3))
        .addStep(Step("Pager 4", "Description 4", 4))
        .addStep(Step("Pager 5", "Description 5", 5))
        .build()

    showCaseBuilder
}