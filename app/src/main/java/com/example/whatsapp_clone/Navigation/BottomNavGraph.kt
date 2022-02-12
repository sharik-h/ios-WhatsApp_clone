package com.example.whatsapp_clone

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.Navigation.BottombarScreen
import com.example.whatsapp_clone.pages.camerapage
import com.example.whatsapp_clone.pages.Statuspage
import com.example.whatsapp_clone.pages.chatPage
import com.example.whatsapp_clone.pages.chatProfileDetail
import com.example.whatsapp_clone.sample_data.data


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
            ListView(navController = navHostController)
        }
        composable(route = BottombarScreen.Settings.route){
            settings()
        }
        composable(route = BottombarScreen.Chatpage.route){
            chatPage(navController = navHostController)
        }
        composable(route = BottombarScreen.chatsample.route){
            val image: Painter = painterResource(id = R.drawable.open_arrow)
            sample(navController = navHostController, data = data(name = "", lastmsg = "", time = "", profile = image, status = ""))
        }
        composable(route = BottombarScreen.chatProfileDetail.route){
            chatProfileDetail()
        }
    }
}