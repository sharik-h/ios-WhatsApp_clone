package com.example.whatsapp_clone.loginPages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R
import com.example.whatsapp_clone.data.StreamTokenApi
import com.example.whatsapp_clone.data.StreamTokenProvider
import com.example.whatsapp_clone.data.UserExtra
import com.example.whatsapp_clone.secondActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.User


class userActivity: ComponentActivity() {

    private lateinit var currentuser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            profileSetUp()
        }
    }

    private fun verify(name: String) {

        currentuser = FirebaseAuth.getInstance().currentUser ?: return
        Log.d("currentuser", currentuser.uid)
        val user = User(
            id = currentuser.uid,
            extraData = mutableMapOf(
                UserExtra.NAME to name,
                UserExtra.PHONE to currentuser.phoneNumber.toString(),
                UserExtra.IMAGE to "https://bit.ly/2TIt8NR"
            )
        )

        val StreamApi = StreamTokenApi()
        val TokenProvider = StreamTokenProvider(StreamApi)

        val token = TokenProvider.getTokenProvider(currentuser.uid).loadToken()
        Log.d("token", token)

        ChatClient.instance().disconnect()

        ChatClient.instance().connectUser(
            user = user,
            token = token
        )
            .enqueue { result ->
                if (result.isSuccess) {
                    startActivity(Intent(applicationContext, secondActivity::class.java))
                } else {
                    Toast.makeText(applicationContext, "connection failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }


    @Composable
    fun profileSetUp() {
        var name by remember { mutableStateOf("") }
        val profileName = name

        Column(
            Modifier
                .fillMaxSize()
//            .padding(20.dp)
        ) {
            TopAppBar(
                backgroundColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                
                Spacer(modifier = Modifier.padding(start = 140.dp))

                Text(
                    text = "Edit Profile",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.padding(start = 80.dp))
                TextButton(
                    onClick = { verify(profileName) }
                ) {
                    Text(
                        text = "Done",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp),
                        textAlign = TextAlign.Right,
                        color = Color(0xFF1786ff)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Row(modifier = Modifier.padding(10.dp)) {
                val setProfileimg: Painter = painterResource(id = R.drawable.profile_pic)
                Image(
                    painter = setProfileimg,
                    contentDescription = "",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(
                    text = "Enter your name and Add an optional profile picture",
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

                Spacer(modifier = Modifier.padding(top = 15.dp))
                Divider(thickness = 1.dp, modifier = Modifier.padding(start = 20.dp))
            BasicTextField(
                value = name,
                onValueChange = { nam -> name = nam },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                singleLine = true,
                )
                Divider(thickness = 1.dp, modifier = Modifier.padding(start = 15.dp))
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun prev() {
        profileSetUp()
    }
}

