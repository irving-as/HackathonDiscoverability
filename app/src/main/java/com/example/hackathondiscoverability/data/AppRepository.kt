package com.example.hackathondiscoverability.data

import kotlinx.coroutines.flow.StateFlow

interface AppRepository {
    val apps: StateFlow<List<NavigationItem>>
    val promotedApp: StateFlow<NavigationItem?>

    suspend fun refresh()
    fun togglePromotedApp()
}