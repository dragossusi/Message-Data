package ro.rachieru.dragos.errordata

import android.content.res.Resources
import androidx.annotation.PluralsRes
import kotlinx.android.parcel.Parcelize
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
class PluralStringFormatErrorData(
    @PluralsRes
    val pluralRes: Int,
    val quantity: Int,
    vararg val args: String
) : ErrorData {

    override fun getError(resources: Resources): String {
        return resources.getQuantityString(pluralRes, quantity, args)
    }

}