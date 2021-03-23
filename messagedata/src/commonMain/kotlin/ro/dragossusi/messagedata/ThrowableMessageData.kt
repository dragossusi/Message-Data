package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
data class ThrowableMessageData(
    val throwable: Throwable,
    val fallback: MessageData = "Unknown Error".toMessageData()
) : MessageData {

    override fun getMessage(parser: MessageDataParser): CharSequence {
        return throwable.message ?: fallback.getMessage(parser)
    }

}