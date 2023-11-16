package com.example.imdbapimvvm.di

import com.example.imdbapimvvm.domain.api.MoviesInteractor
import com.example.imdbapimvvm.domain.impl.MoviesInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<MoviesInteractor> {
        MoviesInteractorImpl(get())
    }
}