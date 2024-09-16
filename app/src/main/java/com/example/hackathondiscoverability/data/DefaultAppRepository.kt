package com.example.hackathondiscoverability.data

import com.example.hackathondiscoverability.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAppRepository @Inject constructor() : AppRepository {
    private val _apps = MutableStateFlow<List<NavigationItem>>(emptyList())
    override val apps: StateFlow<List<NavigationItem>>
        get() = _apps

    private val _promotedApp = MutableStateFlow<NavigationItem?>(null)
    override val promotedApp: StateFlow<NavigationItem?>
        get() = _promotedApp

    override suspend fun refresh() {
        _apps.value = listOf(
            NavigationItem("Mail", R.drawable.ic_fluent_mail_24),
            NavigationItem("Mail v2", R.drawable.ic_fluent_mail_template_24_regular),
            NavigationItem("Calendar", R.drawable.ic_fluent_calendar_24),
            NavigationItem("Cal v2", R.drawable.ic_fluent_calendar_24),
        )

        _promotedApp.value = null
    }

    override fun togglePromotedApp() {
        _promotedApp.value = if (_promotedApp.value == null) {
            NavigationItem("Cal v3", R.drawable.ic_fluent_calendar_24)
        } else {
            null
        }
    }
}