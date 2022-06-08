package com.egor.memes

import android.app.Application
import com.egor.memes.di.networkModule
import com.egor.memes.di.repositoryModule
import com.egor.memes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}