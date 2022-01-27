package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.log

@Composable
fun log_sample(){
    var sampleImage: Painter = painterResource(id = R.drawable.ic_baseline_brightness_1_24)
    Row() {
        Image(painter = sampleImage, contentDescription = "hello", modifier = Modifier
            .width(80.dp)
            .height(80.dp))
        Column(  modifier = Modifier
            .width(230.dp)
            .padding(vertical = 12.dp)) {


            Text(
                text = "Sharikh",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Row() {
                Image(imageVector = Icons.Default.Phone, contentDescription = "phone icon")
                Text(
                    text = "Incoming",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(text = "10:11 AM", textAlign = TextAlign.Center, modifier = Modifier
            .padding(vertical = 25.dp)
            .width(80.dp)
            .height(34.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Previewlogsample(){
    log_sample()
}