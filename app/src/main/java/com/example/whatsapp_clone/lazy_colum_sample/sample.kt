package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun sample() {

    var sampleImage: Painter = painterResource(id = R.drawable.ic_baseline_brightness_1_24)
    Row() {
        Image(painter = sampleImage, contentDescription = "hello", modifier = Modifier
            .width(80.dp)
            .height(80.dp))
        Column(  modifier = Modifier
            .width(230.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)) {


            Text(
                text = "Sharikh",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Aa Ok",
                fontSize = 15.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(text = "10:11 AM", textAlign = TextAlign.Center, modifier = Modifier
            .width(80.dp)
            .height(34.dp)
            .padding(vertical = 5.dp) )
    }
}

@Preview(showBackground = true)
@Composable
fun Previewsample() {
    sample()
}