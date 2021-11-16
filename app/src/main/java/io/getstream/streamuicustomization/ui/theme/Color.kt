package io.getstream.streamuicustomization.ui.theme

import androidx.compose.ui.graphics.Color
import io.getstream.chat.android.compose.ui.theme.StreamColors

val ColorPrimary = Color(0xFFf9edf4)
val ColorPrimaryDark = Color(0xFFc6bdc2)
val ColorPrimaryLight = Color(0xFFffffff)
val ColorOverLay = Color(0XFF322020)


val CustomLightStreamColors = StreamColors(
    textHighEmphasis = Color.Black,
    textLowEmphasis =  Color.Black,
    disabled = ColorPrimaryDark,
    borders = ColorPrimary,
    inputBackground = ColorPrimaryLight,
    appBackground = ColorPrimaryLight,
    barsBackground = ColorPrimary,
    linkBackground =ColorPrimaryLight,
    overlay = ColorOverLay,
    overlayDark = ColorPrimaryDark,
    primaryAccent = ColorPrimaryDark,
    errorAccent = ColorPrimary,
    infoAccent = Color.Red,
    highlight = ColorPrimaryDark,
    ownMessagesBackground = ColorPrimaryDark,
    otherMessagesBackground = ColorPrimaryDark,
    deletedMessagesBackgroundColor = ColorPrimaryDark
)