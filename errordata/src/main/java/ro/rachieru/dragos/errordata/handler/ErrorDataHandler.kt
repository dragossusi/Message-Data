package ro.rachieru.dragos.errordata.handler

import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 02.07.2020
 */
interface ErrorDataHandler {

    /**
     * @return true if handled
     */
    fun routeErrorData(errorData: ErrorData): Boolean

}