package com.example.jokeappv2.display

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jokeappv2.JokeViewModel
import com.example.jokeappv2.display.ui.theme.Main
import com.example.jokeappv2.display.ui.theme.Red200
import com.example.jokeappv2.model.Joke

@Composable
fun ListScreen(vm : JokeViewModel, selectedJoke : (Joke) -> Unit) {

    Column {

        Header()
        vm.state.jokeData?.let { JokesList(jokes = it, selectedJoke = selectedJoke, modifier= Modifier.weight(1f)) }
        reloadButton(vm = vm)
    }
}

@Composable
fun JokesList (jokes : List<Joke>, selectedJoke : (Joke) -> Unit, modifier : Modifier) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
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
fun reloadButton(vm: JokeViewModel) {

    IconButton(
        onClick = { vm.loadJokes() },
        modifier = Modifier
            .background(Red200)
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.Refresh,
                contentDescription = null,
                tint = Main,
            )

            Text(
                fontSize = 20.sp,
                text="Load 10 new jokes",
                modifier = Modifier.padding(start = 10.dp),
                color = Main
            )

        }

    }


}
