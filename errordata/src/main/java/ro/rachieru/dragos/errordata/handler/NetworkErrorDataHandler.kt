package ro.rachieru.dragos.errordata.handler

import ro.rachieru.dragos.errordata.BuildConfig
import ro.rachieru.dragos.errordata.ErrorData
import ro.rachieru.dragos.errordata.ThrowableErrorData

/**
 *
 * @author Dragos
 * @since 10.06.2020
 */
abstract class NetworkErrorDataHandler : ErrorDataHandler {

    final override fun routeErrorData(errorData: ErrorData): Boolean {
        if (errorData is ThrowableErrorData) {
            return routeThrowable(errorData.throwable)
        }
        return onErrorData(errorData)
    }

    /**
     * @return true if handled
     */
    open fun onErrorData(errorData: ErrorData): Boolean {
        return false
    }

    open fun onUnknownError(throwable: Throwable) {}


    /**
     * @return true if handled
     */
    protected open fun routeThrowable(throwable: Throwable): Boolean {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace()
        }
        when (throwable) {
            else -> onUnknownError(throwable)
        }
        return true
    }

}