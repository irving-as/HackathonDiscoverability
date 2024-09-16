package com.example.hackathondiscoverability

import androidx.compose.foundation.layout.padding
// import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DiscoverabilityAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier
            .padding(top = 32.dp),
        navigationIcon = {
            if (canNavigateBack) {
                // IconButton(onClick = navigateUp) {
                //     Icon(
                //         imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                //         contentDescription = stringResource(id = R.string.back_button)
                //     )
                // }
            }
        },
    )
}