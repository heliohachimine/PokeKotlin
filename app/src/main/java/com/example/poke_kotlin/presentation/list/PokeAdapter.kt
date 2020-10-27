package com.example.poke_kotlin.presentation.list

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
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
import com.example.poke_kotlin.presentation.TypeComponent
import com.example.poke_kotlin.presentation.detail.DetailActivity

class PokeAdapter() : RecyclerView.Adapter<PokeViewHolder>() {

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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.bind(pokemons[position])
        holder.item.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
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

    @RequiresApi(Build.VERSION_CODES.M)
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
