package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author dragos
 * @since 15/02/21
 */
data class ListErrorData(
    val list: List<MessageData>,
    val separator: MessageData
) : MessageData {

    constructor(
        list: List<MessageData>,
        separator: String
    ) : this(list, separator.toMessageData())

    override fun getMessage(parser: MessageDataParser): String {
        return list.joinToString(separator = separator.getMessage(parser)) {
            it.getMessage(parser)
        }
    }
}

fun List<MessageData>.join(separator: MessageData): ListErrorData {
    return ListErrorData(this, separator)
}

fun List<MessageData>.join(separator: String): ListErrorData {
    return ListErrorData(this, separator)
}