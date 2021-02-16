package ro.dragossusi.messagedata.handler

import ro.dragossusi.messagedata.MessageData

/**
 *
 * @author Dragos
 * @since 02.07.2020
 */
interface MessageDataHandler {

    /**
     * @return true if handled
     */
    fun routeErrorData(messageData: MessageData): Boolean

}