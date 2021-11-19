package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.error.MessageDataException
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
data class ThrowableMessageData constructor(
    val throwable: Throwable,
    val fallback: MessageData = throwable::class.simpleName?.toMessageData() ?: EmptyMessageData
) : MessageData {

    override fun getMessage(parser: MessageDataParser): CharSequence {
        return if (throwable is MessageData) throwable.getMessage(parser)
        else throwable.message ?: fallback.getMessage(parser)
    }

}