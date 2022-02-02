package com.example.whatsapp_clone.Navigation

import androidx.compose.ui.graphics.painter.Painter
import com.example.whatsapp_clone.R

sealed class BottombarScreen(
    val route: String,
    val title: String,
    val icon: String
){
    object Status: BottombarScreen(
        route = "Status",
        title = "Status",
        icon = "statusimg"
    )
    object Calls: BottombarScreen(
        route = "Calls",
        title = "Calls",
        icon = "callimg"
    )
    object Camera: BottombarScreen(
        route = "Camera",
        title = "Camera",
        icon = "cameraimg"
    )
    object ListView: BottombarScreen(
        route = "ListView",
        title = "Chats",
        icon = "chatimg"
    )
    object Settings: BottombarScreen(
        route = "settings",
        title = "settings",
        icon = "settingimg"
    )
}
