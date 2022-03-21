package com.example.whatsapp_clone.sample_data

import androidx.compose.ui.graphics.painter.Painter

data class data (
    val name: String,
    val profile: Painter,
    val lastmsg: String,
    val time: String,
    val status: String
    )

data class loggedstatus (
    val name: String,
    val userId: String
        )