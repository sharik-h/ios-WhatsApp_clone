package com.example.whatsapp_clone.loginPages

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R

@Composable
fun TermsAndCondition() {
    Box{

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val whatsappImg: Painter = painterResource(id = R.drawable.whatsapp_logo)
            Image(
                painter = whatsappImg,
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }


        Column(
            Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {


            Text(
                text = "Welcome to WhatsApp",
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )
            Text(
                text = "Read our Privacy Policy Tap 'Agree & continue to accept the Terms of Services.",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 5.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            //1786ff
            val context = LocalContext.current
            TextButton(onClick = {
                context.startActivity(
                    Intent(
                        context,
                        verifyPhone::class.java
                    )
                )
            }) {
                Text(
                    text = "Agree & Continue",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1786ff)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "From")
            Text(
                text = "F A C E B O O K",
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prev() {
    TermsAndCondition()
}