package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class Specie(
    @SerializedName("base_happiness") val baseHappiness: String,
    @SerializedName("capture_rate") val captureRate: String,
    @SerializedName("growth_rate") val growthRate: Link
)