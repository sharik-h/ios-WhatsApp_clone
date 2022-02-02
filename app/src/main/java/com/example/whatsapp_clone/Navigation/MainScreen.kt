package com.example.whatsapp_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.Navigation.BottombarScreen

@Composable
fun MainScreen() {
    val navController  = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    )
    {
        BottomNavGraph(navHostController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottombarScreen.Status,
        BottombarScreen.Calls,
        BottombarScreen.Camera,
        BottombarScreen.ListView,
        BottombarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

//    Divider(thickness = 1.dp, color = Color.LightGray)
    BottomNavigation {
        screens.forEach{ screen->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
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

    if (screen.icon == "statusimg"){ icon = statusimg}
    else  if (screen.icon == "callimg"){  icon = callimg}
    else if (screen.icon == "cameraimg"){  icon = cameraimg}
    else if (screen.icon == "chatimg"){  icon = chatimg}
    else if (screen.icon == "settingimg"){  icon = setttingimg}
//
    BottomNavigationItem(
        modifier = Modifier.background(Color(0xFFEBEBEB)),
        label = {
            Text(
                text = screen.title,
                color =  Color(0xFF666666)
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
                it.route == screen.route } == true ,

        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        selectedContentColor = LocalContentColor.current
    )
}


//FF3700B3
