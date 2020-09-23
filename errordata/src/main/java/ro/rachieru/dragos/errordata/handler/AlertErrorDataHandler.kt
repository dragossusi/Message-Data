package ro.rachieru.dragos.errordata.handler

import android.content.Context
import androidx.appcompat.app.AlertDialog
import ro.rachieru.dragos.errordata.ErrorData
import ro.rachieru.dragos.errordata.R

/**
 *
 * @author Dragos
 * @since 10.06.2020
 */
open class AlertErrorDataHandler(
    val context: Context
) : NetworkErrorDataHandler() {

    override fun onErrorData(errorData: ErrorData): Boolean {
        showError(errorData.getError(context.resources))
        return false
    }

    override fun onUnknownError(throwable: Throwable) {
        val message = throwable.message ?: context.getString(R.string.error_generic_network)
        showError(message)
    }

    protected open fun showError(message: String) {
        AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }

}