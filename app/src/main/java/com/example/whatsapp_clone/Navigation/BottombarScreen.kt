package com.example.whatsapp_clone.Navigation

import androidx.compose.ui.graphics.painter.Painter
import com.example.whatsapp_clone.R

sealed class BottombarScreen(
    val route: String,
    val title: String,
    val icon: String,
    val status: Boolean
){
    object Status: BottombarScreen(
        route = "Status",
        title = "Status",
        icon = "statusimg",
        status = true
    )
    object Calls: BottombarScreen(
        route = "Calls",
        title = "Calls",
        icon = "callimg",
        status = true
    )
    object Camera: BottombarScreen(
        route = "Camera",
        title = "Camera",
        icon = "cameraimg",
        status = true
    )
    object ListView: BottombarScreen(
        route = "ListView",
        title = "Chats",
        icon = "chatimg",
        status = true
    )
    object Settings: BottombarScreen(
        route = "settings",
        title = "settings",
        icon = "settingimg",
        status = true
    )
    object Chatpage: BottombarScreen(
        route = "chatpage",
        title = "chatpage",
        icon = "chatviewimg",
        status = false
    )
    object chatsample: BottombarScreen(
        route = "chatsample",
        title = "chatsample",
        icon = "chatsampleimg",
        status = true
    )
}
