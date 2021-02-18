package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser
import java.io.Serializable

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
class ThrowableMessageData(
    val throwable: Throwable,
    val fallback: MessageData = "Unknown Error".toMessageData()
) : MessageData, Serializable {

    override fun getMessage(parser: MessageDataParser): String {
        return throwable.localizedMessage ?: fallback.getMessage(parser)
    }

}