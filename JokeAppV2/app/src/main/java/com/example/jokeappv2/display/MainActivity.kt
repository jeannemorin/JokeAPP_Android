package com.example.jokeappv2.display

import com.example.jokeappv2.Repository


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jokeappv2.AppNavigation
import com.example.jokeappv2.JokeViewModel
import com.example.jokeappv2.model.Joke
import com.example.jokeappv2.Resource
import com.example.jokeappv2.ui.theme.JokeAppV2Theme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadJokes()
        //setContent { AppNavigation() }


        setContent {
            JokeAppV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    viewModel.state.jokeData.let {
                        Column {
                            for (joke in viewModel.state.jokeData!!) {

                                Greeting("${joke.setup}...${joke.punchline}")
                                Spacer(modifier = Modifier.height(20.dp))

                            }
                        }
                    }

                    viewModel.state.error.let {
                        GreetingDot(str = viewModel.state.error)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(str: String) {
    Text(text = "$str")
}

@Composable
fun GreetingDot(str: String?) {
    Text(text = "$str")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokeAppV2Theme {
        //Greeting()
    }
}