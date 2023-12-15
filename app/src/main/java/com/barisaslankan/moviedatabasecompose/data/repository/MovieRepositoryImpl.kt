package com.barisaslankan.moviedatabasecompose.data.repository

import com.barisaslankan.moviedatabasecompose.data.remote.MoviesAPI
import com.barisaslankan.moviedatabasecompose.data.remote.dto.MovieDetailsDTO
import com.barisaslankan.moviedatabasecompose.data.remote.dto.MoviesDTO
import com.barisaslankan.moviedatabasecompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val moviesAPI: MoviesAPI) : MovieRepository {

    override suspend fun getMovies(searchString: String): MoviesDTO {
        return moviesAPI.getMovies(searchString)
    }

    override suspend fun getMovieDetails(imdbID: String): MovieDetailsDTO {
        return moviesAPI.getMovieDetails(imdbID)
    }

}