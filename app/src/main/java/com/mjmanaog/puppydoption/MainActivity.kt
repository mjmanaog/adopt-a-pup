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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mjmanaog.puppydoption.ui.components.PuppyInfoScreen
import com.mjmanaog.puppydoption.ui.network.model.PuppyInfo
import com.mjmanaog.puppydoption.ui.network.model.puppyList
import com.mjmanaog.puppydoption.ui.screens.*
import com.mjmanaog.puppydoption.ui.theme.PuppydoptionTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.holo_orange_dark)

        val database = Firebase.database
        val myRef = database.getReference("puppies")

        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue()
                Log.d(">>>", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(">>>", "Failed to read value.", error.toException())
            }
        })

        setContent {
            PuppydoptionTheme {
                PuppyApplication()
//                MainScreen()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyApplication(puppy: List<PuppyInfo.Puppy> = puppyList){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing_screen"){
        composable("landing_screen"){
            LandingScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppydoptionTheme {

    }
}