package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mjmanaog.puppydoption.ui.network.model.PuppyInfo
import com.mjmanaog.puppydoption.ui.network.model.puppyList
import com.mjmanaog.puppydoption.ui.theme.PuppydoptionTheme

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