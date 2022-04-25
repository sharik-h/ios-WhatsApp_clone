package com.example.whatsapp_clone.loginPageNavigation

//import com.example.whatsapp_clone.loginPages.VerifyOtp
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapp_clone.loginPages.TermsAndCondition
import com.example.whatsapp_clone.splashscreen.Splash


@Composable
fun loginPageNavGraph(navHostController: NavHostController, signed: Boolean) {
    NavHost(
        navController = navHostController,
        startDestination = loginPageScreen.splash.route
    ){
        composable(route = loginPageScreen.TandC.route){
            TermsAndCondition()
        }
        composable(route = loginPageScreen.splash.route){
            Splash(navHostController = navHostController, signed = signed)
        }
    }
}