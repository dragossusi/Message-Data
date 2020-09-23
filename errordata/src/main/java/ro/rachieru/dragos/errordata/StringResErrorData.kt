package ro.rachieru.dragos.errordata

import android.content.res.Resources
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.StringRes

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
open class StringResErrorData(@StringRes val stringRes: Int) : ErrorData {

    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun getError(resources: Resources): String {
        return resources.getString(stringRes)
    }

    override fun hashCode(): Int {
        return stringRes.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is StringResErrorData) {
            return other.stringRes == stringRes
        }
        return super.equals(other)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(stringRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StringResErrorData> {
        override fun createFromParcel(parcel: Parcel): StringResErrorData {
            return StringResErrorData(parcel)
        }

        override fun newArray(size: Int): Array<StringResErrorData?> {
            return arrayOfNulls(size)
        }
    }

}