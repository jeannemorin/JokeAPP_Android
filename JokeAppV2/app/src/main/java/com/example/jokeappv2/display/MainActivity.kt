package com.example.jokeappv2.display


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jokeappv2.AppNavigation
import com.example.jokeappv2.JokeViewModel
import com.example.jokeappv2.display.ui.theme.JokeAppV2Theme

class MainActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadJokes()
        setContent { AppNavigation(vm = viewModel) }
    }
}