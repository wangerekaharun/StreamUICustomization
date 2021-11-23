package io.getstream.streamuicustomization.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import io.getstream.chat.android.compose.ui.theme.StreamShapes

val CustomStreamShapes = StreamShapes(
    avatar = RoundedCornerShape(40),
    myMessageBubble = RoundedCornerShape(topStart = 20.dp, topEnd = 18.dp, bottomStart = 18.dp),
    otherMessageBubble = RoundedCornerShape(topStart = 18.dp, topEnd = 20.dp, bottomEnd = 18.dp),
    inputField = RoundedCornerShape(24.dp),
    attachment = RoundedCornerShape(16.dp),
    imageThumbnail = RoundedCornerShape(10.dp),
    bottomSheet = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
)