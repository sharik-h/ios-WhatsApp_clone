package com.example.whatsapp_clone.pages.newChat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.whatsapp_clone.pages.ChatListView.ChatView.ChatActivity
import com.google.firebase.auth.FirebaseAuth
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.api.models.QueryUsersRequest
import io.getstream.chat.android.client.models.Filters
import io.getstream.chat.android.client.models.User

class StartNewChatActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  currentuser = FirebaseAuth.getInstance().currentUser ?: return

        val request = QueryUsersRequest(
            filter = Filters.ne("id", currentuser.uid),
            offset = 0,
            limit = 100 )
        ChatClient.instance().queryUsers(request).enqueue{ result ->
            if (result.isSuccess){
                setContent {
                    AllUsers(result.data(), currentuser.uid)
                }
            }else{
                Log.d("list","failure")
                return@enqueue
            }
        }

    }



    @Composable
     fun AllUsers(data: List<User>, uid: String) {
        Column {
            Text(
                text = "New Chat",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        LazyColumn() {
            items(items = data) { user ->
                sampleItem(data = user, uid)
            }
        }
        }
    }

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun sampleItem(data: User, uid: String) {
        val context = LocalContext.current
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable(
                onClick = {
                    ChatClient
                        .instance()
                        .createChannel(channelType = "messaging", members = listOf(uid, data.id))
                        .enqueue{ result ->
                            if (result.isSuccess){
                                context.startActivity(
                                    Intent(context, ChatActivity::class.java)
                                        .putExtra("cid",result.data().cid)
                                )
                                finish()
                            }else Toast.makeText(applicationContext, "sorry", Toast.LENGTH_SHORT).show()
                        } }
            )
        ) {
            Row( modifier = Modifier.padding(5.dp)) {
                val image = rememberImagePainter(data = data.image, builder = { })
                Image(
                    painter = image,
                    contentDescription = "sample image",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clip(RoundedCornerShape(50))
                        .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(50))
                )
                Text(
                    text = data.name,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(top = 13.5.dp, start = 10.dp)
                )
            }
            Divider(thickness = 1.dp, modifier = Modifier.padding(start = 65.dp))
        }
    }

}


