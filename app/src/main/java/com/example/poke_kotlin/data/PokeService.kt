package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults
import com.example.poke_kotlin.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("offset")page: String
    ): PokeResults

    @GET("pokemon/{name}")
    suspend fun getSinglePokemon(
        @Path("name") name: String
    ): Pokemon
}