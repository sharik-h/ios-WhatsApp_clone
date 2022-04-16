package com.example.whatsapp_clone.loginPageNavigation

sealed class loginPageScreen(val route: String) {
    object TandC: loginPageScreen(route = "TandC")
}