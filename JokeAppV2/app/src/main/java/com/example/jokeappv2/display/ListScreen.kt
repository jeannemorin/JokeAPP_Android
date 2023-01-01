package com.example.jokeappv2.display

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.jokeappv2.JokeViewModel
import com.example.jokeappv2.model.Joke

@Composable
fun ListScreen(vm : JokeViewModel, selectedJoke : (Joke) -> Unit) {

    Column() {

        vm.state.jokeData?.let { JokesList(jokes = it, selectedJoke = selectedJoke, modifier= Modifier.weight(1f)) }
        Spacer(modifier = Modifier.height(20.dp))
        reloadButton(vm = vm)
    }
}

@Composable
fun JokesList (jokes : List<Joke>, selectedJoke : (Joke) -> Unit, modifier : Modifier) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = jokes,
            itemContent = {
                JokeCard(joke = it, selectedJoke)
            })
    }
}

@Composable
fun JokeCard (joke: Joke, selectedJoke: (Joke) -> Unit) {

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = { selectedJoke(joke) })
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = joke.setup,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(start = 20.dp)
                .clickable(onClick = { selectedJoke(joke) })
        )
    }
}

@Composable
fun reloadButton(vm: JokeViewModel) {

    IconButton(onClick = { vm.loadJokes() }) {
        Column() {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null
            )

            Text("Load 10 more jokes")

        }

    }


}
