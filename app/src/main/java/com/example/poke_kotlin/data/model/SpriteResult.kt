package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class SpriteResult(
    @SerializedName("other") val other: Image
)

data class Image(
    @SerializedName("official-artwork")val image: Url
)

data class Url(
    @SerializedName("front_default") val url: String
)