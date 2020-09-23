package ro.rachieru.dragos.errordata

import android.content.res.Resources
import android.os.Parcelable

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
interface ErrorData : Parcelable {

    fun getError(resources: Resources): String

}