package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author dragos
 * @since 15/02/21
 */
data class ConcatMessageData(
    val first: MessageData,
    val second: MessageData,
    val separator: MessageData? = null
) : MessageData {

    constructor(
        first: MessageData,
        second: MessageData,
        separator: String?
    ) : this(first, second, separator?.toMessageData())

    override fun getMessage(parser: MessageDataParser): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(first.getMessage(parser))
        separator?.let {
            stringBuilder.append(it.getMessage(parser))
        }
        stringBuilder.append(second.getMessage(parser))
        return stringBuilder.toString()
    }

}