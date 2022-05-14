package com.example.whatsapp_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class secondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val image = intent.getStringExtra("image")
        val user = arrayOf(id, name, phone, image)
        super.onCreate(savedInstanceState)
        setContent {
                MainScreen(user!!)

        }
    }
}