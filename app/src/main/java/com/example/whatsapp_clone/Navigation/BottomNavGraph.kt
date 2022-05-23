package com.example.whatsapp_clone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapp_clone.Navigation.BottombarScreen
import com.example.whatsapp_clone.pages.Statuspage
import com.example.whatsapp_clone.pages.TakePicture


@Composable
fun BottomNavGraph(
    navHostController: NavHostController,
    user: Array<String?>,
    Rnames: Array<String?>,
    Rimages: Array<String?>
){

    NavHost(
        navController = navHostController,
        startDestination = BottombarScreen.ListView.route )
    {
        composable(route = BottombarScreen.Status.route){
            Statuspage(user = user)
        }
        composable(route = BottombarScreen.Calls.route){
            Calls(Rnames = Rnames, Rimages = Rimages)
        }
        composable(route = BottombarScreen.Camera.route){
            TakePicture()
        }
        composable(route = BottombarScreen.ListView.route){
            ListView()
        }
        composable(
            route = BottombarScreen.Settings.route,
        ){
                settings(user = user)
        }
    }
}