package api
import com.squareup.moshi.Json

data class Joke(
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "setup")
    val setup: String,
    @field:Json(name = "punchline")
    val punchline: String,
    @field:Json(name = "id")
    val id: Int
)