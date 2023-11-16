package com.example.imdbapimvvm.presentation.cast

import com.example.imdbapimvvm.domain.models.MovieCastPerson

sealed interface MoviesCastRVItem {

    data class HeaderItem(
        val headerText: String,
    ) : MoviesCastRVItem

    data class PersonItem(
        val data: MovieCastPerson,
    ) : MoviesCastRVItem

}