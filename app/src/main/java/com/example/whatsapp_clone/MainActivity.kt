package com.example.whatsapp_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.loginPageNavigation.loginPageNavGraph
import com.example.whatsapp_clone.ui.theme.WhatsAppcloneTheme


class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppcloneTheme {
                navHostController = rememberNavController()
                loginPageNavGraph(navHostController = navHostController)
            }
        }
    }
}

