package com.example.whatsapp_clone

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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

        LazyColumn() {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListView() {
    ListView()
}