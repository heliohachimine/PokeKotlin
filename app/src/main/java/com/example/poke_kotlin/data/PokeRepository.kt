package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults

class PokeRepository(private val service: PokeService) {

    suspend fun getAllPokemons(offset: String, limit: String): PokeResults {
        return service.getAllPokemons(offset, limit)
    }
}