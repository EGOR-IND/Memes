package com.egor.memes.di

import com.egor.memes.data.service.MemesApiService
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideMemeApiService() }
}

private fun provideMemeApiService(): MemesApiService = Retrofit.Builder()
    .baseUrl("https://api.imgflip.com/")
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .build()
    .create(MemesApiService::class.java)