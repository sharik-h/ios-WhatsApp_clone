package com.example.whatsapp_clone

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.Repository
import com.example.whatsapp_clone.sample_data.data


@Composable
fun ListView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        var search by remember { mutableStateOf("") }

        Text(text = "Chats", fontWeight = FontWeight.Bold, fontSize = 47.sp)
        OutlinedTextField(
            value = "Search",
            onValueChange = { newText -> search = newText },
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFDBDBDB)),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
        )

        Row(modifier = Modifier.padding(vertical = 18.dp))
        {
            Text(text = "Brodcast List", fontSize = 20.sp, color = Color.Blue)
            Text(
                text = "New Group",
                fontSize = 20.sp,
                color = Color.Blue,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
        val sharikhimg: Painter = painterResource(id = R.drawable.img_0922)
        val sharhanimg: Painter = painterResource(id = R.drawable.img_1575)
        val aminaimg: Painter = painterResource(id = R.drawable.img_0799)
        val repository = Repository()
        val getData = repository.getAllData(sharikhimg, sharhanimg, aminaimg)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
             items(items = getData){ data ->
                 sample(data)
             }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListView() {
    ListView()
}