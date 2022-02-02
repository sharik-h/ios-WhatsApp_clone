package com.example.whatsapp_clone

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.data
import org.w3c.dom.Text
import kotlin.math.log

@Composable
fun log_sample(data: data){
Column() {
    Row {
        Image(
            painter = data.profile,
            contentDescription = "hello",
            modifier = Modifier
                .padding(13.dp)
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(50))
        )
        Column(
            modifier = Modifier
                .width(180.dp)
                .padding(vertical = 12.dp)
        ) {
            var color = Color.Black
           if (data.status == "Missed"){  color = Color.Red }
                   Text(
                       text = "${data.name}",
                       fontSize = 20.sp,
                       color = color,
                       modifier = Modifier.fillMaxWidth()
            )
            Row {
                val phoneimg: Painter = painterResource(id = R.drawable.icons8_phone_30)
                Image(painter = phoneimg, contentDescription = "phone icon", modifier = Modifier.size(25.dp))
                Text(
                    text = "${data.status}",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            text = "${data.time}",
            fontSize = 18.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 25.dp)
                .width(80.dp)
                .height(34.dp)
        )
        val info: Painter = painterResource(id = R.drawable.icons8_info_50__1_)
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 12.dp)) {
           Icon(
               painter = info,
               contentDescription = "information button",
               modifier = Modifier
                   .size(30.dp),
               tint = Color(0xFF1786FF)
           )
        }
    }
    Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(start = 80.dp))
}
}

@Preview(showBackground = true)
@Composable
fun Previewlogsample(){
    val image: Painter = painterResource(id = R.drawable.rocket)
    log_sample(data = data(name = "sharikh", lastmsg = "hello", time = "12/01/22", profile = image, status = "Missed"))
}