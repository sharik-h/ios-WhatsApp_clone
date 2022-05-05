package com.example.whatsapp_clone.pages

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.whatsapp_clone.Navigation.BottombarScreen
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
        val context = LocalContext.current
        val cid = intent.getStringExtra("cid") ?: return
        ChatTheme {
            MessagesScreen(
                channelId = cid,
                onBackPressed = { finish() },
                onHeaderActionClick = { context.startActivity(Intent(context, BottombarScreen.chatProfileDetail::class.java)) }
            )
        }
    }
}
