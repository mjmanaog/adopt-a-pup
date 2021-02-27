package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mjmanaog.puppydoption.network.model.puppyList

@Composable
fun PuppyInfoScreen(puppyId: Int, navController: NavHostController?) {
    val puppyInfo = puppyList.first{puppy -> puppyId == puppy.id }
    Scaffold(topBar = { AppBar(
        title = "Puppy Information",
        icon = Icons.Default.ArrowBack,
        iconClickAction = { navController?.navigateUp() })}) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column{
                PuppyInfoCard(puppyInfo)
                ReusableHeaderAndBody(header = "Personality", body = puppyInfo.personalities)
                ReusableHeaderAndBody(header = "Story", body = puppyInfo.stories)
            }
        }
    }
}