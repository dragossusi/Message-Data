package ro.rachieru.dragos.errordata

/**
 *
 * @author Dragos
 * @since 02.07.2020
 */
fun Throwable.toErrorData(): ErrorData {
    return ThrowableErrorData(this)
}