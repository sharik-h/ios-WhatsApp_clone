package com.example.whatsapp_clone.Navigation

sealed class BottombarScreen(
    val route: String,
    val title: String,
    val icon: String,
){
    object MainScreen: BottombarScreen(
        route = "MainScreen",
        title = "MainScreen",
        icon = "Mainimg"
    )
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
    object Chatpage: BottombarScreen(
        route = "chatpage/{cid}",
        title = "chatpage",
        icon = "chatviewimg"
    )
    object chatsample: BottombarScreen(
        route = "chatsample",
        title = "chatsample",
        icon = "chatsampleimg"
    )
//    object chatProfileDetail: BottombarScreen(
//        route = "chatProfileDetail",
//        title = "chatProfileDetail",
//        icon = "chatProfileDetail"
//    )
}
