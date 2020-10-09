package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.PokeResults
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("offset") offset: String,
        @Query("limit") limit: String
    ): PokeResults
}