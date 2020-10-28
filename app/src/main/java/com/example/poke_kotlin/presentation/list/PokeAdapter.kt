package com.example.poke_kotlin.presentation.list

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.data.model.Pokemon
import com.example.poke_kotlin.presentation.TypeComponent
import com.example.poke_kotlin.presentation.detail.DetailActivity

class PokeAdapter : RecyclerView.Adapter<PokeViewHolder>() {

    private var pokemons: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_pokemon, parent, false)
        return PokeViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = this.pokemons.size

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.bind(pokemons[position])
        holder.item.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("item_number", pokemons[position].id)
            intent.putExtra("item_image", pokemons[position].sprites.other.image.url)
            intent.putExtra("item_name", pokemons[position].name)
            intent.putExtra("item_type", pokemons[position].types[0].type.name)
            val sharedElement = holder.image
            sharedElement.transitionName = "POKE_TRANSITION"
            val options = ActivityOptions.makeSceneTransitionAnimation(it.context as Activity, sharedElement, "POKE_TRANSITION" )
            it.context.startActivity(intent, options.toBundle())
        }
    }

    fun setList(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }
}

class PokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val item: ConstraintLayout = itemView.findViewById(R.id.frame)
    val card: ConstraintLayout = itemView.findViewById(R.id.poke_card)
    val id: TextView = itemView.findViewById(R.id.poke_id)
    val name: TextView = itemView.findViewById(R.id.poke_name)
    val image: ImageView = item.findViewById(R.id.poke_image)
    val type1: TypeComponent = itemView.findViewById(R.id.type_slot_1)
    val type2: TypeComponent = itemView.findViewById(R.id.type_slot_2)

    fun bind(pokemon: Pokemon) {
        id.text = Utils().formatPokeNumber(pokemon.id)
        name.text = pokemon.name
        type1.setType(pokemon.types[0].type.name)
        if (pokemon.types.size > 1) {
            type2.visibility = View.VISIBLE
            type2.setType(pokemon.types[1].type.name)
        } else {
            type2.visibility = View.INVISIBLE
        }
        setupBackground(pokemon.types[0].type.name)
        Glide.with(itemView.context).load(pokemon.sprites.other.image.url)
            .into(image)
    }

    private fun setupBackground(type: String) {
        when(type) {
            "bug" -> card.setBackgroundResource(R.drawable.background_card_bug)
            "dark" -> card.setBackgroundResource(R.drawable.background_card_dark)
            "dragon" -> card.setBackgroundResource(R.drawable.background_card_dragon)
            "electric" -> card.setBackgroundResource(R.drawable.background_card_electric)
            "fairy" -> card.setBackgroundResource(R.drawable.background_card_fairy)
            "fighting" -> card.setBackgroundResource(R.drawable.background_card_fighting)
            "fire" -> card.setBackgroundResource(R.drawable.background_card_fire)
            "flying" -> card.setBackgroundResource(R.drawable.background_card_flying)
            "ghost" -> card.setBackgroundResource(R.drawable.background_card_ghost)
            "grass" -> card.setBackgroundResource(R.drawable.background_card_grass)
            "ground" -> card.setBackgroundResource(R.drawable.background_card_ground)
            "ice" -> card.setBackgroundResource(R.drawable.background_card_ice)
            "normal" -> card.setBackgroundResource(R.drawable.background_card_normal)
            "poison" -> card.setBackgroundResource(R.drawable.background_card_poison)
            "psychic" -> card.setBackgroundResource(R.drawable.background_card_psychic)
            "rock" -> card.setBackgroundResource(R.drawable.background_card_rock)
            "steel" -> card.setBackgroundResource(R.drawable.background_card_steel)
            "water" -> card.setBackgroundResource(R.drawable.background_card_water)
        }
    }
}
