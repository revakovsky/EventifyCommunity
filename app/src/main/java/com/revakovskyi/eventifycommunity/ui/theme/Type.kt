package com.revakovskyi.eventifycommunity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.revakovskyi.eventifycommunity.R

val Nunito = FontFamily(
    Font(R.font.nunito_light, weight = FontWeight.W300),
    Font(R.font.nunito_lightitalic, weight = FontWeight.W300),

    Font(R.font.nunito_regular, weight = FontWeight.Normal),

    Font(R.font.nunito_medium, weight = FontWeight.W500),
    Font(R.font.nunito_mediumitalic, weight = FontWeight.W500),

    Font(R.font.nunito_bold, weight = FontWeight.W700),
    Font(R.font.nunito_bolditalic, weight = FontWeight.W700),

    Font(R.font.nunito_extrabold, weight = FontWeight.W800),
    Font(R.font.nunito_extrabolditalic, weight = FontWeight.W800),
)

val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.W500,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)