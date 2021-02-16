package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser
import java.io.Serializable

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
object EmptyMessageData : MessageData, Serializable {

    override fun getMessage(parser: MessageDataParser): String {
        return ""
    }

}