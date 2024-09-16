package com.example.hackathondiscoverability.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathondiscoverability.data.AppRepository
import com.example.hackathondiscoverability.data.NavigationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverabilityViewModel
@Inject
constructor(
    private val appRepository: AppRepository
) : ViewModel() {
    val apps: StateFlow<List<NavigationItem>> = appRepository.apps
    val promotedApp: StateFlow<NavigationItem?> = appRepository.promotedApp

    fun reloadApps() {
        viewModelScope.launch {
            appRepository.refresh()
        }
    }

    fun togglePromotedApp() {
        appRepository.togglePromotedApp()
    }
}