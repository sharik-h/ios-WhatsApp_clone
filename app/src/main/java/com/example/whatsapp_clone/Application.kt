package com.example.whatsapp_clone

import android.app.Application
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.livedata.ChatDomain

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        val client = ChatClient.Builder("4yhjj88kc8ec",applicationContext).logLevel(ChatLogLevel.ALL).build()
        ChatDomain.Builder(ChatClient.instance(),applicationContext).build()
    }

}