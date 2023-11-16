package com.example.imdbapimvvm.di

import com.example.imdbapimvvm.presentation.cast.MoviesCastViewModel
import com.example.imdbapimvvm.presentation.details.AboutViewModel
import com.example.imdbapimvvm.presentation.movies.MoviesSearchViewModel
import com.example.imdbapimvvm.presentation.poster.PosterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MoviesSearchViewModel(androidContext() as MoviesApplication, get())
    }

    viewModel {(movieId: String) ->
        AboutViewModel(movieId, get())
    }

    viewModel {(posterUrl: String) ->
        PosterViewModel(posterUrl)
    }

    viewModel { (movieId: String) ->
        MoviesCastViewModel(movieId, get())
    }
}