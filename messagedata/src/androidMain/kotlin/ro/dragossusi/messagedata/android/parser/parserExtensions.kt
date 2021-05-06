package ro.dragossusi.messagedata.android.parser

import android.content.Context
import android.content.res.Resources
import androidx.fragment.app.Fragment
import ro.dragossusi.messagedata.parser.MessageDataParser

fun Resources.toMessageDataParser(): MessageDataParser = SimpleMessageDataParser(this)
fun Context.toMessageDataParser(): MessageDataParser = SimpleMessageDataParser(this.resources)
fun Fragment.toMessageDataParser(): MessageDataParser = FragmentMessageDataParser(this)