package com.example.whatsapp_clone

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.whatsapp_clone.Navigation.BottombarScreen
import com.example.whatsapp_clone.pages.Statuspage
import com.example.whatsapp_clone.pages.camerapage
import com.example.whatsapp_clone.pages.chatPage
import com.example.whatsapp_clone.sample_data.data


@Composable
fun BottomNavGraph(navHostController: NavHostController, user: Array<String?>){

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
        composable(
            route = BottombarScreen.Settings.route,
        ){
                settings(user = user)

        }
        composable(
            route = BottombarScreen.Chatpage.route,
            arguments =  listOf(navArgument("cid"){
                type = NavType.StringType })
        ){
            val cid = it.arguments?.getString("cid").toString()
            chatPage(navController = navHostController,cid)
        }
        composable(route = BottombarScreen.chatsample.route){
            val image: Painter = painterResource(id = R.drawable.open_arrow)
            sample(navController = navHostController, data = data(name = "", lastmsg = "", time = "", profile = image, status = ""))
        }
//        composable(route = BottombarScreen.chatProfileDetail.route){
//            chatProfileDetail()
//        }
    }
}