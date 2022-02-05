package com.example.whatsapp_clone.pages

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R

@Composable
fun chatProfileDetail() {
  Column(
      modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFFF2F2F7))
  ) {
      //AppBar
      TopAppBar(
          backgroundColor = Color.White,
          modifier = Modifier
              .fillMaxWidth()
      ) {
          val backimg: Painter = painterResource(id = R.drawable.back_96)
          IconButton(onClick = { /*TODO*/ }) {
                  Image(painter = backimg, contentDescription = "back button")
          }

          Text(
              text = "Sharikh",
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold,
          )
          Spacer(modifier = Modifier.width(210.dp))
          Text(
              text = "Edit",
              fontSize = 20.sp,
              color = Color(0xFF1796FF)
          )
      }

      val profilepic: Painter = painterResource(id = R.drawable.img_0922)
      Image(painter = profilepic, contentDescription = " ")

      Box(
          modifier = Modifier
//              .padding(top = 20.dp)
              .background(Color.White)
      ){
          Column {

              Divider(thickness = 1.dp, color = Color.LightGray)

              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(7.dp)
              ) {
                  Column {
                      Text(
                          text = "sharikh",
                          fontSize = 25.sp,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(start = 10.dp)
                      )
                      Text(
                          text = "+91 8129697750",
                          color = Color(0xFF818181),
                          modifier = Modifier.padding(start = 10.dp),
                          fontSize = 15.sp
                      )
                  }
              }
              Divider(
                  thickness = 1.dp,
                  color = Color.LightGray,
                  modifier = Modifier.padding(start = 15.dp)
              )

              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(7.dp)
              ) {
                  Column() { 
                      Text(
                          text = "You can do it sharikh.",
                          fontSize = 17.sp,
                          modifier = Modifier.padding(start = 10.dp)
                      )
                      Text(
                          text = "5 Feb 2022",
                          color = Color(0xFF818181),
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

              val openArrow: Painter = painterResource(id = R.drawable.open_arrow)
              Divider(thickness = 1.dp, color = Color.LightGray)
              Row(
                  modifier = Modifier.padding(10.dp)
              ) {
                  val mediaimg: Painter = painterResource(id = R.drawable.photo_64)
                  Image(
                      painter = mediaimg,
                      contentDescription = "starred messages",
                      Modifier.size(30.dp)
                  )
                  Text(
                      text = "Media, Links and Docs",
                      fontSize = 21.sp,
                      modifier = Modifier.padding(start = 10.dp))
                  Image(
                      painter = openArrow,
                      contentDescription = "",
                      modifier = Modifier
                          .padding(start = 100.dp, top = 6.dp)
                          .size(20.dp),
                  )
              }
              Divider(
                  thickness = 1.dp,
                  color = Color.LightGray,
                  modifier = Modifier.padding(start = 51.dp)
              )
              Row(modifier = Modifier.padding(10.dp)) {
                  val star: Painter = painterResource(id = R.drawable.starred_message)
                  Image(
                      painter = star,
                      contentDescription = "user Profile and details",
                      Modifier.size(30.dp)
                  )
                  Text(
                      text = "Starred Messages",
                      fontSize = 21.sp,
                      modifier = Modifier.padding(start = 10.dp))
                  Image(
                      painter = openArrow,
                      contentDescription = "",
                      modifier = Modifier
                          .padding(start = 140.dp, top = 6.dp)
                          .size(20.dp),
                  )
              }
              Divider(
                  thickness = 1.dp,
                  color = Color.LightGray,
                  modifier = Modifier.padding(start = 51.dp)
              )
              Row(modifier = Modifier.padding(10.dp)) {
                  val chatsearchimg: Painter = painterResource(id = R.drawable.search_90)
                  Image(
                      painter = chatsearchimg,
                      contentDescription = "chat controlls",
                      Modifier.size(30.dp)
                  )
                  Text(
                      text = "Chats Search",
                      fontSize = 21.sp,
                      modifier = Modifier.padding(start = 10.dp))
                  Image(
                      painter = openArrow,
                      contentDescription = "",
                      modifier = Modifier
                          .padding(start = 185.dp, top = 6.dp)
                          .size(20.dp),
                  )
              }

              TabRowDefaults.Divider(thickness = 1.dp, color = Color.LightGray)

          }
      }

      Box(
          modifier = Modifier
              .padding(top = 25.dp)
              .background(Color.White)
      ) {
          Column() {
              val contactinfoimg: Painter = painterResource(id = R.drawable.person_64)
              val openArrow: Painter = painterResource(id = R.drawable.open_arrow)
              Divider(thickness = 1.dp, color = Color.LightGray)
              Row(
                  modifier = Modifier.padding(10.dp)
              ) {
                  val mediaimg: Painter = painterResource(id = R.drawable.photo_64)
                  Image(
                      painter = contactinfoimg,
                      contentDescription = "contact info",
                      Modifier.size(30.dp)
                  )
                  Text(
                      text = "Contact Details",
                      fontSize = 21.sp,
                      modifier = Modifier.padding(start = 10.dp))
                  Image(
                      painter = openArrow,
                      contentDescription = "",
                      modifier = Modifier
                          .padding(start = 165.dp, top = 6.dp)
                          .size(20.dp),
                  )
              }
              Divider(thickness = 1.dp, color = Color.LightGray)
          }
      }

      Box( modifier = Modifier
          .padding(top = 25.dp)
          .background(Color.White)
      ) {
          Column()
          {
              Divider(thickness = 1.dp, color = Color.LightGray)
                  Text(
                      text = "Share Contact",
                      fontSize = 21.sp,
                      color = Color(0xFF1786FF),
                      modifier = Modifier.padding( 10.dp))

              Divider(
                  thickness = 1.dp,
                  color = Color.LightGray,
                  modifier = Modifier.padding(start = 10.dp)
              )

                  Text(
                      text = "Clear Chat",
                      fontSize = 21.sp,
                      color = Color.Red,
                      modifier = Modifier.padding( 10.dp))

              Divider(
                  thickness = 1.dp,
                  color = Color.LightGray,
                  modifier = Modifier.padding(start = 10.dp)
              )

                  Text(
                      text = "Block Contact",
                      fontSize = 21.sp,
                      color = Color.Red,
                      modifier = Modifier.padding( 10.dp))


              Divider(thickness = 1.dp, color = Color.LightGray)

          }
      }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatProfile() {
    chatProfileDetail()
}