package com.example.whatsapp_clone.splashscreen

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.whatsapp_clone.R
import com.example.whatsapp_clone.loginPageNavigation.loginPageScreen
import com.example.whatsapp_clone.secondActivity
import kotlinx.coroutines.delay

@Composable
fun Splash(navHostController: NavHostController, signed: Boolean) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaanim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(6000)
        navHostController.popBackStack()
        if (signed) {
            context.startActivity(Intent(context, secondActivity::class.java))
        }else {
            navHostController.navigate(loginPageScreen.TandC.route)
        }

    }
    SplashView(alpha = alphaanim.value)
}

@Composable
fun SplashView(alpha: Float) {
    Column( modifier = Modifier
        .fillMaxSize()
        .alpha(alpha = alpha)
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val whatsappIcon: Painter = painterResource(id = R.drawable.whatsapp_logo)
        Image(painter = whatsappIcon, contentDescription = "", modifier = Modifier.size(100.dp))
    }
}

