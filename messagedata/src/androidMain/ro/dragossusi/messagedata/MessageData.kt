package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser
import java.io.Serializable

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
actual interface MessageData : Serializable {

    actual fun getMessage(parser: MessageDataParser): CharSequence

}