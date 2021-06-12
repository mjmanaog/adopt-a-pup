package com.mjmanaog.puppydoption

import android.R
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mjmanaog.puppydoption.helpers.ROUTE_LANDING
import com.mjmanaog.puppydoption.helpers.ROUTE_MAIN
import com.mjmanaog.puppydoption.network.model.PuppyModel
import com.mjmanaog.puppydoption.network.model.puppyList
import com.mjmanaog.puppydoption.ui.screens.LandingScreen
import com.mjmanaog.puppydoption.ui.screens.MainScreen
import com.mjmanaog.puppydoption.ui.theme.PuppydoptionTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.holo_orange_dark)

        setContent {
            PuppydoptionTheme {
                PuppyApplication()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyApplication(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_LANDING){
        composable(ROUTE_LANDING){
            LandingScreen(navController = navController)
        }
        composable(ROUTE_MAIN) {
            MainScreen()
        }
    }
}
