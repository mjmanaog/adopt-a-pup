package com.mjmanaog.puppydoption.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.mjmanaog.puppydoption.DoggoAnimation
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.ui.components.DefaultH2TextDark
import com.mjmanaog.puppydoption.ui.components.DefaultH2TextWhite


@Composable
fun LandingScreen(navController: NavController?, doggoAnimation: DoggoAnimation) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LandingCard (doggoAnimation = doggoAnimation){
            navController?.navigate("puppy_list")
        }
    }
}

@Composable
fun LandingCard( doggoAnimation: DoggoAnimation, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .padding(all = 15.dp),
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "Puppy",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.secondaryVariant
                )
                Text(
                    text = "doption",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.primaryVariant
                )
            }
//            val painterLogo: Painter = painterResource(id = R.drawable.ic_logo)
//            Image(
//                modifier = Modifier.padding(bottom = 20.dp),
//                painter = painterLogo,
//                contentDescription = "App Logo"
//            )
            val context = LocalContext.current
            val customView = remember { LottieAnimationView(context)}
            AndroidView(factory = { customView }){ view ->
                with(view){
                    repeatMode = LottieDrawable.RESTART
                    setAnimation(doggoAnimation.animId)
                    playAnimation()
                }
            }

            DefaultH2TextDark(text = "Find your best buddy in just a few clicks!", TextAlign.Center)
            Button(
                onClick = clickAction, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            ) {
                val painterSearch: Painter = painterResource(id = R.drawable.ic_search)
                Image(
                    modifier = Modifier.padding(end = 15.dp),
                    painter = painterSearch,
                    contentDescription = "Search Icon"
                )
                DefaultH2TextWhite(text = "Find my Buddy", TextAlign.Center)
            }
        }
    }
}