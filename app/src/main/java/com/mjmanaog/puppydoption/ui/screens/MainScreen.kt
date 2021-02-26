package com.mjmanaog.puppydoption.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.ui.network.model.puppyList

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: Int) {

    object PuppyList : BottomNavigationScreens("puppy_list", R.string.puppy_list_route, R.drawable.ic_find)
    object Inquiry : BottomNavigationScreens("inquiry", R.string.inquiry_route, R.drawable.ic_inquire)
    object FAQ : BottomNavigationScreens("faq", R.string.faq_route, R.drawable.ic_faq)
}
@ExperimentalFoundationApi
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.PuppyList,
        BottomNavigationScreens.Inquiry,
        BottomNavigationScreens.FAQ,
    )
    Scaffold(
        bottomBar = {
            SpookyAppBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@ExperimentalFoundationApi
@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.PuppyList.route) {
        composable(BottomNavigationScreens.PuppyList.route) {
            PuppyListScreen(puppies = puppyList, navController = navController)
        }
        composable(BottomNavigationScreens.Inquiry.route) {
            InquireScreen()
        }
        composable(BottomNavigationScreens.FAQ.route) {
            FAQScreen(navController = navController)
        }
    }
}

@Composable
private fun SpookyAppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Image(painter = painterResource(id = screen.icon), contentDescription = "Icon") },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}