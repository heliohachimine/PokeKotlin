package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class PokeResults(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: ArrayList<Pokemon>
)