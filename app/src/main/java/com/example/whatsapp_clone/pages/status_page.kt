package com.example.whatsapp_clone.pages

import android.app.appsearch.AppSearchBatchResult
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.R

@Composable
fun Statuspage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE0E0E0))
    )
    {
        Text(
            text = "Status",
            fontWeight = FontWeight.Bold,
            fontSize = 46.sp,
            modifier = Modifier.padding(15.dp)
        )
        var search by remember{ mutableStateOf("Search")}
        TextField(
            value = search,
            onValueChange = {text -> search = text},
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFDADADA))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp)
                .height(90.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(13.dp)
            ) {
                val myimage: Painter = painterResource(id = R.drawable.img_0922)
                Image(
                    painter = myimage,
                    contentDescription = "my Profile pic",
                    modifier = Modifier
                        .size(67.dp)
                        .clip(RoundedCornerShape(50))
                )

                var sampleImage: Painter = painterResource(id = R.drawable.bg_circle)


                Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
                    Text(text = "My Status", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Add to my status", fontSize = 15.sp, color = Color(0xFF9E9E9E))
                }

                val camera: Painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24)
                val edit: Painter = painterResource(id = R.drawable.ic_baseline_edit_24)

//                Button(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .background(Color.LightGray)
//                        .width(40.dp)
//                        .height(40.dp)
//                        .clip(RoundedCornerShape(50))
//
//                ) {
//                            Image(painter = camera, contentDescription = "camera icon", modifier = Modifier
//                                .width(40.dp)
//                                .height(40.dp))
//                }
//
//                Button(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .width(50.dp)
////                        .height(40.dp)
//                        .clip(RoundedCornerShape(50))
//                ) {
//                    Image(
//                        painter = edit,
//                        contentDescription = "edit icon",
//                        modifier = Modifier
//                            .width(25.dp)
//                            .height(25.dp))
//                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterEnd,
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .height(45.dp)
                                .width(45.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = camera, contentDescription = "")
                        }
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .height(45.dp)
                                .width(45.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = edit, contentDescription = "")
                        }
                    }
                }
            }
        }

        Text(
            text = "VIEWED UPDATES",
            modifier = Modifier.padding(horizontal = 15.dp),
            color = Color(0xFF999999)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Previewstatuspage() {
    Statuspage()
}