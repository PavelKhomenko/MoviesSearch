package com.example.imdbapimvvm.domain.api

import com.example.imdbapimvvm.domain.models.Movie
import com.example.imdbapimvvm.domain.models.MovieCast
import com.example.imdbapimvvm.domain.models.MovieDetails
import com.example.imdbapimvvm.util.Resource

interface MoviesRepository {

    fun searchMovies(expression: String): Resource<List<Movie>>
    fun getMovieDetails(movieId: String): Resource<MovieDetails>
    fun getMovieCast(movieId: String): Resource<MovieCast>

    fun addMovieToFavorites(movie: Movie)
    fun removeMovieFromFavorites(movie: Movie)
}