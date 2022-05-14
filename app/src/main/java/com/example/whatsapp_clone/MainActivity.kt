package com.example.whatsapp_clone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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

    var delete = "false"
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delete = intent.getStringExtra("delete").toString()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (delete == "true") {
            viewModel.deleteFromDataStore()
        }

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


                            ChatClient.instance().disconnect()
                            ChatClient.instance().connectUser( user = user,token = token)
                                .enqueue { result ->
                                    if (result.isSuccess){
                                        startActivity(Intent(applicationContext, secondActivity::class.java)
                                            .putExtra("id",id)
                                            .putExtra("name",name)
                                            .putExtra("phone",phone)
                                            .putExtra("image",image)
                                        )
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



