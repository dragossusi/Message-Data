package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
expect interface MessageData {

    fun getMessage(parser: MessageDataParser): CharSequence

}