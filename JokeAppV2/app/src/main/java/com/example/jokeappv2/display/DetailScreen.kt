package com.example.jokeappv2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jokeappv2.display.JokeCard
import com.example.jokeappv2.display.ui.theme.Blue200
import com.example.jokeappv2.display.ui.theme.Dark200
import com.example.jokeappv2.display.ui.theme.Grey200
import com.example.jokeappv2.display.ui.theme.Red200
import com.example.jokeappv2.model.Joke

@Composable
fun JokeDetails (joke: Joke, navigateUp: () -> Unit) {

    Column() {
        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        JokeCard(joke = joke, selectedJoke = {} )
        val shape = RoundedCornerShape(8.dp)
        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Blue200, shape=shape)
                .fillMaxWidth()
            ) {
            Column (
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = joke.punchline,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(start = 20.dp),
                    fontSize = 20.sp,
                    color = Dark200,
                )
            }
        }
    }
    
}
