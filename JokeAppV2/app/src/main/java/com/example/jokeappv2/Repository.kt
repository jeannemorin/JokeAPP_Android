package com.example.jokeappv2

import api.Joke
import api.JokeApi

class Repository {

    suspend fun getJokeData(): Resource<Joke> {
        return try {
            Resource.Success(
                data = JokeApi.retrofitService.getJoke()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    suspend fun getJokesData(): Resource<List<Joke>> {
        return try {
            Resource.Success(
                data = JokeApi.retrofitService.getJokes()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}

