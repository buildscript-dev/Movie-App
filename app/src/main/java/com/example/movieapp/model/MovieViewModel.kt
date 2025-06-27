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

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                _movies.value = repo.searchMovies(query, "bfa21f1a")
            } catch (e: Exception) {
                Log.e("MovieVM", "Error: ${e.message}")
            }
        }
    }
}
