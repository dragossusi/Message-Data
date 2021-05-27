package ro.dragossusi.messagedata.android

import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize
import ro.dragossusi.messagedata.android.parser.ResourceMessageDataParser
import ro.dragossusi.messagedata.android.parser.requireResourceParser
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

    override fun getMessage(parser: MessageDataParser): CharSequence {
        return parser.requireResourceParser()
            .resources
            .getString(stringRes)
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