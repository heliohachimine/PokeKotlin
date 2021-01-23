package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class TypeResult (
    @SerializedName("slot")val slot: Int,
    @SerializedName("type") val type: Link
)