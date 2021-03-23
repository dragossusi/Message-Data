package ro.dragossusi.messagedata.android.handler

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.LocalizedMessageData
import ro.dragossusi.messagedata.android.R
import ro.dragossusi.messagedata.android.alert.AlertHandler
import ro.dragossusi.messagedata.android.parser.ResourceMessageDataParser
import ro.dragossusi.messagedata.toMessageData

/**
 *
 * @author Dragos
 * @since 10.06.2020
 */
open class AlertMessageDataHandler(
    private val alertHandler: AlertHandler
) : NetworkMessageDataHandler() {


    override fun onErrorData(messageData: MessageData): Boolean {
        alertHandler.showError(messageData)
        return false
    }

    override fun onUnknownError(throwable: Throwable) {
        throwable.message?.let {
            alertHandler.showError(it.toMessageData())
        } ?: alertHandler.showError(LocalizedMessageData(R.string.error_generic_network))
    }

}