package com.example.movieapp.model

import MovieRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val repo = MovieRepository()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

init {
    loadDefaultMovies()
}

    fun loadDefaultMovies() {
        viewModelScope.launch {
            val defaultMovies = repo.searchMovies("Avengers", "bfa21f1a")
            _movies.value = defaultMovies
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
//                _movies.value = repo.searchMovies(query, "https://www.omdbapi.com/?i=tt3896198&apikey=bfa21f1a")
                _movies.value = repo.searchMovies(query, "bfa21f1a")
            } catch (e: Exception) {
                Log.e("MovieVM", "Error: ${e.message}")
            }
        }
    }
}
