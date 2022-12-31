package com.example.jokeappv2.display

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.jokeappv2.model.Joke

@Composable
fun JokesList (jokes : List<Joke>, selectedJoke : (Int) -> Unit) {

    Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
            for (joke in jokes) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable(onClick = { selectedJoke(joke.id) })
                        .clip(RoundedCornerShape(8.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = joke.setup,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(start = 20.dp).clickable(onClick = { selectedJoke(joke.id) })
                    )
                }
            }

        }

}
