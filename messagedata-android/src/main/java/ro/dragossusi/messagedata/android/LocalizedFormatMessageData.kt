package ro.dragossusi.messagedata.android

import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize
import ro.dragossusi.messagedata.android.parser.ResourceMessageDataParser
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
class LocalizedFormatMessageData(
    @StringRes val stringRes: Int,
    vararg val args: String
) : AndroidMessageData {

    override fun getMessage(parser: MessageDataParser): String {
        if (parser !is ResourceMessageDataParser)
            throw IllegalArgumentException("parser must be ResourceMessageDataParser")
        return parser.resources.getString(stringRes, *args)
    }
}