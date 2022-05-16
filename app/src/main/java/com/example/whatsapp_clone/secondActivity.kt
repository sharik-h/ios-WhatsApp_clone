package com.example.whatsapp_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.auth.FirebaseAuth
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.api.models.QueryUsersRequest
import io.getstream.chat.android.client.models.Filters

class secondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val image = intent.getStringExtra("image")
        val user = arrayOf(id, name, phone, image)

        val currentuser = FirebaseAuth.getInstance().currentUser ?: return
        val request = QueryUsersRequest(
            filter = Filters.ne("id", currentuser.uid),
            offset = 0,
            limit = 100 )
        ChatClient.instance().queryUsers(request).enqueue{
            if (it.isSuccess){
                var names = arrayOfNulls<String>(it.data().size)
                var images = arrayOfNulls<String>(it.data().size)
                for (i in 0..it.data().lastIndex){
                    names[i] = it.data()[i].name
                    images[i] = it.data()[i].image
                }
                setContent {
                    MainScreen(user!!,names,images)
                }
            }else{
                setContent {
                   // MainScreen(user!!, it.data(), images)
                }
            }
        }


    }
}