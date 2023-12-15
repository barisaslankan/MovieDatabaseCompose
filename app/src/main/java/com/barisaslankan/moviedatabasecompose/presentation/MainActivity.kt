package com.barisaslankan.moviedatabasecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.barisaslankan.moviedatabasecompose.presentation.movie_detail.views.MovieDetailsScreen
import com.barisaslankan.moviedatabasecompose.presentation.movies.views.MoviesScreen
import com.barisaslankan.moviedatabasecompose.presentation.ui.theme.MovieDatabaseComposeTheme
import com.barisaslankan.moviedatabasecompose.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDatabaseComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MoviesScreen.route){

                        composable(Screen.MoviesScreen.route){
                            MoviesScreen(navController = navController)
                        }

                        composable(Screen.MovieDetailsScreen.route+"/{${IMDB_ID}}"){
                            MovieDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
