package com.example.whatsapp_clone.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapp_clone.R

@Composable
fun chatPage() {
    Box(Modifier.background(Color.Cyan)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "sample")
        }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Row(modifier = Modifier
                .background(Color.LightGray)
                .height(60.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "", Modifier.size(30.dp))


                var msg by remember{ mutableStateOf("")}
                OutlinedTextField(
                    value = "",
                    onValueChange = { newmsg -> msg = newmsg },
                    modifier = Modifier
                        .background(Color.White)
                        .height(40.dp)
                        .width(260.dp)
                        .clip(RoundedCornerShape(50))
                )

                val camimg: Painter = painterResource(id = R.drawable.camera)
                Image(
                    painter = camimg,
                    contentDescription = "cam image",
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(30.dp)

                )
                val micimg : Painter = painterResource(id = R.drawable.microphone)
                Image(
                    painter = micimg,
                    contentDescription = "cam image",
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(30.dp)

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewchatPage() {
    chatPage()
}