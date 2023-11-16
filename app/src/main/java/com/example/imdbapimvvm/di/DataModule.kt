package com.example.imdbapimvvm.di

import android.content.Context
import com.example.imbdapi.data.network.IMDbApiService
import com.example.imbdapi.data.network.RetrofitNetworkClient
import com.example.imdbapimvvm.LocalStorage
import com.example.imdbapimvvm.data.NetworkClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<IMDbApiService> {
        val imdbBaseUrl = "https://imdb-api.com"

        Retrofit.Builder()
            .baseUrl(imdbBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMDbApiService::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get(), androidContext())
    }

    single<LocalStorage> {
        LocalStorage(get())
    }
    single {
        androidContext()
            .getSharedPreferences("local_storage", Context.MODE_PRIVATE )
    }
}