package com.barisaslankan.moviedatabasecompose.presentation

sealed class Screen(val route : String) {
    data object MoviesScreen : Screen("movies_screen")
    data object MovieDetailsScreen : Screen("movie_details_screen")
}
