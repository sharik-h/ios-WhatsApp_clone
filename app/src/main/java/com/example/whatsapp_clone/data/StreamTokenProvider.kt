package com.example.whatsapp_clone.data

import io.getstream.chat.android.client.token.TokenProvider
import kotlinx.coroutines.runBlocking

class StreamTokenProvider(
    private val api: StreamTokenApi
) {
    fun getTokenProvider(userId: String): TokenProvider
    {
        return object: TokenProvider
        {
            override fun loadToken(): String = runBlocking{
                api.getToken(userId).token
            }
        }
    }
}
//JwfrDDCBkmVkvsBOIWFHHI3GeYH3
