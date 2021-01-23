package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)