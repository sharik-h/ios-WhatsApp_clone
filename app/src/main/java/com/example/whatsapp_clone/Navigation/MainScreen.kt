package com.example.whatsapp_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        BottombarScreen.Calls,
        BottombarScreen.ListView,
        BottombarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


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
        BottomNavigationItem(
            modifier = Modifier.background(Color(0xFFEBEBEB)),
        label = {
            Text(text = screen.title, color =  Color(0xFF666666))
                },
            icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation icon",
                tint = Color(0xFF666666)
            )
            },
            selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true ,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}


//FF3700B3
