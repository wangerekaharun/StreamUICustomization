package io.getstream.streamuicustomization.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.getstream.chat.android.compose.ui.theme.StreamColors

object CustomColors {
    val Primary = Color(0xFF69ABFD)
    val PrimaryDark = Color(0xFF478CE9)
    val PrimaryLight = Color(0xFFD0E8FD)
    val OverLay = Color(0xA0A2C8FF)
    val Accent = Color(0xFFA20DFF)
    val TextHigh = Color(0xFF1A1A1A)
    val TextLow = Color(0xFF2E2E2E)
}

val CustomLightStreamColors
    @Composable
    get() = StreamColors.defaultColors().copy(
        textHighEmphasis = CustomColors.TextHigh,
        textLowEmphasis = CustomColors.TextLow,
        disabled = CustomColors.PrimaryDark,
        borders = CustomColors.Primary,
        inputBackground = CustomColors.PrimaryLight,
        appBackground = CustomColors.PrimaryLight,
        barsBackground = CustomColors.Primary,
        linkBackground = CustomColors.PrimaryLight,
        overlay = CustomColors.OverLay,
        overlayDark = CustomColors.PrimaryDark,
        primaryAccent = CustomColors.Accent,
        highlight = CustomColors.PrimaryDark,
        ownMessagesBackground = CustomColors.PrimaryDark,
        otherMessagesBackground = CustomColors.PrimaryDark,
        deletedMessagesBackgroundColor = CustomColors.PrimaryDark
    )