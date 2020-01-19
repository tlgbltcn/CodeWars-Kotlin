package util.creational

// Builder pattern is one of the creation design patterns where an application
// When piecewise object construction is complicated, provide an API for doing it in simple & clear manner

// Builder pattern implementation with data class.
class PdfCreator private constructor(
    private val encoding: String? = null,
    private val name: String? = null,
    private val url: String? = null,
    private val pageSize: Int? = null,
    private val path: String? = null,
    private val content: String? = null,
    private val successCallBack: ((path: String) -> Unit)? = null,
    private val errorCallBack: ((errorCode: Int, errorMessage: String) -> Unit)? = null
) {

    data class Builder(
        private var encoding: String? = null,
        private var name: String? = null,
        private var url: String? = null,
        private var pageSize: Int? = null,
        private var path: String? = null,
        private var content: String? = null,
        private var successCallBack: ((path: String) -> Unit)? = null,
        private var errorCallBack: ((errorCode: Int, errorMessage: String) -> Unit)? = null
    ) {
        fun setEncoding(encoding: String?) = apply { this.encoding = encoding }
        fun setName(name: String?) = apply { this.name = name }
        fun setUrl(url: String?) = apply { this.url = url }
        fun setPageSize(pageSize: Int?) = apply { this.pageSize = pageSize }
        fun setPath(path: String?) = apply { this.path = path }
        fun setContent(content: String?) = apply { this.content = content }
        fun setSuccessCallBack(successCallBack: ((path: String) -> Unit)?) =
            apply { this.successCallBack = successCallBack }

        fun setErrorCallBack(errorCallBack: ((errorCode: Int, errorMessage: String) -> Unit)?) =
            apply { this.errorCallBack = errorCallBack }

        fun build(): PdfCreator {

            when {
                name.isNullOrBlank() -> errorCallBack?.invoke(
                    ErrorFactory.NAME.code,
                    ErrorFactory.NAME.message
                )

                content.isNullOrBlank() -> errorCallBack?.invoke(
                    ErrorFactory.CONTENT.code,
                    ErrorFactory.CONTENT.message
                )

                path.isNullOrBlank() -> errorCallBack?.invoke(
                    ErrorFactory.PATH.code,
                    ErrorFactory.PATH.message
                )

                else -> successCallBack?.invoke(path!!)
            }

            return PdfCreator(
                encoding = encoding,
                name = name,
                url = url,
                pageSize = pageSize,
                path = path,
                content = content,
                successCallBack = successCallBack,
                errorCallBack = errorCallBack
            )
        }
    }

    enum class ErrorFactory(val code: Int, val message: String) {
        NAME(code = 0, message = "Invalid name exception"),
        CONTENT(code = 1, message = "There isn't content"),
        PATH(code = 2, message = "Cannot available to path")
    }
}

// Builder pattern implementation with traditional way.
class Dialog private constructor(builder: Builder) {

    internal class Builder(
        private var title: String? = null,
        private var message: String? = null,
        private var smallIcon: Int? = null,
        private var largeIcon: Int? = null,
        private var positiveActionCallBack: (() -> Unit)? = null,
        private var negativeActionCallBack: (() -> Unit)? = null
    ) {
        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun setMessage(message: String?): Builder {
            this.message = message
            return this
        }

        fun setSmallIcon(icon: Int?): Builder {
            this.smallIcon = icon
            return this
        }

        fun setLargeIcon(icon: Int?): Builder {
            this.largeIcon = icon
            return this
        }

        fun setPositiveActionCallBack(successCallBack: (() -> Unit)?): Builder {
            this.positiveActionCallBack = successCallBack
            return this
        }

        fun setNegativeActionCallBack(errorCallBack: (() -> Unit)?): Builder {
            this.negativeActionCallBack = errorCallBack
            return this
        }

        fun build(): Dialog {

            when {
                message.isNullOrBlank() -> negativeActionCallBack?.invoke()
                title.isNullOrBlank() -> negativeActionCallBack?.invoke()
                else -> positiveActionCallBack?.invoke()
            }

            return Dialog(
                builder = Builder(
                    title = title,
                    message = message,
                    smallIcon = 100,
                    positiveActionCallBack = positiveActionCallBack,
                    negativeActionCallBack = negativeActionCallBack
                )
            )
        }
    }
}

fun main() {

    val successCallBack: ((path: String) -> Unit) = { path ->
        println("SuccesCallBack: $path")
    }

    val errorCallBack: ((errorCode: Int, errorMessage: String) -> Unit) = { errorCode, errorMessage ->
        println("ErrorCallBack: $errorCode - $errorMessage")
    }

    PdfCreator.Builder()
        .setEncoding(encoding = "base64")
        .setName(name = "monthly_receipt.pdf")
        .setPageSize(pageSize = 2)
        .setPath(path = "/data/download")
        .setContent(content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
        .setUrl(url = "https://github.com/tlgbltcn")
        .setSuccessCallBack(successCallBack = successCallBack)
        .setErrorCallBack(errorCallBack = errorCallBack)
        .build()

    Dialog.Builder()
        //.setTitle(title = "asas") // In the empty or unassigned state, an error callback invoked.
        .setMessage(message = "the message will be sent to tbolatcan@gmail.com.")
        .setLargeIcon(icon = 123)
        .setPositiveActionCallBack { println("SuccesCallBack: message was sent successfully.") }
        .setNegativeActionCallBack { println("ErrorCallBack: something went wrong") }
        .build()
}
