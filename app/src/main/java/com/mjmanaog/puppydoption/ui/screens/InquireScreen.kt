package com.mjmanaog.puppydoption.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.ui.components.AppBar
import com.mjmanaog.puppydoption.ui.components.ContactCard


@Composable
fun InquireScreen(){
    Scaffold(topBar = {
        AppBar(
            title = "Inquire",
            icon = Icons.Default.Email,
            iconClickAction = {})
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize().padding(top = 20.dp)) {
                ContactCard(icon = R.drawable.ic_web, text = "www.puppydoption.com")
                ContactCard(icon = R.drawable.ic_fb, text = "@puppydoption.official")
                ContactCard(icon = R.drawable.ic_twitter, text = "@puppydoption")
                ContactCard(icon = R.drawable.ic_msg, text = "+639562222222")
                ContactCard(icon = R.drawable.ic_mail, text = "hello@puppydoption.com")
                ContactCard(icon = R.drawable.ic_phone, text = "+02811111111")
                ContactCard(icon = R.drawable.ic_address, text = "Marilao, Bulacan, Philippines 3019")
            }
        }
    }
}