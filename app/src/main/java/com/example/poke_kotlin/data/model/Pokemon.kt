package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id") val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("url")val url: String,
    @SerializedName("weight")val weight: String,
    @SerializedName("sprites")val sprites: SpriteResult,
    @SerializedName("types") val types: List<TypeResult>,
    @SerializedName("height") val height: String,
    @SerializedName("base_experience") val baseExperience: String
)