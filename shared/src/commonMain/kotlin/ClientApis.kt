import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ClientApis {
    val httpClient = httpClient() {
        install(Logging)
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun searchForMovieWithTitle(text: String) {
        return httpClient.get("https://www.google.com/") {
//            parameter("s", text)
//            parameter("apikey", API_KEY)
        }.body()
    }

    suspend fun getTest() =httpClient.get("https://ktor.io/docs/welcome.html")
}