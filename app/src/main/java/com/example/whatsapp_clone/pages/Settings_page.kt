package com.example.whatsapp_clone

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Switch
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun settings()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F7))
    ) {
        val helvetica = FontFamily(Font(R.font.helvetica))
        Text(text = "Settings",
            fontSize = 40.sp,
            fontFamily = helvetica,
            modifier = Modifier.padding(top = 40.dp, start = 15.dp))

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(Color.White)
        ){
            Column {

                Divider(thickness = 1.dp, color = Color.LightGray)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp)
                ) {
                    val propic: Painter = painterResource(id = R.drawable.img_0922)
                    Image(
                        painter = propic,
                        contentDescription = "my profile pic",
                        modifier = Modifier
                            .size(67.dp)
                            .clip(RoundedCornerShape(50))
                    )
                    Text(
                        text = "Mohammed sharikh",
                        fontSize = 25.sp,
//                        fontFamily = helvetica,
                        modifier = Modifier.padding(start = 10.dp)
                    )

                }
                Divider(thickness = 1.dp, color = Color.LightGray)
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 25.dp)
                .background(Color.White)
        ) {
            Column {

                val openArrow: Painter = painterResource(id = R.drawable.open_arrow)
                Divider(thickness = 1.dp, color = Color.LightGray)
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    val star: Painter = painterResource(id = R.drawable.starred_message)
                    Image(
                        painter = star,
                        contentDescription = "starred messages",
                        Modifier.size(30.dp)
                    )
                    Text(
                        text = "Starred message",
                        fontSize = 21.sp,
                        modifier = Modifier.padding(start = 10.dp))
                    Image(
                        painter = openArrow,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 140.dp ,top = 6.dp)
                            .size(20.dp),
                    )
                }
                Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(start = 51.dp))
                Row(modifier = Modifier.padding(10.dp)) {
                    val account: Painter = painterResource(id = R.drawable.my_account)
                    Image(
                        painter = account,
                        contentDescription = "user Profile and details",
                        Modifier.size(30.dp)
                    )
                    Text(
                        text = "Account",
                        fontSize = 21.sp,
                        modifier = Modifier.padding(start = 10.dp))
                    Image(
                        painter = openArrow,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 219.dp ,top = 6.dp)
                            .size(20.dp),
                    )
                }
                Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(start = 51.dp))
                Row(modifier = Modifier.padding(10.dp)) {
                    val chats: Painter = painterResource(id = R.drawable.chats)
                    Image(
                        painter = chats,
                        contentDescription = "chat controlls",
                        Modifier.size(30.dp)
                    )
                    Text(
                        text = "Chats",
                        fontSize = 21.sp,
                        modifier = Modifier.padding(start = 10.dp))
                    Image(
                        painter = openArrow,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 241.dp ,top = 6.dp)
                            .size(20.dp),
                    )
                }
                Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(start = 51.dp))
                Row(modifier = Modifier.padding(10.dp)) {
                    val darkMode: Painter = painterResource(id = R.drawable.night_mode)
                    Image(
                        painter = darkMode,
                        contentDescription = "change between dark and light modes",
                        Modifier.size(30.dp)
                    )
                    Text(
                        text = "Dark mode",
                        fontSize = 21.sp,
                        modifier = Modifier.padding(start = 10.dp))
                    Switch(
                        checked = false,
                        onCheckedChange = {},
                        modifier = Modifier.padding(top = 3.dp, start = 180.dp)
                    )
                }
                Divider(thickness = 1.dp, color = Color.LightGray)

            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun Previewsettings() {
    settings()
}