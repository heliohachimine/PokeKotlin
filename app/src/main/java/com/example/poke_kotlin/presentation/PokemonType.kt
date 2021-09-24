package com.example.poke_kotlin.presentation

import com.example.poke_kotlin.R

enum class PokemonType(
    val typeName: String,
    val color: Int,
    val backgroundColor: Int,
    val backgroundCard: Int,
    val icon: Int
    ) {
    BUG(
        typeName = "bug",
        color = R.color.typeBug,
        backgroundColor = R.color.backgroundTypeBug,
        backgroundCard = R.drawable.background_type_bug,
        icon = R.drawable.ic_bug
    ),
    DARK(
        typeName = "dark",
        color = R.color.typeDark,
        backgroundColor = R.color.backgroundTypeDark,
        backgroundCard = R.drawable.background_type_dark,
        icon = R.drawable.ic_dark
    ),
    DRAGON(
        typeName = "dragon",
        color = R.color.typeDragon,
        backgroundColor = R.color.backgroundTypeDragon,
        backgroundCard = R.drawable.background_type_dragon,
        icon = R.drawable.ic_dragon
    ),
    ELECTRIC(
        typeName = "electric",
        color = R.color.typeElectric,
        backgroundColor = R.color.backgroundTypeElectric,
        backgroundCard = R.drawable.background_type_electric,
        icon = R.drawable.ic_electric
    ),
    FAIRY(
        typeName = "fairy",
        color = R.color.typeFairy,
        backgroundColor = R.color.backgroundTypeFairy,
        backgroundCard = R.drawable.background_type_fairy,
        icon = R.drawable.ic_fairy
    ),
    FIGHTING(
        typeName = "fighting",
        color = R.color.typeFighting,
        backgroundColor =  R.color.backgroundTypeFighting,
        backgroundCard = R.drawable.background_type_fighting,
        icon = R.drawable.ic_fighting
    ),
    FIRE(
        typeName = "fire",
        color = R.color.typeFire,
        backgroundColor = R.color.backgroundTypeFire,
        backgroundCard = R.drawable.background_type_fire,
        icon = R.drawable.ic_fire
    ),
    FLYING(
        typeName = "flying",
        color = R.color.typeFlying,
        backgroundColor = R.color.backgroundTypeFlying,
        backgroundCard = R.drawable.background_type_flying,
        icon = R.drawable.ic_flying
    ),
    GHOST(
        typeName = "ghost",
        color = R.color.typeGhost,
        backgroundColor = R.color.backgroundTypeGhost,
        backgroundCard = R.drawable.background_type_ghost,
        icon = R.drawable.ic_ghost
    ),
    GRASS(
        typeName = "grass",
        color = R.color.typeGrass,
        backgroundColor = R.color.backgroundTypeGrass,
        backgroundCard = R.drawable.background_type_grass,
        icon = R.drawable.ic_grass
    ),
    GROUND(
        typeName = "ground",
        color = R.color.typeGround,
        backgroundColor = R.color.backgroundTypeGround,
        backgroundCard = R.drawable.background_type_ground,
        icon = R.drawable.ic_ground
    ),
    ICE(
        typeName = "ice",
        color = R.color.typeIce,
        backgroundColor = R.color.backgroundTypeIce,
        backgroundCard = R.drawable.background_type_ice,
        icon = R.drawable.ic_ice
    ),
    NORMAL(
        typeName = "normal",
        color = R.color.typeNormal,
        backgroundColor = R.color.backgroundTypeNormal,
        backgroundCard = R.drawable.background_type_normal,
        icon = R.drawable.ic_normal
    ),
    POISON(
        typeName = "poison",
        color = R.color.typePoison,
        backgroundColor = R.color.backgroundTypePoison,
        backgroundCard = R.drawable.background_type_poison,
        icon = R.drawable.ic_poison
    ),
    PSYCHIC(
        typeName = "psychic",
        color = R.color.typePsychic,
        backgroundColor = R.color.backgroundTypePsychic,
        backgroundCard = R.drawable.background_type_psychic,
        icon = R.drawable.ic_psychic
    ),
    ROCK(
        typeName = "rock",
        color = R.color.typeRock,
        backgroundColor = R.color.backgroundTypeRock,
        backgroundCard = R.drawable.background_type_rock,
        icon = R.drawable.ic_rock
    ),
    STEEL(
        typeName = "steel",
        color = R.color.typeSteel,
        backgroundColor = R.color.backgroundTypeSteel,
        backgroundCard = R.drawable.background_type_steel,
        icon = R.drawable.ic_steel
    ),
    WATER(
        typeName = "water",
        color = R.color.typeWater,
        backgroundColor = R.color.backgroundTypeWater,
        backgroundCard = R.drawable.background_type_water,
        icon = R.drawable.ic_water
    ),
    UNKNOWN(
        typeName = "unknown",
        color = R.color.typeNormal,
        backgroundColor = R.color.backgroundTypeNormal,
        backgroundCard = R.drawable.background_type_normal,
        icon = R.drawable.ic_normal
    )
}