package ro.dragossusi.messagedata.android.handler

import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.alert.AlertHandler

/**
 *
 * @author Dragos
 * @since 10.06.2020
 */
open class AlertMessageDataHandler(
    private val alertHandler: AlertHandler
) : BaseMessageDataHandler() {


    override fun onMessageData(messageData: MessageData): Boolean {
        alertHandler.showMessage(messageData)
        return false
    }

}