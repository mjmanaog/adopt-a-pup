package com.mjmanaog.puppydoption.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mjmanaog.puppydoption.R

val QuickSand = FontFamily(
        Font(R.font.quicksand_regular),
        Font(R.font.quicksand_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
        h1 = TextStyle(
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
        ),
        h2 = TextStyle(
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
        ),
        body1 = TextStyle(
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
        ),
        body2 = TextStyle(
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
        ),
        caption = TextStyle(
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp
        ),
)