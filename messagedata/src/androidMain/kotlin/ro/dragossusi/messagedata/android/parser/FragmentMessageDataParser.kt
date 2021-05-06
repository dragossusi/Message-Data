package ro.dragossusi.messagedata.android.parser

import android.content.res.Resources
import androidx.fragment.app.Fragment
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.parser.MessageDataParser

/**
 * MessageData
 *
 * @author dragos
 * @since 13/01/2021
 *
 * Copyright (C) 2020  Rachieru Dragos-Mihai
 *
 * MessageData is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * MessageData is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MessageData.  If not, see [License](http://www.gnu.org/licenses/) .
 *
 */
class FragmentMessageDataParser(
    val fragment: Fragment
) : ResourceMessageDataParser {

    override val resources: Resources
        get() = fragment.resources

}