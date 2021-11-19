package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
data class StringMessageData(val message: String) : MessageData {

    override fun getMessage(parser: MessageDataParser): String {
        return message
    }

}
