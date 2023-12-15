package com.barisaslankan.moviedatabasecompose.data.remote

import com.barisaslankan.moviedatabasecompose.data.remote.dto.MovieDetailsDTO
import com.barisaslankan.moviedatabasecompose.data.remote.dto.MoviesDTO
import com.barisaslankan.moviedatabasecompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDTO

    @GET(".")
    suspend fun getMovieDetails(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailsDTO

}