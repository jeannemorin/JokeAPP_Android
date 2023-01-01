package com.example.jokeappv2.display

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jokeappv2.display.ui.theme.Paragraph
import com.example.jokeappv2.display.ui.theme.Red200

@Composable
fun ErrorCard(msg : String) {
    val shape = RoundedCornerShape(8.dp)

    Row (
        modifier = Modifier
            .background(Red200, shape=shape)
            .defaultMinSize(minHeight = 100.dp)
            .fillMaxWidth()
    ) {
        Column (modifier = Modifier.padding(20.dp)) {
            Text(
                text = "ERROR",
                style = MaterialTheme.typography.body1,
                fontSize = 16.sp,
                color= Paragraph
            )
            Text(
                text = msg,
                style = MaterialTheme.typography.body1,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}