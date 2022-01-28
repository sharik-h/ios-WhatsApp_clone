package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

    var sampleImage: Painter = painterResource(id = R.drawable.ic_baseline_brightness_1_24)
    Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = data.profile,
                contentDescription = "hello",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(50.dp))
            )

        Column(  modifier = Modifier
            .width(230.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)) {


            Text(
                text = "${data.name}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${data.lastmsg}",
                fontSize = 15.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(text = "${data.time}", textAlign = TextAlign.Center, modifier = Modifier
            .width(80.dp)
            .height(34.dp)
            .padding(vertical = 5.dp) )
    }
}

@Preview(showBackground = true)
@Composable
fun Previewsample() {
    val image: Painter = painterResource(id = R.drawable.rocket)
    sample(data = data(name = "sharikh", lastmsg = "hello", time = "12:12", profile = image))
}