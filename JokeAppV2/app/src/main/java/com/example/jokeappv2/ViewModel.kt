package com.example.jokeappv2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeappv2.model.Joke
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class JokeViewModel : ViewModel() {

    val repository = Repository()
    var state by mutableStateOf(JokesState())

    fun loadJokes() {
        runBlocking {
            launch {
                when (val result = repository.getJokesData()) {
                    is Resource.Success -> {
                        state = state.copy(
                            jokeData = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            jokeData = null,
                            isLoading = false,
                            error = result.message
                        )
                    }

                }

            }
        }
    }
}

data class JokesState(
    val jokeData: List<Joke>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)