package com.example.whatsapp_clone

import android.annotation.SuppressLint
import android.text.method.KeyListener
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.isPopupLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.Navigation.BottombarScreen

 @SuppressLint("UnrememberedMutableState")
 @OptIn(ExperimentalAnimationApi::class)
 @Composable
 fun MainScreen() {
     val navController = rememberNavController()
     Scaffold(
         bottomBar = {
             BottomBar(
                 navController = navController
             )
         }
     )
     {
         BottomNavGraph(navHostController = navController)
     }
 }




    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun BottomBar(navController: NavHostController) {
        val screens = listOf(
            BottombarScreen.Status,
            BottombarScreen.Calls,
            BottombarScreen.Camera,
            BottombarScreen.ListView,
            BottombarScreen.Settings
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        var state = rememberSaveable {(mutableStateOf(true))}

        AnimatedVisibility(
                visible = state.value
        ) {
            BottomNavigation {
                screens.forEach { screen ->
                      AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
                    if (currentDestination?.route == "chatpage") {
                        LaunchedEffect(Unit ){
                            state.value = false
                        }
                    }
            }
        }
        Log.d("destination", currentDestination.toString())
        if (currentDestination?.route != "chatpage"){
            LaunchedEffect(Unit ){
                state.value = true
            }
        }
    }

    @Composable
    fun RowScope.AddItem(
        screen: BottombarScreen,
        currentDestination: NavDestination?,
        navController: NavHostController,
    ) {

        val statusimg: Painter = painterResource(id = R.drawable.icons8_inactive_state_30)
        val callimg: Painter = painterResource(id = R.drawable.icons8_phone_30)
        val cameraimg: Painter = painterResource(id = R.drawable.icons8_camera_30__1_)
        val chatimg: Painter = painterResource(id = R.drawable.icons8_chat_30__1_)
        val setttingimg: Painter = painterResource(id = R.drawable.icons8_settings_30)
        var icon = statusimg

        if (screen.icon == "statusimg") {
            icon = statusimg
        } else if (screen.icon == "callimg") {
            icon = callimg
        } else if (screen.icon == "cameraimg") {
            icon = cameraimg
        } else if (screen.icon == "chatimg") {
            icon = chatimg
        } else if (screen.icon == "settingimg") {
            icon = setttingimg
        }
        else{
        }
//
        BottomNavigationItem(
            modifier = Modifier.background(Color(0xFFEBEBEB)),
            label = {
                Text(
                    text = screen.title,
                    color = Color(0xFF666666)
                )
            },

            icon = {
                Icon(
                    painter = icon,
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color(0xFF6F6F6F)
                )
            },

            selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true,

            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
            selectedContentColor = LocalContentColor.current,
        )
    }


//FF3700B3
