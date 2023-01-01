package com.example.jokeappv2.display

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {

    Surface(color = Color.Cyan, elevation = 8.dp, modifier = Modifier.fillMaxWidth()) {
        Text("10 jokes a day",
            fontSize = 25.sp,
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color= Color.White)
    }
}