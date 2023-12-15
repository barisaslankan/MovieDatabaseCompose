package com.barisaslankan.moviedatabasecompose.presentation.movie_detail

import com.barisaslankan.moviedatabasecompose.domain.model.Movie
import com.barisaslankan.moviedatabasecompose.domain.model.MovieDetails

data class MovieDetailsState(
    val isLoading : Boolean = false,
    val movie : MovieDetails? = null,
    val errorMessage : String = ""
)
