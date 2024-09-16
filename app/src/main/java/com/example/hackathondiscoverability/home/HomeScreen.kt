package com.example.hackathondiscoverability.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hackathondiscoverability.DiscoverabilityAppBar
import com.example.hackathondiscoverability.DiscoverabilityNavigationBar

@Composable
fun HomeScreen(
    viewModel: DiscoverabilityViewModel = hiltViewModel(),
) {
    val apps = viewModel.apps.collectAsStateWithLifecycle()
    val promotedApp = viewModel.promotedApp.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            DiscoverabilityAppBar(
                canNavigateBack = false,
                navigateUp = { /*TODO*/ },
            )
        },
        bottomBar = {
            DiscoverabilityNavigationBar(apps.value, promotedApp.value)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Button(onClick = {
                viewModel.togglePromotedApp()
            }) {
                Text("Toggle promoted app")
            }
        }
    }
}