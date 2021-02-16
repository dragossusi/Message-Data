package ro.dragossusi.messagedata

/**
 *
 * @author Dragos
 * @since 02.07.2020
 */
fun Throwable.toMessageData(): MessageData {
    return ThrowableMessageData(this)
}

fun String.toMessageData(): MessageData {
    return StringMessageData(this)
}