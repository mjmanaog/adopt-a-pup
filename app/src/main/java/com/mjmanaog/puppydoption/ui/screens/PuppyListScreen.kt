package com.mjmanaog.puppydoption.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.mjmanaog.puppydoption.ui.components.AppBar
import com.mjmanaog.puppydoption.ui.components.ItemPuppyCard
import com.mjmanaog.puppydoption.ui.network.model.PuppyInfo

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen(puppies: List<PuppyInfo.Puppy>, navController: NavController?) {
    Scaffold(topBar = { AppBar("Find your Puppy", Icons.Default.Home) {} }) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(5.dp)
            ) {
                items(puppies) { puppy ->
                    ItemPuppyCard(puppy) {
                        navController?.navigate("puppy_info/${puppy.id}")
                    }
                }
            }
        }
    }
}