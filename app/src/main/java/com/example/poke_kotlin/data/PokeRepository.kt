package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults
import com.example.poke_kotlin.data.model.Pokemon

class PokeRepository(private val service: PokeService) {

    suspend fun getAllPokemons(page: String): PokeResults {
        return service.getAllPokemons(page = page)
    }

    suspend fun getSinglePokemon(name: String): Pokemon {
        return service.getSinglePokemon(name)
    }
}