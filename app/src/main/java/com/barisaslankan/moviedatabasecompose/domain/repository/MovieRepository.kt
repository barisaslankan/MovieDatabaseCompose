package com.barisaslankan.moviedatabasecompose.domain.repository

import com.barisaslankan.moviedatabasecompose.data.remote.dto.MovieDetailsDTO
import com.barisaslankan.moviedatabasecompose.data.remote.dto.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(searchString : String) : MoviesDTO

    suspend fun getMovieDetails(imdbID : String) : MovieDetailsDTO

}