package com.barisaslankan.moviedatabasecompose.domain.use_case.get_movie_detail

import com.barisaslankan.moviedatabasecompose.data.remote.dto.toMovieDetails
import com.barisaslankan.moviedatabasecompose.domain.model.MovieDetails
import com.barisaslankan.moviedatabasecompose.domain.repository.MovieRepository
import com.barisaslankan.moviedatabasecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetails>> = flow {

        try {
            emit(Resource.Loading())
            val movieDetails = repository.getMovieDetails(imdbId).toMovieDetails()
            emit(Resource.Success(movieDetails))
        }catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}