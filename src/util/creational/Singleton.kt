package util.creational

class Problem {
    private var value: Boolean = false

    fun setVariable(value: Boolean) {
        this.value = value
    }

    fun getVariable(): Boolean = value
}

// Singleton create with Object
object Provider {

    private var value: Boolean = false

    fun setVariable(value: Boolean) {
        this.value = value
    }

    fun getVariable(): Boolean = value
}

// Single create with companion object
class Helper {

    private var value: Boolean = false

    fun setVariable(value: Boolean) {
        this.value = value
    }

    fun getVariable(): Boolean = value

    private object SingletonHolder {
        val instance = Helper()
    }

    companion object {
        fun getInstance(): Helper = SingletonHolder.instance
    }
}

class Notification {

    private var value: Boolean = false

    fun setVariable(value: Boolean) {
        this.value = value
    }

    fun getVariable(): Boolean = value

    companion object {

        private var INSTANCE: Notification? = null

        fun getInstance() = INSTANCE ?: Notification().also { INSTANCE = it }
    }
}

fun main() {

    //problem
    val problem1 = Problem()
    val problem2 = Problem()
    problem1.setVariable(true)
    problem2.getVariable()

    println(problem1 === problem2)
    println(problem1 == problem2)
    println("problem value is " + problem1.getVariable().toString())
    println("problem value is " + problem2.getVariable().toString())

    val provider1 = Provider
    val provider2 = Provider
    provider1.setVariable(true)
    provider2.getVariable()

    println(provider1 === provider2)
    println(provider1 == provider2)
    println("provider value is " + provider1.getVariable().toString())
    println("provider value is " + provider2.getVariable().toString())

    val helper1 = Helper.getInstance()
    val helper2 = Helper.getInstance()
    helper1.setVariable(true)
    helper2.getVariable()

    println(helper1 === helper2)
    println(helper1 == helper2)
    println("helper value is " + helper1.getVariable().toString())
    println("helper value is " + helper2.getVariable().toString())

    val notification1 = Notification.getInstance()
    val notification2 = Notification.getInstance()
    notification1.setVariable(true)
    notification2.getVariable()

    println(notification1 === notification2)
    println(notification1 == notification2)
    println("notification value is " + notification1.getVariable().toString())
    println("notification value is " + notification2.getVariable().toString())
}


