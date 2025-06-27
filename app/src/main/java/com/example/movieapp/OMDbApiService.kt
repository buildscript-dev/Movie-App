package com.example.movieapp

import com.example.movieapp.model.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDbApiService {

    @GET("/")
    suspend fun searchMovies(
        @Query("s") query: String,
        @Query("apikey") apiKey: String
    ): MovieSearchResponse
}
