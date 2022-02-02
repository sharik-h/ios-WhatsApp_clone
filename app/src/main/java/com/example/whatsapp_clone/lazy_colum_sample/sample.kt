package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.data

@Composable
fun sample(data: data) {
Column()  {


    Row(modifier = Modifier.padding(start = 15.dp))
    {
        Image(
            painter = data.profile,
            contentDescription = "hello",
            modifier = Modifier
                .padding(top = 5.dp)
                .width(65.dp)
                .height(65.dp)
                .clip(RoundedCornerShape(50.dp))
        )

        Column(  modifier = Modifier
            .width(210.dp)
            .padding(start = 15.dp)) {


            Text(
                text = "${data.name}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${data.lastmsg}",
                fontSize = 18.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = "${data.time}",
            fontSize = 18.sp,
            textAlign = TextAlign.End,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(top = 5.dp, end = 20.dp)
                .width(80.dp)
                .height(34.dp))
    }
    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 10.dp,start = 95.dp))
}
}

@Preview(showBackground = true)
@Composable
fun Previewsample() {
    val image: Painter = painterResource(id = R.drawable.rocket)
    sample(data = data(name = "sharikh", lastmsg = "hello", time = "12/01/22", profile = image, status = "Missed"))
}