package com.ex

import com.example.jokeappv2.Repository


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import api.Joke
import api.JokeApi
import com.example.jokeappv2.Resource
import com.example.jokeappv2.ui.theme.JokeAppV2Theme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var res : String? = ""
        val repo = Repository()
        var list :List<Joke>? = listOf()

        //when
        runBlocking {
            launch {
                when (val resource = repo.getJokesData()) {
                    is Resource.Success -> {
                        list = resource.data
                    }
                    is Resource.Error -> {
                        res = "Error: ${resource.message}"
                    }

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
                    list?.let {
                        Column {
                            for (joke in list!!) {

                                Greeting("${joke.setup}...${joke.punchline}")
                                Spacer(modifier = Modifier.height(20.dp))

                            }
                        }
                    }

                    if (res?.length!! > 0)
                        GreetingDot(str = res)
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