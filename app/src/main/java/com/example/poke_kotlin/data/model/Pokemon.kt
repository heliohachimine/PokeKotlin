package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: String,
    val name: String,
    val url: String,
    val weight: String,
    val sprites: SpriteResult,
    val types: List<TypeResult>,
    val height: String,
    @SerializedName("base_experience") val baseExperience: String
)