package com.example.whatsapp_clone

import androidx.compose.material.BottomSheetScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapp_clone.Navigation.BottombarScreen
import com.example.whatsapp_clone.pages.camerapage
import com.example.whatsapp_clone.pages.Statuspage

@Composable
fun BottomNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = BottombarScreen.ListView.route )
    {
        composable(route = BottombarScreen.Status.route){
            Statuspage()
        }
        composable(route = BottombarScreen.Calls.route){
            Calls()
        }
        composable(route = BottombarScreen.Camera.route){
            camerapage()
        }
        composable(route = BottombarScreen.ListView.route){
            ListView()
        }
        composable(route = BottombarScreen.Settings.route){
            settings()
        }
    }
}