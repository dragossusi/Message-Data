package ro.dragossusi.messagedata

operator fun MessageData.plus(
    messageData: MessageData
): MessageData = ConcatMessageData(this, messageData)