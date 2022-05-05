package com.example.whatsapp_clone.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R
import com.example.whatsapp_clone.ui.theme.chatbackgroud
import com.example.whatsapp_clone.ui.theme.lblue


class ChatDetail: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            chatProfileDetail()
        }
    }

    val DivColor = Color.LightGray

    @Composable
    fun chatProfileDetail() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(chatbackgroud)
        ) {
            TopAppBar(
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val backimg: Painter = painterResource(id = R.drawable.back_96)
                IconButton(onClick = { finish() }) {
                    Image(painter = backimg, contentDescription = "back button")
                }

                Text(text = "Sharikh", fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier =  Modifier.weight(1f))
                Text(text = "Edit", fontSize = 20.sp, color = lblue, modifier = Modifier.padding(end = 10.dp))
            }
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {



            val profilepic: Painter = painterResource(id = R.drawable.img_0922)
            Image(painter = profilepic, contentDescription = " ")

            Box(modifier = Modifier.background(Color.White) )
            {
                Column {
                    Divider(thickness = 1.dp, color = DivColor)

                    detailItem(title = "Sharikh", Name = true, sub = "+91 8129697750", Divider = true)
                    detailItem(title = "You can if you belive it", Name = false, sub = "5 Feb 2022", Divider = false )

                    Divider(thickness = 1.dp, color = DivColor)
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .background(Color.White)
            ) {

                Column {
                    val mediaimg: Painter = painterResource(id = R.drawable.photo_64)
                    val star: Painter = painterResource(id = R.drawable.starred_message)
                    val search: Painter = painterResource(id = R.drawable.search_90)

                    Divider(thickness = 1.dp, color = DivColor)

                    openItem(title = "Media, Links and Docs", color = Color.Black, isImage = true, Image = mediaimg ,Arrow = true, Divider = true )
                    openItem(title = "Starred Messages", color = Color.Black, isImage = true, Image = star ,Arrow = true, Divider = true)
                    openItem(title = "Chats Search", color = Color.Black, isImage = true, Image = search, Arrow = true, Divider = false)

                    Divider(thickness = 1.dp, color = DivColor)
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .background(Color.White)
            ) {
                Column() {
                    val contactinfoimg: Painter = painterResource(id = R.drawable.person_64)

                    Divider(thickness = 1.dp, color = DivColor)

                    openItem(title = "Contact Details", color = Color.Black, isImage = true, Image = contactinfoimg,Arrow = true, Divider = false)

                    Divider(thickness = 1.dp, color = DivColor)
                }
            }

            Box( modifier = Modifier
                .padding(top = 25.dp)
                .background(Color.White)
            ) {
                Column()
                {
                    Divider(thickness = 1.dp, color = DivColor)
                    val contactinfoimg: Painter = painterResource(id = R.drawable.person_64)

                    openItem(title = "Share Contact", color = lblue, isImage = false, Image = contactinfoimg, Arrow = false, Divider = true )
                    openItem(title = "Clear Chat", color = Color.Red, isImage = false, Image = contactinfoimg, Arrow = false, Divider = true )
                    openItem(title = "Delete Chat", color = Color.Red, isImage = false, Image = contactinfoimg, Arrow = false, Divider = false )

                    Divider(thickness = 1.dp, color = DivColor)
                }
            }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun prev() {
        chatProfileDetail()
    }

    @Composable
    fun openItem(title: String,color: Color, isImage: Boolean, Image:Painter, Arrow: Boolean, Divider: Boolean) {
        Column {

            val openArrow: Painter = painterResource(id = R.drawable.open_arrow)
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                if (isImage){
                    Image(
                        painter = Image,
                        contentDescription = "",
                        Modifier.size(30.dp)
                    )
                }
                Text(
                    text = title,
                    color = color,
                    fontSize = 21.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                )
                if(Arrow) {
                    Image(
                        painter = openArrow,
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(top = 5.dp)
                    )
                }
            }
            if (Divider) {
                Divider(
                    thickness = 1.dp,
                    color = DivColor,
                    modifier = Modifier.padding(start = 51.dp)
                )
            }
        }
    }

    @Composable
    fun detailItem(title: String, Name:Boolean, sub: String, Divider: Boolean) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
        ) {
            Column {
                if (Name){
                    Text(
                        text = title,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }else{
                    Text(
                        text = title,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                Text(
                    text = sub,
                    color = Color(0xFF818181),
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
            }
        }
        if (Divider) {
            Divider(
                thickness = 1.dp,
                color = DivColor,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }

}



