package com.barisaslankan.moviedatabasecompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisaslankan.moviedatabasecompose.domain.use_case.get_movie_detail.GetMovieDetailsUseCase
import com.barisaslankan.moviedatabasecompose.util.Constants.IMDB_ID
import com.barisaslankan.moviedatabasecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<MovieDetailsState>(MovieDetailsState())
    val state : State<MovieDetailsState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId:String){
        getMovieDetailsUseCase.executeGetMovieDetails(imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailsState(movie = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailsState(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}