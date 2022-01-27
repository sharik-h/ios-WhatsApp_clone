package com.example.whatsapp_clone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun settings()
{
    Column(Modifier.fillMaxSize()) {
        Text(text = "Settings")
    }
}

@Preview(showBackground = true)
@Composable
fun Previewsettings() {
    settings()
}