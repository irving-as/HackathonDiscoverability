package com.example.hackathondiscoverability

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackathondiscoverability.home.HomeScreen

@Composable
fun DiscoverabilityAppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navActions: DiscoverabilityNavigationActions =
        remember(navController) {
            DiscoverabilityNavigationActions(navController)
        },
) {
    NavHost(
        navController = navController,
        startDestination = DiscoverabilityScreens.DISCOVERABILITY_HOME,
        modifier = modifier,
    ) {
        composable(
            route=DiscoverabilityScreens.DISCOVERABILITY_HOME,
        ) {
            HomeScreen()
        }
    }
}