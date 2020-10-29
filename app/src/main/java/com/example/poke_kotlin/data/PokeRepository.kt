package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults
import com.example.poke_kotlin.data.model.Pokemon
import com.example.poke_kotlin.data.model.Specie
import com.example.poke_kotlin.data.model.TypeDetail

class PokeRepository(private val service: PokeService) {

    suspend fun getAllPokemons(page: String): PokeResults {
        return service.getAllPokemons(page = page)
    }

    suspend fun getSinglePokemon(query: String): Pokemon {
        return service.getSinglePokemon(query)
    }

    suspend fun getType(type: String): TypeDetail {
        return service.getType(type)
    }

    suspend fun getSpecie(type: String): Specie {
        return service.getSpecie(type)
    }
}