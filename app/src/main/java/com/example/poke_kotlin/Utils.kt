package com.example.poke_kotlin

class Utils {
    companion object{
        fun formatPokeNumber(number: String): String {
            return "#$number"
        }

        fun formatHeight(height: String): String {
            val value = height.toDouble()
            return (value/10).toString() + "m"
        }

        fun formatWeight(weight: String): String {
            val value = weight.toDouble()
            return (value/10).toString() + "kg"
        }

        fun getColorByPokemonType(type: String?): Int {
            var color = 0
            when (type) {
                "bug" -> color = R.color.backgroundTypeBug
                "dark" -> color =  R.color.backgroundTypeDark
                "dragon" -> color = R.color.backgroundTypeDragon
                "electric" -> color = R.color.backgroundTypeElectric
                "fairy" -> color = R.color.backgroundTypeFairy
                "fighting" -> color = R.color.backgroundTypeFighting
                "fire" -> color = R.color.backgroundTypeFire
                "flying" -> color = R.color.backgroundTypeFlying
                "ghost" -> color = R.color.backgroundTypeGhost
                "grass" -> color = R.color.backgroundTypeGrass
                "ground" -> color = R.color.backgroundTypeGround
                "ice" -> color = R.color.backgroundTypeIce
                "normal" -> color = R.color.backgroundTypeNormal
                "poison" -> color = R.color.backgroundTypePoison
                "psychic" -> color = R.color.backgroundTypePsychic
                "rock" -> color = R.color.backgroundTypeRock
                "steel" -> color = R.color.backgroundTypeSteel
                "water" -> color = R.color.backgroundTypeWater
            }
            return color
        }
    }
}