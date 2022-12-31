package com.example.jokeappv2

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import com.example.jokeappv2.model.Joke

@Composable
fun JokeDetails (joke: Joke, navigateUp: () -> Unit) {

    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null
        )
    }

    Column() {
        Text("JOKE SETUP")
        Text("JOKE PUNCHLINE")
    }

    
}
