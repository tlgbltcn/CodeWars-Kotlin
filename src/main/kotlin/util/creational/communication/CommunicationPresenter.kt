package util.creational.communication


class CommunicationPresenter {

    private var id: Int? = -1

    fun setId(id: Int) {
        this.id = id
    }

    fun getId() = id

    fun getCommunication(): Communication {
        return when (id) {
            CommunicationEnum.ACCESS.ordinal -> Communication.Acces()
            CommunicationEnum.BIS.ordinal -> Communication.Bis()
            CommunicationEnum.MOBIL.ordinal -> Communication.Mobil()
            CommunicationEnum.FACEBOOK.ordinal -> Communication.FacebookDirect()
            CommunicationEnum.TWITTER.ordinal -> Communication.TwitterDirect()
            else -> Communication.Unknown()
        }
    }
}


fun main() {

    val communicationPresenter = CommunicationPresenter()

    communicationPresenter.setId(4)
    val communicationVisibility = communicationPresenter.getCommunication().visibility()
    println("type: ${communicationVisibility}")

}