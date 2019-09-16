package util

class MyListenerBuilder {

    fun setListener(listener: ListenerBuilder.() -> Unit) {
        mListener = ListenerBuilder().also(listener)
    }
    private lateinit var mListener: ListenerBuilder

    inner class ListenerBuilder {
        internal var mLoadingStateAction: ((Boolean, String) -> Unit)? = null
        internal var mSuccesStateAction: ((Boolean, String) -> Unit)? = null
        internal var mErrorStateAction: ((Boolean, String) -> String)? = null

        fun onLoadingState(action: (Boolean, String) -> Unit) {
            mLoadingStateAction = action
        }

        fun onSuccesState(action: (Boolean, String) -> Unit) {
            mSuccesStateAction = action
        }

        fun onErrorState(action: (Boolean, String) -> String) {
            mErrorStateAction = action
        }
    }

}


fun main() {

    var str = "d"

    MyListenerBuilder().setListener {

        onSuccesState { b, s ->
            str = "$b ---- $s"

        }
    }

    print(str)
}