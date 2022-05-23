package com.example.whatsapp_clone

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.pages.ChatListView.ChatView.ChatActivity
import com.example.whatsapp_clone.pages.newChat.StartNewChatActivity
import com.example.whatsapp_clone.pages.newGroup.startNewGroupAcitivity
import com.example.whatsapp_clone.ui.theme.lblue
import io.getstream.chat.android.compose.ui.channels.list.ChannelList
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListView() {

    val context = LocalContext.current
    val helvetica = FontFamily(Font(R.font.helvetica))

    val newchatimg: Painter = painterResource(id = R.drawable.edit)

    Column(Modifier.fillMaxSize()) {
        //AppBar
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Edit",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(1f),
                textAlign = TextAlign.Start,
                color = lblue
            )

            Text(
                text = "Chats",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )

            IconButton(onClick = { context.startActivity(Intent(context, StartNewChatActivity::class.java)) } )
            {
                Image(
                    painter = newchatimg,
                    contentDescription = "To start a new chat",
                    Modifier.size(25.dp)
                )
            }
        }

        Column( modifier = Modifier.fillMaxSize() )
        {

            Text(
                text = "Chats",
                fontFamily = helvetica,
                fontWeight = FontWeight.Bold,
                fontSize = 37.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
            )

            Row(modifier = Modifier.padding(top = 18.dp, start = 15.dp, end = 15.dp, bottom = 5.dp))
            {
                Text(
                    text = "Brodcast List",
                    fontSize = 20.sp,
                    color = lblue,
                    modifier = Modifier
                        .clickable(onClick = {
                            Toast.makeText(context, "Sorrry, this feature is not yet avilable to users", Toast.LENGTH_LONG).show() })
                        .weight(1f),
                    textAlign = TextAlign.Start
                    )

                Text(
                    text = "New Group",
                    fontSize = 20.sp,
                    color = lblue,
                    modifier = Modifier
                        .clickable(
                        onClick = { context.startActivity(Intent(context,startNewGroupAcitivity::class.java)) }),
                    textAlign = TextAlign.End,
                    )
            }

            Divider(thickness = 1.dp, color = Color.LightGray)

            ChatTheme {
                ChannelList(
                    onChannelClick = { item ->
                        context.startActivity(Intent(context, ChatActivity::class.java).putExtra("cid",item.cid))
                })
            }
        }
    }
}


