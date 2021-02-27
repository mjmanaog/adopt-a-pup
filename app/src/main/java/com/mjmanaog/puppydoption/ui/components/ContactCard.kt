package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ContactCard(icon: Int, text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp),
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(20)
    ) {
        ReusableIconAndText(icon = icon, text = text, padding = 15)
    }
}

@Composable
fun ReusableIconAndText(icon: Int, text: String, padding: Int) {
    Row(
        modifier = Modifier
            .padding(padding.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val paintIcon: Painter = painterResource(icon)
        Image(
            modifier = Modifier.padding(8.dp),
            painter = paintIcon,
            contentDescription = "Contact Icon"
        )
        DefaultBody2TextDark(text = text, TextAlign.Start)
    }
}