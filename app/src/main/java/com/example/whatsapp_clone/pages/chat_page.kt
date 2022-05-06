package com.example.whatsapp_clone.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp_clone.R
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@Composable
fun chatPage(navController: NavHostController, cid: String) {
    Box() {

        Column(modifier = Modifier.fillMaxSize()) {
            val bg: Painter = painterResource(id = R.drawable.wsappbg)
            Image(
                painter = bg,
                contentDescription = "",
                modifier = Modifier.fillMaxSize() )
        }
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom)
//        {
//            Divider(thickness = 1.dp, color = Color(0xFF686868))
//            Row(modifier = Modifier
//                .height(60.dp)
//                .fillMaxWidth()
//                .background(Color.White),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                val addimg: Painter = painterResource(id = R.drawable.plus__96)
//                Icon(
//                    painter = addimg,
//                    contentDescription = "",
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .size(30.dp)
//                )
//
//                val stickerimg: Painter = painterResource(id = R.drawable.icons8_sticker_96)
//                var msg by remember{ mutableStateOf("")}
//                OutlinedTextField(
//                    value = "",
//                    onValueChange = { newmsg -> msg = newmsg },
//                    modifier = Modifier
//                        .background(Color(0xFFF6F6F6))
//                        .height(40.dp)
//                        .width(230.dp)
//                        .clip(RoundedCornerShape(50))
//                        .padding(end = 5.dp),
//                    trailingIcon = {
//                        IconButton(onClick = { /*TODO*/ }) {
//                            Image(painter = stickerimg, contentDescription = "select any sticker",
//                            modifier = Modifier.size(30.dp))
//                        }
//                    }
//                )
//
//                val rupeeimg: Painter = painterResource(id = R.drawable.icons8_rupee_96)
//                Image(
//                    painter = rupeeimg,
//                    contentDescription = "payment method icon",
//                    modifier = Modifier
//                        .padding(horizontal = 5.dp)
//                        .size(25.dp)
//                )
//                val camimg: Painter = painterResource(id = R.drawable.camera_96)
//                Image(
//                    painter = camimg,
//                    contentDescription = "cam image",
//                    modifier = Modifier
//                        .padding(horizontal = 5.dp)
//                        .size(30.dp)
//
//                )
//                val micimg : Painter = painterResource(id = R.drawable.microphone_96)
//                Image(
//                    painter = micimg,
//                    contentDescription = "cam image",
//                    modifier = Modifier
//                        .padding(horizontal = 5.dp)
//                        .size(30.dp)
//
//                )
//
//            }
//        }

        //AppBar
        TopAppBar(
            backgroundColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(vertical = 6.dp)) {
                val backimg: Painter = painterResource(id = R.drawable.back_96)
                IconButton(
                    onClick = { /*TODO*/ },

                ) {
                    Icon(
                        painter = backimg,
                        contentDescription = "go back to listView page.",
                    )
                }

                Row(
                    modifier = Modifier
//                        .clickable(
//                            onClick = {navController.navigate(BottombarScreen.chatProfileDetail.route)
//                            })
                ) {
                    val profilepic: Painter = painterResource(id = R.drawable.img_0922)
                    Image(
                        painter = profilepic,
                        contentDescription = "",
                        modifier = Modifier.clip(RoundedCornerShape(50))
                    )
                    Text(
                        text = "Sharikh",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 7.dp, start = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(110.dp))
                }
                val videoimg: Painter = painterResource(id = R.drawable.video_camera_64)
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = videoimg,
                        contentDescription = "video call iconButton",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(30.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(10.dp))
                
                val phoneimg: Painter = painterResource(id = R.drawable.phone_50)
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = phoneimg,
                        contentDescription = "voice call iconButton",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(30.dp)
                    )
                }
            }
        }



        ChatTheme {
//            Messages
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewchatPage() {
//    chatPage(navController = rememberNavController())
}