package com.example.jokeappv2.display

import android.graphics.Color.rgb
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jokeappv2.display.ui.theme.Highlight
import com.example.jokeappv2.display.ui.theme.Paragraph
import com.example.jokeappv2.model.Joke



@Composable
fun JokeCard(joke: Joke, selectedJoke: (Joke) -> Unit) {
    val shape = RoundedCornerShape(8.dp)

    Row (
        modifier = Modifier
            .background(Highlight, shape=shape)
            .defaultMinSize(minHeight = 100.dp)
            .fillMaxWidth()
            .clickable(onClick = { selectedJoke(joke) }),


    ) {
        Column (
            modifier = Modifier
                .padding(20.dp)
                ) {


            Text(
                text = "Joke n°${joke.id}",
                style = MaterialTheme.typography.body1,
                fontSize = 16.sp,
                color= Paragraph,
            )
            Text(
                text = joke.setup,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .clickable(onClick = { selectedJoke(joke) }),
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}