package com.example.jokeappv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import api.JokeApi
import com.example.jokeappv2.ui.theme.JokeAppV2Theme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val res = mutableListOf<String>()

        //when
        runBlocking {
            launch {
                try {
                    val joke = JokeApi.retrofitService.getJoke()
                    res.add("Success: ${joke.setup}..... ${joke.punchline}")

                } catch (e: Exception) {
                    res.add("Failure: ${e.message}")
                }
            }
        }
        setContent {
            JokeAppV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(res)
                }
            }
        }
    }
}

@Composable
fun Greeting(str: MutableList<String>) {
    Text(text = "$str")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokeAppV2Theme {
        //Greeting()
    }
}