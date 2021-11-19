package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author dragos
 * @since 15/02/21
 */
actual data class ConcatMessageData actual constructor(
    val first: MessageData,
    val second: MessageData,
    val separator: MessageData?
) : MessageData {

    actual constructor(
        first: MessageData,
        second: MessageData,
        separator: String?
    ) : this(first, second, separator?.toMessageData())

    override fun getMessage(parser: MessageDataParser): CharSequence {
        val stringBuilder = StringBuilder()
        stringBuilder.append(first.getMessage(parser))
        separator?.let {
            stringBuilder.append(it.getMessage(parser))
        }
        stringBuilder.append(second.getMessage(parser))
        return stringBuilder.toString()
    }

}