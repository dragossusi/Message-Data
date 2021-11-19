package ro.dragossusi.messagedata

/**
 *
 * @author Dragos
 * @since 02.07.2020
 */
fun Throwable.toMessageData(): MessageData {
    return if (this is MessageData) this
    else ThrowableMessageData(this)
}

fun String.toMessageData(): MessageData {
    return StringMessageData(this)
}