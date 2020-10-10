package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults
import com.example.poke_kotlin.data.model.Pokemon

class PokeRepository(private val service: PokeService) {

    suspend fun getAllPokemons(offset: String, limit: String): PokeResults {
        return service.getAllPokemons(offset, limit)
    }

    suspend fun getSinglePokemon(name: String): Pokemon {
        return service.getSinglePokemon(name)
    }
}