package util.creational.communication

sealed class Communication {

    class Bis : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.BIS.ordinal
    }

    class Acces : Communication() {
        override fun visibility() = INVISIBLE
        override val id: Int = CommunicationEnum.ACCESS.ordinal
    }

    class Mobil : Communication() {
        override fun visibility() = INVISIBLE
        override val id: Int = CommunicationEnum.MOBIL.ordinal
    }

    class FacebookDm : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.FACEBOOK.ordinal
    }

    class FacebookPost : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.FACEBOOK.ordinal

    }

    class FacebookDirect : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.FACEBOOK.ordinal

    }

    class TwitterDm : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.TWITTER.ordinal
    }

    class TwitterPost : Communication() {
        override fun visibility() = VISIBLE
        override val id: Int = CommunicationEnum.TWITTER.ordinal

    }

    class TwitterDirect : Communication() {
        override fun visibility() = TICKET
        override val id: Int = CommunicationEnum.TWITTER.ordinal
    }

    class Unknown: Communication() {
        override fun visibility() = -1
        override val id: Int = -1
    }

    abstract fun visibility(): Int

    abstract val id: Int

    companion object {
        const val TICKET = 0
        const val CONVERSITION = 1

        const val VISIBLE = 0
        const val INVISIBLE = 1
    }
}

enum class CommunicationEnum {
    BIS,
    ACCESS,
    MOBIL,
    FACEBOOK,
    TWITTER,
    Unknown
}

