package com.example.whatsapp_clone.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R
import io.getstream.chat.android.compose.ui.messages.MessagesScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

class ChatActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatPage()
        }
    }



    @Composable
    fun ChatPage() {
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
                        .clickable(
                            onClick = {
                             //   navController.navigate(BottombarScreen.chatProfileDetail.route)
                            })
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

        val cid = intent.getStringExtra("cid") ?: return

        ChatTheme {
            MessagesScreen(
                channelId = cid,
                onBackPressed = { finish() }
            )
        }

    }

}