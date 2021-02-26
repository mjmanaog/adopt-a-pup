package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ReusableHeaderAndBody(header: String, body: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(15.dp)) {
        DefaultH2TextOrange(text = header,TextAlign.Start)
        DefaultCaptionTextDark(text = "  ")
        DefaultBody2TextDark(text = body, TextAlign.Start)
    }
}