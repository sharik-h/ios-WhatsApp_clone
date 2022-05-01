package com.example.whatsapp_clone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.data.UserExtra
import com.example.whatsapp_clone.loginPageNavigation.loginPageNavGraph
import com.example.whatsapp_clone.sharedpreferences.ViewModel.MainViewModel
import com.example.whatsapp_clone.ui.theme.WhatsAppcloneTheme
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.User


class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var navHostController: NavHostController
    var signed = false

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.readtoken.observe(this) { token ->
            viewModel.readid.observe(this) { id ->
                viewModel.readname.observe(this) { name ->
                    viewModel.readphone.observe(this) { phone ->
                        viewModel.readimage.observe(this) { image ->


                            val user = User(
                                id = id,
                                extraData = mutableMapOf(
                                    UserExtra.NAME to name,
                                    UserExtra.PHONE to phone,
                                    UserExtra.IMAGE to image
                                )
                            )

                            Log.d("details",token)
                            Log.d("details", user.toString())


                            ChatClient.instance().disconnect()
                            ChatClient.instance().connectUser( user = user,token = token)
                                .enqueue { result ->
                                    if (result.isSuccess){
                                        startActivity(Intent(applicationContext, secondActivity::class.java))
                                        finishAffinity()
                                        signed = true
                                    }else {
                                        Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        }
                    }
                }
            }
        }

        setContent {
            WhatsAppcloneTheme {
                navHostController = rememberNavController()
                loginPageNavGraph(navHostController = navHostController,signed = signed)
//                Splash(navHostController = navHostController)
            }
        }
    }
}


