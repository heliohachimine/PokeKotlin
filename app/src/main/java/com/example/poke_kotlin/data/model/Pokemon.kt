package com.example.poke_kotlin.data.model

data class Pokemon(
    val id: String,
    val name: String,
    val url: String,
    val weight: String,
    val sprites: SpriteResult,
    val types: List<TypeResult>
)