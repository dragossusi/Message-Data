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
abstract class NetworkMessageDataHandler : MessageDataHandler {

    final override fun routeMessageData(messageData: MessageData): Boolean {
        if (messageData is ThrowableMessageData) {
            return routeThrowable(messageData.throwable)
        }
        return onErrorData(messageData)
    }

    /**
     * @return true if handled
     */
    open fun onErrorData(messageData: MessageData): Boolean {
        return false
    }

    open fun onUnknownError(throwable: Throwable) {}


    /**
     * @return true if handled
     */
    protected open fun routeThrowable(throwable: Throwable): Boolean {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace()
        }
        onUnknownError(throwable)
        return true
    }

}