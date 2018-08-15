package one.xcorp.feedster.presentation.exception

import android.content.Context
import one.xcorp.feedster.R
import one.xcorp.feedster.data.exception.NetworkConnectionException
import javax.inject.Inject

class MessageFactory @Inject constructor(private val context: Context) {

    fun createMessage(error: Throwable): String = when (error) {
        is NetworkConnectionException -> context.getString(R.string.unable_load_data)
        else -> context.getString(R.string.unknown_error)
    }
}