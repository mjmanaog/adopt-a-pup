package com.mjmanaog.puppydoption.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.mjmanaog.puppydoption.ui.components.AppBar
import com.mjmanaog.puppydoption.ui.components.ReusableHeaderAndBody

@Composable
fun FAQScreen(navController: NavController?) {
    Scaffold(topBar = {
        AppBar(
            title = "Frequently Asked Questions",
            icon = Icons.Default.Info,
            iconClickAction = {})
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize()) {
                ReusableHeaderAndBody(
                    header = "1. How to adopt a puppy?",
                    body = "Auctor augue mauris augue neque gravida in fermentum et sollicitudin. Adipiscing diam donec adipiscing tristique. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur"
                )
                ReusableHeaderAndBody(
                    header = "2. What are the requirements?",
                    body = "Auctor augue mauris augue neque gravida in fermentum et sollicitudin. Adipiscing diam donec adipiscing tristique. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur"
                )
                ReusableHeaderAndBody(
                    header = "3. Is there any payment?",
                    body = "Auctor augue mauris augue neque gravida in fermentum et sollicitudin. Adipiscing diam donec adipiscing tristique. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur"
                )
                ReusableHeaderAndBody(
                    header = "4. How long will be the process?",
                    body = "Auctor augue mauris augue neque gravida in fermentum et sollicitudin. Adipiscing diam donec adipiscing tristique. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur"
                )
            }
        }
    }

}