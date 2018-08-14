package one.xcorp.feedster.presentation.model

import one.xcorp.feedster.presentation.model.StatusModel.Type.*

data class StatusModel<out T> constructor(
        val type: Type, val data: T?, val message: String?) {

    companion object {

        fun <T> loading(data: T?): StatusModel<T> {
            return StatusModel(LOADING, data, null)
        }

        fun <T> error(msg: String, data: T?): StatusModel<T> {
            return StatusModel(ERROR, data, msg)
        }

        fun <T> success(data: T?): StatusModel<T> {
            return StatusModel(SUCCESS, data, null)
        }
    }

    enum class Type {
        LOADING,
        ERROR,
        SUCCESS
    }
}
