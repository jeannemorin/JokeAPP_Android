package api

import com.example.jokeappv2.model.Joke
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://official-joke-api.appspot.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface JokeApiService {
    @GET("random_ten")
    suspend fun getJokes(): List<Joke>

    @GET("random_joke")
    suspend fun getJoke(): Joke
}

object JokeApi {
    val retrofitService : JokeApiService by lazy {
        retrofit.create(JokeApiService::class.java) }
}