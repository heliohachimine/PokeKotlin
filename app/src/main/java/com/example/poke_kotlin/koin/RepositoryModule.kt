package com.example.poke_kotlin.koin

import com.example.poke_kotlin.data.PokeRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        PokeRepository(
            service = get()
        )
    }
}