package ro.rachieru.dragos.errordata

import android.content.res.Resources
import kotlinx.android.parcel.Parcelize
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
class StringErrorData(val message: String) : ErrorData {

    override fun getError(resources: Resources): String = message

}