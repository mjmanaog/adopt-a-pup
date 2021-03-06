package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ReusableHeaderAndBody(header: String, body: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, top = 15.dp, bottom = 8.dp, end = 20.dp)
    ) {
        DefaultH2TextOrange(text = header, TextAlign.Start)
        Spacer(modifier = Modifier.height(10.dp))
        DefaultBody2TextDark(text = body, TextAlign.Start)
    }
}