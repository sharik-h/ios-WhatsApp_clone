package com.example.whatsapp_clone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapp_clone.Navigation.BottombarScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = BottombarScreen.ListView.route )
    {
        composable(route = BottombarScreen.Calls.route){
            Calls()
        }
        composable(route = BottombarScreen.ListView.route){
            ListView()
        }
        composable(route = BottombarScreen.Settings.route){
            settings()
        }
    }
}