package com.example.whatsapp_clone.lazy_colum_sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R

@Composable
fun StatusSample() {
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp).size(80.dp))
    {
        Row() {
            val Image: Painter = painterResource(id = R.drawable.img_0922)
            Image(
                painter = Image,
                contentDescription = "sample image",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(50))
            )
            Column(modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp), verticalArrangement = Arrangement.Center) {
                Text(text = "Sharikh", fontSize = 23.sp, fontWeight = FontWeight.Bold)
                Text(text = "8h ago", fontSize = 18.sp)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatusSample() {
    StatusSample()
}