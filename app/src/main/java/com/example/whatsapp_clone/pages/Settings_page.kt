package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.whatsapp_clone.ui.theme.STcolor
import com.example.whatsapp_clone.ui.theme.chatbackgroud
import com.google.firebase.auth.FirebaseAuth


@Composable
fun settings()
{
    val currentuser = FirebaseAuth.getInstance().currentUser ?: return

    val star: Painter = painterResource(id = R.drawable.starred_message)
    val account: Painter = painterResource(id = R.drawable.my_account)
    val chats: Painter = painterResource(id = R.drawable.chats)
    val darkMode: Painter = painterResource(id = R.drawable.night_mode)
    val profilepic = rememberImagePainter(data = currentuser.photoUrl, builder = {})


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(chatbackgroud)
    ) {
        val helvetica = FontFamily(Font(R.font.helvetica))
        Text(text = "Settings",
            fontSize = 40.sp,
            fontFamily = helvetica,
            modifier = Modifier.padding(top = 40.dp, start = 15.dp))

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(Color.White)
        ){
            Column {

                Divider(thickness = 1.dp, color = Color.LightGray)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp)
                ) {
                    Image(
                        painter = profilepic,
                        contentDescription = "my profile pic",
                        modifier = Modifier
                            .size(67.dp)
                            .clip(RoundedCornerShape(50))
                    )
                    Column {
                        Text(
                            text = currentuser.displayName!!,
                            fontSize = 25.sp,
                            fontFamily = helvetica,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Text(
                            text = currentuser.phoneNumber!!,
                            color = STcolor,
                            modifier = Modifier.padding(start = 10.dp),
                            fontSize = 15.sp
                        )
                    }
                }
                Divider(thickness = 1.dp, color = Color.LightGray)
            }
        }


        Box(
            modifier = Modifier
                .padding(top = 25.dp)
                .background(Color.White)
        ) {
            Column {

                Divider(thickness = 1.dp, color = Color.LightGray)

                Options(
                    title = "Starred Messages",
                    isImage = true,
                    Image = star,
                    onClick = {}
                )
                Options(
                    title = "Account",
                    isImage = true,
                    Image = account,
                    onClick = {}
                )

                Options(
                    title = "Chats",
                    isImage = true,
                    Image = chats,
                    onClick = {}
                )
                Options(
                    title = "Dark mode",
                    isImage = true,
                    Image = darkMode,
                    Arrow = false,
                    switch = true,
                    Divider = false,
                    onClick = {}
                )
                Divider(thickness = 1.dp, color = Color.LightGray)
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(Color.White)
        ){
            Column {
                Options(
                    title = "Logout",
                    color = Color.Red,
                    isImage = false,
                    Image = darkMode,
                    Arrow = false,
                    Divider = true
                ) { }
                Options(
                    title = "Delete Account",
                    color = Color.Red,
                    isImage = false,
                    Image = darkMode,
                    Arrow = false,
                    Divider = false
                ) { }
                Divider(thickness = 1.dp, color = Color.LightGray)
            }
        }
    }
}



@Composable
fun Options(
    title: String,
    color: Color = Color.Black,
    isImage: Boolean,
    Image:Painter,
    Arrow: Boolean = true,
    Divider: Boolean = true,
    switch: Boolean = false,
    onClick: () -> Unit
) {
    Column {

        val DivColor = Color.LightGray
        val openArrow: Painter = painterResource(id = R.drawable.open_arrow)

        var gap: Int = 51
        if (!isImage)  gap = 20

        Row(
            modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = { onClick() })
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
            if (switch){
                Switch(
                    checked = false,
                    onCheckedChange = {},
                    modifier = Modifier.padding(top = 3.dp, start = 180.dp)
                )
            }
        }
        if (Divider) {
            androidx.compose.material.Divider(
                thickness = 1.dp,
                color = DivColor,
                modifier = Modifier.padding(start = gap.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Previewsettings() {
    settings()
}