package com.barisaslankan.moviedatabasecompose.presentation.movies

import com.barisaslankan.moviedatabasecompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movieList : List<Movie> = emptyList(),
    val errorMessage : String = "",
    val search : String = "batman"
)
