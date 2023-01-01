package com.example.jokeappv2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeappv2.data.Resource
import com.example.jokeappv2.model.Joke
import com.example.jokeappv2.network.Repository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class JokeViewModel : ViewModel() {

    val repository = Repository()
    var state by mutableStateOf(JokesState())

    fun loadJokes() {
        viewModelScope.launch {
                when (val result = repository.getJokesData()) {
                    is Resource.Success -> {
                        state = state.copy(
                            jokeData = result.data,
                            selectedJoke = null,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            jokeData = null,
                            selectedJoke = null,
                            isLoading = false,
                            error = result.message
                        )
                    }

                }

            }
    }

    fun selectJoke(selectedJoke : Joke) {

        state = state.copy(
            jokeData = state.jokeData,
            selectedJoke = selectedJoke,
            isLoading = false,
            error = null
        )
    }
}

data class JokesState(
    val jokeData: List<Joke>? = null,
    val selectedJoke: Joke? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)