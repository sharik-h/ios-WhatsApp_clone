package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.whatsapp_clone.ui.theme.lblue

@Composable
fun Calls(Rnames: Array<String?>, Rimages: Array<String?>) {

    Column() {
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(), ) {
            Text(
                text = "Edit",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 5.dp),
                color = lblue
            )
            Spacer(modifier = Modifier.width(125.dp))
            Spacer(modifier = Modifier.width(165.dp))

            val newcallimg : Painter = painterResource(id = R.drawable.icons8_add_phone_32__1_)
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = newcallimg,
                    contentDescription = "To start a new chat",
                    Modifier.size(27.dp)
                )
            }
        }
        Column( modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()) )
        {
            val helvetica = FontFamily(Font(R.font.helvetica))
            Text(
                text = "Calls",
                fontSize = 40.sp,
                fontFamily = helvetica,
                modifier = Modifier.padding(start = 10.dp)
            )
            Divider(thickness = 1.dp , color = Color.LightGray)

            val n = (0..20).random()
            val order = arrayOfNulls<Int>(n)
            for (i in 0 until n) {
             order[i] = (0..Rnames.lastIndex).random()
            }

            for (i in order){
                Rnames[i!!]?.let { Rimages[i]?.let { it1 -> log_ample(Rname = it, Rimage = it1) } }
            }


        }
    }
}

@Composable
fun log_ample(Rname: String,Rimage: String){
    Column() {
        Row {



            if (Rimage == ""){
                val pic: Painter = painterResource(id = R.drawable.profile_pic)
                Image(
                    painter = pic,
                    contentDescription = "sample image",
                    modifier = Modifier
                        .size(45.dp)
                        .padding(top = 7.dp, start = 5.dp,end = 5.dp)
                        .clip(RoundedCornerShape(50))
                )
            }else {
               val pic = rememberImagePainter(data = Rimage)
                Image(
                    painter = pic,
                    contentDescription = "sample image",
                    modifier = Modifier
                        .size(45.dp)
                        .padding(top = 7.dp, start = 5.dp,end = 5.dp)
                        .clip(RoundedCornerShape(50))
                )

           }
            val status = arrayOf("Outgoing", "Incoming", "Missed").random()
            val mm = (0..60).random().toString()
            val hh = (1..12).random().toString()
            val sud = arrayOf("PM", "AM").random()
            val time = hh+":"+mm+" "+sud

            val info: Painter = painterResource(id = R.drawable.icons8_info_50__1_)
            val phoneimg: Painter = painterResource(id = R.drawable.icons8_phone_30)

            var color = Color.Black
            if (status == "Missed"){  color = Color.Red }

            Column(
                modifier = Modifier
                    .width(180.dp)
                    .padding(vertical = 5.dp)
                    .weight(1f)
            ) {

                Text(
                    text = Rname,
                    fontSize = 17.sp,
                    color = color,
                    modifier = Modifier.fillMaxWidth()
                )
                Row {
                    Image(painter = phoneimg, contentDescription = "phone icon", modifier = Modifier.padding(top = 2.dp).size(20.dp))
                    Text(
                        text = status,
                        fontSize = 17.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }


            Text(
                text = time,
                fontSize = 15.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 18.dp)
                    .width(80.dp)
                    .height(34.dp)
            )
                Icon(
                    painter = info,
                    contentDescription = "information button",
                    modifier = Modifier.size(40.dp).padding(end = 5.dp, top = 18.dp),
                    tint = lblue
                )
        }
        Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(start = 60.dp))
    }
}




