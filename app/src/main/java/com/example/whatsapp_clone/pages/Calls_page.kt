package com.example.whatsapp_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.sample_data.Repository
import com.example.whatsapp_clone.sample_data.data

@Composable
fun Calls() {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {

        var search by remember { mutableStateOf("")}

        Text(
            text = "Calls",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = "Search",
            onValueChange = { newText -> search = newText },
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFDBDBDB)),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
        )
        val sharikhimg: Painter = painterResource(id = R.drawable.img_0922)
        val sharhanimg: Painter = painterResource(id = R.drawable.img_1575)
        val aminaimg: Painter = painterResource(id = R.drawable.img_0799)
        val repository = Repository()
        val getData = repository.getAllData(sharikhimg, sharhanimg, aminaimg)
        LazyColumn(){
            items(items=  getData){data ->
                sample(data = data)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCalls() {
    Calls()
}