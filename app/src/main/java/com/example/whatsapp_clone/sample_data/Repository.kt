package com.example.whatsapp_clone.sample_data

import androidx.compose.ui.graphics.painter.Painter

class Repository {
    fun getAllData(sharikhimg: Painter, sharhanimg: Painter, aminaimg: Painter): List<data> {
        return listOf(
            data(
                name = "sharikh",
                profile = sharikhimg,
                lastmsg = "hi",
                time = "10:11"
            ),
            data(
                name = "sharhan",
                profile = sharhanimg,
                lastmsg = "Sugam alle",
                time = "01:55"
            ),
            data(
                name = "Amina",
                profile = aminaimg,
                lastmsg = "Photo ayak",
                time = "04:45"
            )
        )
    }

}