package com.barisaslankan.moviedatabasecompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisaslankan.moviedatabasecompose.domain.use_case.get_movies.GetMoviesUseCase
import com.barisaslankan.moviedatabasecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel(){

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state : State<MoviesState> = _state

    private var job : Job? = null

    init {
        getMovies("Batman")
    }

    fun getMovies(search : String){

        job?.cancel()

        job = getMoviesUseCase.executeGetMovies(search).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MoviesState(movieList = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MoviesState(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)

    }

    fun onEvent(event : MoviesEvent){
        when (event){
            is MoviesEvent.Search -> getMovies(event.searchString)
        }
    }

}
