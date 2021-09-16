package com.example.poke_kotlin.data

import com.example.poke_kotlin.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("offset")page: String,
        @Query("limit")limit: String
    ): PokeResults

    @GET("pokemon/{name}")
    suspend fun getSinglePokemon(
        @Path("name") name: String
    ): Pokemon

    @GET("type/{id}")
    suspend fun getType(
        @Path("id") id: String
    ): TypeDetail

    @GET("pokemon-species/{id}")
    suspend fun getSpecie(
        @Path("id") id: String
    ): Specie

    @GET("evolution-chain/{id}")
    suspend fun getEvolutions(
        @Path("id") id: String
    ): EvolutionResult
}