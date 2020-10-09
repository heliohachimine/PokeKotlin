package com.example.poke_kotlin

import android.app.Application
import com.example.poke_kotlin.koin.appModule
import com.example.poke_kotlin.koin.repositoryModule
import com.example.poke_kotlin.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@PokeApplication)
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    appModule
                )
            )
        }
    }

    companion object {
        @get:Synchronized
        var instance: PokeApplication? = null
            private set
    }
}