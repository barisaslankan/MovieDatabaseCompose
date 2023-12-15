package com.barisaslankan.moviedatabasecompose.data.di

import com.barisaslankan.moviedatabasecompose.data.remote.MoviesAPI
import com.barisaslankan.moviedatabasecompose.data.repository.MovieRepositoryImpl
import com.barisaslankan.moviedatabasecompose.domain.repository.MovieRepository
import com.barisaslankan.moviedatabasecompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesAPI {
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(MoviesAPI::class.java)
    }

    @Provides
    fun provideMovieRepository(api : MoviesAPI) : MovieRepository{
        return MovieRepositoryImpl(api)
    }
}