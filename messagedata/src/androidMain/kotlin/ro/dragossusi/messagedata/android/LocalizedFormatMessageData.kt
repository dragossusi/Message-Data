package ro.dragossusi.messagedata.android

import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.parser.requireResourceParser
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
open class LocalizedFormatMessageData(
    @StringRes val stringRes: Int,
    vararg val args: MessageData
) : AndroidMessageData {

    override fun getMessage(parser: MessageDataParser): String {
        val arguments = args.map {
            it.getMessage(parser)
        }
        return parser.requireResourceParser()
            .resources
            .getString(stringRes, *arguments.toTypedArray())
    }

}