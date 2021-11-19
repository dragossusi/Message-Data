package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
object EmptyMessageData : MessageData {

    override fun getMessage(parser: MessageDataParser): CharSequence {
        return ""
    }

}