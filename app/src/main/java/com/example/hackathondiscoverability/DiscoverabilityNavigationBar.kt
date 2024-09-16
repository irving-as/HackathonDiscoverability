package com.example.hackathondiscoverability

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Badge
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hackathondiscoverability.data.NavigationItem

@Composable
fun RowScope.NavigationMenuItem(
    title: String,
    iconRes: Int,
    isPromoted: Boolean = false
) {
    Box(
        modifier = Modifier
            .weight(2f),
        contentAlignment = Alignment.Center
    ) {
        Box {
            val newBadge = "New"
            val badgeOffset = 0.dp
            Column(
                modifier = Modifier
                    .sizeIn(minWidth = 56.dp, minHeight = 56.dp)
                    .background(MaterialTheme.colors.primarySurface),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(id = iconRes), contentDescription = title)
                Text(text = title, fontSize = 12.sp)
            }

            if (isPromoted) {
                Badge(
                    backgroundColor = Color.Red,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = badgeOffset, y = -badgeOffset)
                ) {
                    Text(text = newBadge, color = Color.White, textAlign = TextAlign.Center)
                }
            }
        }
    }

}

@Composable
fun RowScope.CompactNavigationMenuItem(
    iconRes: Int,
) {
    Column(modifier = Modifier
        .sizeIn(minWidth = 24.dp, minHeight = 56.dp)
        .weight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null)
    }
}

@Composable
fun DiscoverabilityNavigationBar(apps: List<NavigationItem>, promotedApp: NavigationItem? = null) {
    BottomAppBar(
        modifier = Modifier,
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentPadding = PaddingValues(
            start = 0.dp,
            top = 0.dp,
            bottom = 32.dp,
            end = 0.dp,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primarySurface),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (app in apps) {
                NavigationMenuItem(title = app.title, iconRes = app.iconRes)
            }

            if (promotedApp == null) {
                NavigationMenuItem(title = "Apps", iconRes = R.drawable.ic_fluent_app_folder)
            } else {
                NavigationMenuItem(title = promotedApp.title, iconRes = promotedApp.iconRes, isPromoted = true)
                CompactNavigationMenuItem(iconRes = R.drawable.ic_more_vertical_24_filled)
            }
        }
    }
}

@Preview
@Composable
fun PreviewNavigationMenuItem() {
    Row {
        NavigationMenuItem(title = "Mail", iconRes = R.drawable.ic_fluent_mail_24)
    }
}

@Preview
@Composable
fun PreviewDiscoverabilityNavigationBar() {
    val apps = listOf(
        NavigationItem("Mail", R.drawable.ic_fluent_mail_24),
        NavigationItem("Mail v2", R.drawable.ic_fluent_mail_template_24_regular),
        NavigationItem("Calendar", R.drawable.ic_fluent_calendar_24),
    )
    DiscoverabilityNavigationBar(apps)
}

@Preview
@Composable
fun PreviewDiscoverabilityNavigationBarCompact() {
    val apps = listOf(
        NavigationItem("Mail", R.drawable.ic_fluent_mail_24),
        NavigationItem("Mail v2", R.drawable.ic_fluent_mail_template_24_regular),
        NavigationItem("Calendar", R.drawable.ic_fluent_calendar_24),
    )
    DiscoverabilityNavigationBar(apps, NavigationItem("Cal v2", R.drawable.ic_fluent_calendar_24))
}