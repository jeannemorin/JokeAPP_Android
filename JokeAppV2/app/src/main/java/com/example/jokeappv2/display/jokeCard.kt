package com.example.jokeappv2.display

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jokeappv2.model.Joke
import com.example.jokeappv2.ui.theme.Dark200
import com.example.jokeappv2.ui.theme.Red200

@Preview()
@Composable
fun jokeCard() {
    val joke = Joke("type", "the setup joke...", "punchline", 1)
    val selectedJoke : (Joke) -> Unit = {}
    val shape = RoundedCornerShape(8.dp)
    Row(
        modifier = Modifier
            .padding(16.dp)
            .background(Red200, shape=shape)
            .defaultMinSize(minHeight = 200.dp)
            .fillMaxWidth()
            .clickable(onClick = { selectedJoke(joke) }),


    ) {
        Column () {


            Text(
                text = "Joke n°${joke.id}",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(16.dp),
                color= Dark200,
            )
            Text(
                text = joke.setup,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .clickable(onClick = { selectedJoke(joke) }),
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}