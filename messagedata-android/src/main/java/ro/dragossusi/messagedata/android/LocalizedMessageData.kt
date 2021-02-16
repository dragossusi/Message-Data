package ro.dragossusi.messagedata.android

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.parser.ResourceMessageDataParser
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
open class LocalizedMessageData(
    @StringRes val stringRes: Int
) : AndroidMessageData {

    override fun getMessage(parser: MessageDataParser): String {
        if (parser !is ResourceMessageDataParser)
            throw IllegalArgumentException("parser must be ResourceMessageDataParser")
        return parser.resources.getString(stringRes)
    }

    override fun hashCode(): Int {
        return stringRes.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is LocalizedMessageData) {
            return other.stringRes == stringRes
        }
        return super.equals(other)
    }

}