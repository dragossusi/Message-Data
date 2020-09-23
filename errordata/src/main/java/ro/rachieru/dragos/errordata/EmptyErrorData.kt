package ro.rachieru.dragos.errordata

import android.content.res.Resources
import kotlinx.android.parcel.Parcelize

/**
 *
 * @author Dragos
 * @since 17.06.2020
 */
@Parcelize
class EmptyErrorData : ErrorData {

    override fun getError(resources: Resources): String {
        return ""
    }

}