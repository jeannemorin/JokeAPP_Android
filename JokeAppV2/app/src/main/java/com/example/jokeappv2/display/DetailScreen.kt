package com.example.jokeappv2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jokeappv2.model.Joke

@Composable
fun JokeDetails (navigateUp: () -> Unit, joke : Joke) {

    Column() {

        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column() {
            Text(joke.setup)
            Text(joke.punchline)
        }
    }
    
}
