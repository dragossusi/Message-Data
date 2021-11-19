package ro.dragossusi.messagedata

import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author dragos
 * @since 15/02/21
 */
expect class ConcatMessageData constructor(
    first: MessageData,
    second: MessageData,
    separator: MessageData? = null
) : MessageData {

    constructor(
        first: MessageData,
        second: MessageData,
        separator: String?
    )

}