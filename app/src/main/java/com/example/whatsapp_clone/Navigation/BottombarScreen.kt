package com.example.whatsapp_clone.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottombarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object ListView: BottombarScreen(
        route = "ListView",
        title = "ListView",
        icon = Icons.Default.Home
    )
    object Settings: BottombarScreen(
        route = "settings",
        title = "settings",
        icon = Icons.Default.Settings
    )
    object Calls: BottombarScreen(
        route = "Calls",
        title = "Calls",
        icon = Icons.Default.Phone
    )
}
