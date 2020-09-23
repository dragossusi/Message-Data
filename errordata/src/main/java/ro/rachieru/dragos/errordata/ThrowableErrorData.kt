package ro.rachieru.dragos.errordata

import android.content.res.Resources
import kotlinx.android.parcel.Parcelize
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
@Parcelize
class ThrowableErrorData(val throwable: Throwable) : ErrorData {

    override fun getError(resources: Resources): String {
        return throwable.localizedMessage ?: "unknown error"
    }

}