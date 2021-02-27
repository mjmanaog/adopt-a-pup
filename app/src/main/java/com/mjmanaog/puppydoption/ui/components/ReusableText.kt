package com.mjmanaog.puppydoption.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun DefaultH1TextOrange(text: String){
    Text(text = text, style = MaterialTheme.typography.h1, color = MaterialTheme.colors.primaryVariant)
}

@Composable
fun DefaultH2TextWhite(text: String, alignment: TextAlign){
    Text(text = text, textAlign = alignment, style = MaterialTheme.typography.h2, color = Color.White)
}


@Composable
fun DefaultH2TextOrange(text: String, alignment: TextAlign){
    Text(text = text, textAlign = alignment, style = MaterialTheme.typography.h2, color = MaterialTheme.colors.primaryVariant)
}

@Composable
fun DefaultH2TextDark(text: String, alignment: TextAlign){
    Text(text = text, textAlign = alignment, style = MaterialTheme.typography.h2, color = MaterialTheme.colors.secondaryVariant)
}

@Composable
fun DefaultBody1TextDark(text: String, alignment: TextAlign){
    Text(text = text, textAlign = alignment, style = MaterialTheme.typography.body2, color = MaterialTheme.colors.secondaryVariant)
}


@Composable
fun DefaultBody2TextDark(text: String, alignment: TextAlign){
    Text(text = text, textAlign = alignment, style = MaterialTheme.typography.body2, color = MaterialTheme.colors.secondaryVariant)
}