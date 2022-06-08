package com.egor.memes.di

import com.egor.memes.data.repository.MemesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MemesRepository(get()) }
}