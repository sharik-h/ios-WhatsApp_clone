package com.example.whatsapp_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCalls() {
    Calls()
}