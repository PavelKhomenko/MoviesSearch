package com.example.imdbapimvvm.presentation.details

import com.example.imdbapimvvm.domain.models.MovieDetails

sealed interface AboutState {

    data class Content(
        val movie: MovieDetails
    ) : AboutState

    data class Error(
        val message: String
    ) : AboutState

}