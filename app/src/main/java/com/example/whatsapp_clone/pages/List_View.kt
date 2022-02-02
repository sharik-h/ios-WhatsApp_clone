package com.example.whatsapp_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.Repository

@Composable
fun ListView() {

    Column(Modifier.fillMaxSize()) {
        //AppBar
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(), ) {
                Text(
                    text = "Edit",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 5.dp),
                    color = Color(0xFF1786FF)

                )
            Spacer(modifier = Modifier.width(125.dp))
                Text(text = "Chats", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(145.dp))

                val newchatimg: Painter = painterResource(id = R.drawable.edit)
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = newchatimg,
                        contentDescription = "To start a new chat",
                        Modifier.size(25.dp)
                    )
                }
        }

        Column( modifier = Modifier.fillMaxSize() )
        {

            var search by remember { mutableStateOf("Search") }
            val helvetica = FontFamily(Font(R.font.helvetica))

            Text(
                text = "Chats",
                fontFamily = helvetica,
                fontWeight = FontWeight.Bold,
                fontSize = 37.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
            )

//            TextField(
//                value = search,
//                onValueChange = { newText -> search = newText },
//                modifier = Modifier
//                    .height(40.dp)
//                    .width(400.dp)
//                    .background(color = Color(0xFFFAFAFA))
//                    .padding(horizontal = 15.dp),
//                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
//            )

            Row(modifier = Modifier.padding(top = 18.dp, start = 15.dp, end = 15.dp, bottom = 5.dp))
            {
                Text(
                    text = "Brodcast List",
                    fontSize = 20.sp,
                    color = Color(0xFF1786FF)
                )
                Text(
                    text = "New Group",
                    fontSize = 20.sp,
                    color = Color(0xFF1786FF),
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            //1786FF
            Divider(thickness = 1.dp, color = Color.LightGray)


            val sharikhimg: Painter = painterResource(id = R.drawable.img_0922)
            val sharhanimg: Painter = painterResource(id = R.drawable.img_1575)
            val aminaimg: Painter = painterResource(id = R.drawable.img_0799)


            val repository = Repository()
            val getData = repository.getAllData(sharikhimg, sharhanimg, aminaimg)


            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                items(items = getData){ data ->
                    sample(data)
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListView() {
    ListView()
}