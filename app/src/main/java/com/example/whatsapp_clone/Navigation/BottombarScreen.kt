package com.example.whatsapp_clone.Navigation

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottombarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Status: BottombarScreen(
        route = "Status",
        title = "Status",
        icon = Icons.Default.Person
    )
    object Calls: BottombarScreen(
        route = "Calls",
        title = "Calls",
        icon = Icons.Default.Phone
    )
    object Camera: BottombarScreen(
        route = "Camera",
        title = "Camera",
        icon = Icons.Default.AddCircle
    )
    object ListView: BottombarScreen(
        route = "ListView",
        title = "Chats",
        icon = Icons.Default.Home
    )
    object Settings: BottombarScreen(
        route = "settings",
        title = "settings",
        icon = Icons.Default.Settings
    )

}
