package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class EvolutionResult(
    @SerializedName("chain") val chain: ChainEvolution
)

data class EvolutionDetails(
    val gender: String,
    @SerializedName("min_level") val minLevel: String
)

data class ChainEvolution(
    @SerializedName("evolution_details") val evolutionDetails: List<EvolutionDetails>,
    @SerializedName("evolves_to") val evolveTo: List<ChainEvolution>,
    @SerializedName("species") val species: Link

)
