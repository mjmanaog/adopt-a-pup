package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                "AppBar Icon",
                Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = {iconClickAction.invoke()})
            )
        },
        title = { Text(text = title) }
    )
}
