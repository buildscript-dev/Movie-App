import com.example.movieapp.RetrofitInstance
import com.example.movieapp.model.Movie


class MovieRepository {
    private val api = RetrofitInstance.api

    suspend fun searchMovies(query: String, apiKey: String): List<Movie> {
        val response = api.searchMovies(query, apiKey)
        return response.search ?: emptyList()
    }
}
