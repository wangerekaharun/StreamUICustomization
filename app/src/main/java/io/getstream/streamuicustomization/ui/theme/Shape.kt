package io.getstream.streamuicustomization.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import io.getstream.chat.android.compose.ui.theme.StreamShapes

val CustomStreamShapes = StreamShapes(
    avatar = RoundedCornerShape(40),
    myMessageBubble = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp),
    otherMessageBubble = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp),
    inputField = RoundedCornerShape(24.dp),
    attachment = RoundedCornerShape(16.dp),
    imageThumbnail = RoundedCornerShape(8.dp),
    bottomSheet = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
)