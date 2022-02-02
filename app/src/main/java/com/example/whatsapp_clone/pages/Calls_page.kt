package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.Repository
import com.example.whatsapp_clone.sample_data.data
import org.w3c.dom.Text

@Composable
fun Calls() {

    Column() {
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(), ) {
            Text(
                text = "Edit",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 5.dp),
                color = Color(0xFF1786FF)

            )
            Spacer(modifier = Modifier.width(125.dp))
//            Text(text = "Chats", fontSize = 20.sp, fontWeight = FontWeight.Bold)
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
        Column(
            modifier = Modifier
//                .padding(15.dp)
                .fillMaxSize()
        ) {

            var search by remember { mutableStateOf("")}
            val helvetica = FontFamily(Font(R.font.helvetica))
            Text(
                text = "Calls",
                fontSize = 40.sp,
                fontFamily = helvetica,
                modifier = Modifier.padding(start = 10.dp)
            )
            Divider(thickness = 1.dp , color = Color.LightGray, modifier = Modifier.padding(start = 80.dp))
//        OutlinedTextField(
//            value = "Search",
//            onValueChange = { newText -> search = newText },
//            modifier = Modifier
//                .height(40.dp)
//                .fillMaxWidth()
//                .background(color = Color(0xFFDBDBDB)),
//            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
//        )
            val sharikhimg: Painter = painterResource(id = R.drawable.img_0922)
            val sharhanimg: Painter = painterResource(id = R.drawable.img_1575)
            val aminaimg: Painter = painterResource(id = R.drawable.img_0799)
            val repository = Repository()
            val getData = repository.getAllData(sharikhimg, sharhanimg, aminaimg)
            LazyColumn(){
                items(items=  getData){data ->
                    log_sample(data)
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCalls() {
    Calls()
}