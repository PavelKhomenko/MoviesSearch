package com.example.imdbapimvvm.data


import com.example.imdbapimvvm.LocalStorage
import com.example.imdbapimvvm.data.converter.MovieCastConverter
import com.example.imdbapimvvm.data.dto.cast.MovieCastRequest
import com.example.imdbapimvvm.data.dto.cast.MovieCastResponse
import com.example.imdbapimvvm.data.dto.details.MovieDetailsRequest
import com.example.imdbapimvvm.data.dto.details.MovieDetailsResponse
import com.example.imdbapimvvm.data.dto.search.MoviesSearchRequest
import com.example.imdbapimvvm.data.dto.search.MoviesSearchResponse
import com.example.imdbapimvvm.domain.api.MoviesRepository
import com.example.imdbapimvvm.domain.models.Movie
import com.example.imdbapimvvm.domain.models.MovieCast
import com.example.imdbapimvvm.domain.models.MovieDetails
import com.example.imdbapimvvm.util.Resource

class MoviesRepositoryImpl(
    private val networkClient: NetworkClient,
    // Добавили конвертер
    private val movieCastConverter: MovieCastConverter,
    private val localStorage: LocalStorage
) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }

            200 -> {
                val stored = localStorage.getSavedFavorites()

                Resource.Success((response as MoviesSearchResponse).results.map {
                    Movie(
                        it.id,
                        it.resultType,
                        it.image,
                        it.title,
                        it.description,
                        inFavorite = stored.contains(it.id)
                    )
                })
            }

            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }

    override fun getMovieDetails(movieId: String): Resource<MovieDetails> {
        val response = networkClient.doRequest(MovieDetailsRequest(movieId))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }

            200 -> {
                with(response as MovieDetailsResponse) {
                    Resource.Success(
                        MovieDetails(
                            id ?: "",
                            title ?: "",
                            imDbRating ?: "",
                            year ?: "",
                            countries ?: "",
                            genres ?: "",
                            directors ?: "",
                            writers ?: "",
                            stars ?: "",
                            plot ?: ""
                        )
                    )
                }
            }

            else -> {
                Resource.Error("Ошибка сервера")

            }
        }
    }

    // Добавили новый метод для получения состава участников
    override fun getMovieCast(movieId: String): Resource<MovieCast> {
        // Поменяли объект dto на нужный Request-объект
        val response = networkClient.doRequest(MovieCastRequest(movieId))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }

            200 -> {
                // Осталось написать конвертацию!
                // используем конвертер вместо
                // прямой конвертации
                Resource.Success(
                    data = movieCastConverter.convert(response as MovieCastResponse)
                )
            }

            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }

    override fun addMovieToFavorites(movie: Movie) {
        localStorage.addToFavorites(movie.id)
    }

    override fun removeMovieFromFavorites(movie: Movie) {
        localStorage.removeFromFavorites(movie.id)
    }
}