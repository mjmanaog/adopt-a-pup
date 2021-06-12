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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.helpers.*
import com.mjmanaog.puppydoption.ui.components.PuppyInfoScreen

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: Int) {
    object PuppyList : BottomNavigationScreens(ROUTE_PUPPY_LIST, R.string.nav_find_puppy, R.drawable.ic_find)
    object Inquiry : BottomNavigationScreens(ROUTE_INQUIRY, R.string.nav_inquiry, R.drawable.ic_inquire)
    object FAQ : BottomNavigationScreens(ROUTE_FAQ, R.string.nav_faq, R.drawable.ic_faq)
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
            PuppyBottomNavigation(navController, bottomNavigationItems)
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
            PuppyListScreen( navController = navController)
        }
        composable(route = "${ROUTE_PUPPY_INFO}/{puppyId}", arguments = listOf(navArgument(ARG_PUPPY_ID){
            type = NavType.IntType
        })){
            PuppyInfoScreen(it.arguments!!.getInt(ARG_PUPPY_ID), navController = navController)
        }
        composable(BottomNavigationScreens.Inquiry.route) {
            InquireScreen()
        }
        composable(BottomNavigationScreens.FAQ.route) {
            FAQScreen()
        }
    }
}

@Composable
private fun PuppyBottomNavigation(
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
    return navBackStackEntry?.arguments?.getString("KEY_ROUTE")
}