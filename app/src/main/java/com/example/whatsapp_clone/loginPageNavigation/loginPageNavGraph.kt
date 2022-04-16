package com.example.whatsapp_clone.loginPageNavigation

//import com.example.whatsapp_clone.loginPages.VerifyOtp
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapp_clone.loginPages.TermsAndCondition




@Composable
fun loginPageNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = loginPageScreen.TandC.route
    ){
        composable(route = loginPageScreen.TandC.route){
            TermsAndCondition()
        }
    }
}