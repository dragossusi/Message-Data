package ro.dragossusi.messagedata.android.handler

import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.ThrowableMessageData
import ro.dragossusi.messagedata.android.BuildConfig
import ro.dragossusi.messagedata.handler.MessageDataHandler

/**
 *
 * @author Dragos
 * @since 10.06.2020
 */
abstract class BaseMessageDataHandler : MessageDataHandler {

    final override fun routeMessageData(messageData: MessageData): Boolean {
        if (messageData is ThrowableMessageData) {
            if (BuildConfig.DEBUG) {
                messageData.throwable.printStackTrace()
            }
        }
        return onMessageData(messageData)
    }

    /**
     * @return true if handled
     */
    open fun onMessageData(messageData: MessageData): Boolean {
        return false
    }

}