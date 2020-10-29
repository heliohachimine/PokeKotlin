package com.example.poke_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class DamageRelations(
    @SerializedName("double_damage_from") val doubleDamageFrom: List<Link>,
    @SerializedName("double_damage_to") val doubleDamageTo: List<Link>,
    @SerializedName("half_damage_from") val halfDamageFrom: List<Link>,
    @SerializedName("half_damage_to") val halfDamageTo: List<Link>,
    @SerializedName("no_damage_from") val noDamageFrom: List<Link>,
    @SerializedName("no_damage_to") val noDamageTo: List<Link>
)

data class TypeDetail (
    @SerializedName("damage_relations") val relations: DamageRelations
)