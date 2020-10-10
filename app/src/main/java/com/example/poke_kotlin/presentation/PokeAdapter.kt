package com.example.poke_kotlin.presentation

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.android.synthetic.main.layout_type.view.*

class PokeAdapter : RecyclerView.Adapter<GenreViewHolder>() {

    private var pokemons: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_pokemon, parent, false)
        return GenreViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = this.pokemons.size

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(pokemons[position])
        holder.item.setOnClickListener {
        }
    }

    fun setList(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }
}

class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val item: ConstraintLayout = itemView.findViewById(R.id.frame)
    val card: ConstraintLayout = itemView.findViewById(R.id.poke_card)
    val id: TextView = itemView.findViewById(R.id.poke_id)
    val name: TextView = itemView.findViewById(R.id.poke_name)
    val image: ImageView = item.findViewById(R.id.poke_image)
    val type1: TypeComponent = itemView.findViewById(R.id.type_slot_1)

    fun bind(pokemon: Pokemon) {
        id.text = Utils().formatPokeNumber(pokemon.id)
        name.text = pokemon.name
        type1.setType(pokemon.types[0].type.name)
        setupType(pokemon.types[0].type.name)
        Glide.with(itemView.context).load(pokemon.sprites.other.image.url)
            .into(image)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupType(type: String) {
        when(type) {
            "bug" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeBug))
            "dark" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeDark))
            "dragon" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeDragon))
            "eletric" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeEletric))
            "fairy" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeFairy))
            "fighting" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeFighting))
            "fire" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeFire))
            "flying" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeFlying))
            "ghost" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeGhost))
            "grass" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeGrass))
            "ground" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeGround))
            "ice" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeIce))
            "normal" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeNormal))
            "poison" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypePoison))
            "psychic" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypePsychic))
            "rock" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeRock))
            "steel" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeSteel))
            "water" -> card.setBackgroundColor(itemView.context.getColor(R.color.backgroundTypeWater))
        }
    }
}
