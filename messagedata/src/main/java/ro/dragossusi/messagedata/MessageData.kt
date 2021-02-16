package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser
import java.io.Serializable

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
interface MessageData : Serializable {

    fun getMessage(parser: MessageDataParser): String

}

operator fun MessageData.plus(
    messageData: MessageData
): MessageData = ConcatMessageData(this, messageData)