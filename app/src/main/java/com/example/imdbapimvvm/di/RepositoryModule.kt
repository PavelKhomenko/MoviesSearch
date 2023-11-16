package com.example.imdbapimvvm.di

import com.example.imdbapimvvm.data.MoviesRepositoryImpl
import com.example.imdbapimvvm.data.converter.MovieCastConverter
import com.example.imdbapimvvm.domain.api.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {

    // Добавили фабрику для конвертера
    factory { MovieCastConverter() }

    single<MoviesRepository> {
        // Добавили ещё один `get()`, чтобы количество
        // аргументов совпадало
        MoviesRepositoryImpl(get(), get(), get())
    }

}

