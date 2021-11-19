package ro.dragossusi.messagedata.android

import android.content.res.Resources
import androidx.annotation.PluralsRes
import kotlinx.parcelize.Parcelize
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.parser.ResourceMessageDataParser
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 *
 * @author Dragos
 * @since 25.03.2020
 */
@Parcelize
open class LocalizedPluralMessageData(
    @PluralsRes
    val pluralRes: Int,
    val quantity: Int,
    vararg val args: MessageData
) : AndroidMessageData {

    override fun getMessage(parser: MessageDataParser): String {
        if (parser !is ResourceMessageDataParser)
            throw IllegalArgumentException("parser must be ResourceMessageDataParser")
        return parser.resources.getQuantityString(pluralRes, quantity, *args)
    }

}