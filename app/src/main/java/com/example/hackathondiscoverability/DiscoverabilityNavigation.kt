package com.example.hackathondiscoverability

import androidx.navigation.NavHostController
import com.example.hackathondiscoverability.DiscoverabilityScreens.DISCOVERABILITY_HOME

object DiscoverabilityScreens {
    const val DISCOVERABILITY_HOME = "home"
}

class DiscoverabilityNavigationActions(
    private val navController: NavHostController,
) {
    fun navigateToHome() {
        navController.navigate(DISCOVERABILITY_HOME)
    }
}