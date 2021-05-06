package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

class FormatMessageData(
    val format: MessageData,
    vararg val args: MessageData
): MessageData {
    override fun getMessage(parser: MessageDataParser): CharSequence {
        val arguments = args.map {
            it.getMessage(parser)
        }
        return format.toString().format(
            *arguments.toTypedArray()
        )
    }
}