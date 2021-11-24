package io.getstream.streamuicustomization.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.getstream.chat.android.compose.ui.theme.StreamTypography
import io.getstream.streamuicustomization.R

val SourceCodePro = FontFamily(
    Font(R.font.sourcecodepro_regular),
    Font(R.font.sourcecodepro_bold, FontWeight.Bold)
)

val StreamCustomTypography = StreamTypography(
    title1 = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),

    title3 = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    title3Bold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    body = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    bodyItalic = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 14.sp
    ),

    bodyBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    footnote = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    footnoteItalic = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 12.sp
    ),

    footnoteBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),

    captionBold = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),

    tabBar = TextStyle(
        fontFamily = SourceCodePro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)